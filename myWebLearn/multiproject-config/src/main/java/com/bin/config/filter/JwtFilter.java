package com.bin.config.filter;

import com.bin.common.exception.TokenNotFoundException;
import com.bin.common.util.JwtUtil;
import com.bin.login.domain.UserTotal;
import com.bin.login.util.RedisUtil;
import com.bin.login.util.SecurityUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName: JwtFilter
 * @Description: 验证头是否存在token，验证token（要放在 UsernamePasswordAuthenticationFilter 过滤器之前）
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
public class JwtFilter extends BasicAuthenticationFilter {


    public JwtFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    /**
     * 当不存在token，放行会进入下一步的用户验证（UsernamePasswordAuthenticationFilter 进行验证登录），存在token，则存入用户已通过验证信息（通过token解析得出结果）
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String token = request.getHeader("Auth");
        if(token != null && !"".equals(token)){
            if(!JwtUtil.verity(token)){
                System.out.println("token 校验失败");
                return;
            }
            ObjectMapper objectMapper = new ObjectMapper();
            if(!JwtUtil.isExpired(token)){
                // 解析token中的信息
                UserTotal userTotal = SecurityUtil.getUserTotal(token);

                // 查询 redis 中是否存在 token 信息
                String redisToken = (String) RedisUtil.getValue(userTotal.getUuid());

                if(redisToken == null){
                    throw new TokenNotFoundException("redis 中不存在 token");
                }
                userTotal = SecurityUtil.getUserTotal(redisToken);


                String[] auths = userTotal.getAuths();
                List<GrantedAuthority> authorityList = new ArrayList<>();
                Arrays.stream(auths).forEach(item -> {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(item);
                    authorityList.add(grantedAuthority);
                });
                userTotal.setAuthorities(authorityList);

                // 创建用户名密码登录令牌
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userTotal, null, userTotal.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            } else {
                System.out.println("token 已过期");
            }
        }
        chain.doFilter(request,response);
    }

}
