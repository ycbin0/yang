package com.bin.config.security.deal;

import com.bin.common.baseObj.ResultResponse;
import com.bin.login.domain.UserTotal;
import com.bin.login.util.RedisUtil;
import com.bin.login.util.SecurityUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:
 * @Description:
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Component
public class LogoutDealHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String token = request.getHeader("Auth");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String msg = "退出失败";
        if(token == null){
            msg = "请求未带 token";
        }else {
            UserTotal userTotal = SecurityUtil.getUserTotal(token);
            if(RedisUtil.isExistKey(userTotal.getUuid())){
                boolean b = RedisUtil.deleteKey(userTotal.getUuid());
                if(b){
                    msg ="退出成功";
                }
            } else {
                msg = "用户未登录 或 登录已过期";
            }
        }


        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new HashMap(2);
        map.put("msg", msg);
        response.getWriter().write(objectMapper.writeValueAsString(map));
    }
}
