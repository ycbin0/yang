package com.bin.user.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CustomizeEndPoint
 * @Description: 自定义的 endPoint
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Component
@Endpoint(id = "bin")
public class CustomizeEndPoint {

    @ReadOperation
    public String endPointRead(String content){
        return "请求内容是：" + content;
    }
}
