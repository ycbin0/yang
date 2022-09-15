package com.bin.config.filter;

import com.bin.common.util.JwtUtil;
import com.bin.common.util.RequestBodyUtil;
import com.bin.login.domain.LoginUser;
import com.bin.login.domain.UserTotal;
import com.bin.login.service.LoginUserService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: UserNamePassWordAuthentication
 * @Description: 用于登录认证（第二种方法中不使用）
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
public class UserNamePassWordAuthentication extends UsernamePasswordAuthenticationFilter {

    public UserNamePassWordAuthentication(AuthenticationManager authenticationManager) {
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String requestBody = RequestBodyUtil.getRequestBody(request);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        LoginUser loginUser = null;
        try{
            loginUser = objectMapper.readValue(requestBody, LoginUser.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return this.getAuthenticationManager().authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("登录成功");
        super.successfulAuthentication(request,response,chain,authResult);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Object principal = authentication.getPrincipal();
//        response.setContentType("application/json;charset=UTF-8");
//        ServletOutputStream outputStream = response.getOutputStream();
//
//        Map<String, String> map = new HashMap<>(2);
//        map.put("msg", "success");
//
//        outputStream.write(new ObjectMapper().writeValueAsBytes(map));
//        outputStream.flush();
//        outputStream.close();

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        System.out.println("登录失败");
        super.unsuccessfulAuthentication(request,response,failed);
//        response.setContentType("application/json;charset=UTF-8");
//        ServletOutputStream outputStream = response.getOutputStream();
//
//        Map<String, String> map = new HashMap<>(2);
//        map.put("msg", "err");
//
//        outputStream.write(new ObjectMapper().writeValueAsBytes(map));
//        outputStream.flush();
//        outputStream.close();
    }
}
