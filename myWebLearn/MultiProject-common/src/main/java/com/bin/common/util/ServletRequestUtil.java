package com.bin.common.util;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: ServletRequestUtil
 * @Description: 全局获取 request 请求
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
public class ServletRequestUtil {

    /**
     * 获取请求
     * @return
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return servletRequestAttributes.getRequest();
    }

    /**
     * 获取响应
     * @return
     */
    public static HttpServletResponse getResponse(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return servletRequestAttributes.getResponse();
    }

    /**
     * 获取请求参数
     * @param para
     * @return
     */
    public static Object getPara(String para){
        return getRequest().getParameter(para);
    }
}
