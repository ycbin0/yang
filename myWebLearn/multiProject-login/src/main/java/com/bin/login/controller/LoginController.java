package com.bin.login.controller;

import com.bin.common.baseObj.ResultResponse;
import com.bin.common.util.JwtUtil;
import com.bin.login.domain.LoginUser;
import com.bin.login.domain.UserTotal;
import com.bin.login.service.LoginUserService;
import com.bin.login.util.RedisUtil;
import com.bin.login.util.SecurityUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Api(tags = {"LoginController"}, description = "登录接口")
@RestController
public class LoginController {

    @Autowired
    private LoginUserService loginUserService;

    @Autowired
    private SecurityUtil securityUtil;

    @Value("#{${jwt.expipationTime}}")
    private long expiredTime;

    @PostMapping("/login")
    @ApiOperation("登陆方法")
    public ResultResponse login(@RequestBody LoginUser loginUser) throws JsonProcessingException {
        final String token = securityUtil.login(loginUser.getUsername(), loginUser.getPassword());
        ObjectMapper objectMapper = new ObjectMapper();
        RedisUtil.setKeyAndValueTime(objectMapper.readValue(JwtUtil.getData("user", token).asString(), UserTotal.class).getUuid(), token, expiredTime, TimeUnit.MILLISECONDS);
        return ResultResponse.success(token);
    }

    @GetMapping("/test")
    public LoginUser testHello(UserTotal userTotal){
        return loginUserService.selectLoginUser("ssdfs");
    }

    @GetMapping("/test1")
    public LoginUser testHello1(){
        return loginUserService.selectLoginUser1("ssdfs");
    }

    @ApiOperation("管理员权限")
    @PreAuthorize("hasAuthority('auth_admin')")
    @GetMapping("/admin/test")
    public String adminTest(){
        return "adminTest";
    }

    @ApiOperation("测试方法")
    @PreAuthorize("@auth.hasRole('admin')")
    @GetMapping("/")
    public String home(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return "home";
    }

    @PreAuthorize("hasRole('user')")
    @GetMapping("/admin/exceptionDemo")
    public String exceptionDemo(){
        String a = "123a";
//        int i = Integer.parseInt(a);
//        throw new RuntimeException();
        return "异常";
    }

    @ApiOperation("退出登录")
    @GetMapping("/logoutq")
    public ResultResponse logout(){
        UserTotal user = (UserTotal)SecurityUtil.getUser();
        boolean b = RedisUtil.deleteKey(user.getUuid());
        if(b){
            return ResultResponse.success("退出成功");
        }
        return ResultResponse.error("退出失败");
    }

}
