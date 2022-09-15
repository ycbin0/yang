package com.bin.common.exception;

import com.bin.common.baseObj.ResultResponse;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: GlobalException
 * @Description: 全局异常捕捉类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */

@RestControllerAdvice // 针对 spring 管理的类，可指定 basePacket
public class GlobalException {

    // 似乎比 springSecurity 的无权限处理器优先级高，不启用
//    /*
//    @ExceptionHandler({AccessDeniedException.class})
//    public ResultResponse ExceptionDemo(Exception e){
//        System.out.println("您无当前权限进入");
//        return ResultResponse.error("您无当前权限进入");
//    }*/

    @ExceptionHandler({NumberFormatException.class})
    public String ExceptionDemo1(Exception e){
        System.out.println("自定义异常实验Number");
        return "自定义异常实验Number";
    }

    /**
     * 用户名不存在
     * @param e
     * @return
     */
    @ExceptionHandler({UserNameNotFoundException.class})
    public ResultResponse notFoundUserName(UserNameNotFoundException e){
        System.out.println("未找到用户名");
        return ResultResponse.error("未找到用户名");
    }

    /**
     * 密码错误
     * @param e
     * @return
     */
    @ExceptionHandler({PasswordErrorException.class})
    public ResultResponse errorPassword(PasswordErrorException e){
        System.out.println("密码错误");
        return ResultResponse.error("密码错误");
    }

    /**
     * token 在 redis 中不存在
     * @param e
     * @return
     */
    @ExceptionHandler({TokenNotFoundException.class})
    public ResultResponse toeknNotFound(TokenNotFoundException e){
        System.out.println("redis 中未找到token信息");
        return ResultResponse.error("redis 中未找到token信息");
    }

}

