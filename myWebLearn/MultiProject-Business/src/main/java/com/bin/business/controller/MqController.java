package com.bin.business.controller;

import com.bin.common.baseObj.ResultResponse;
import com.bin.mq.sender.Sender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: MqController
 * @Description: mq 测试类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@RestController
@RequestMapping("/mq")
@Api(tags = {"MqController"}, description = "mq 的测试类")
public class MqController {

    private final Sender sender;

    public MqController(Sender sender) {
        this.sender = sender;
    }

    @GetMapping("/testQueue")
    @ApiOperation("测试队列发送")
    public ResultResponse testMqTest(){
        sender.send();
        return ResultResponse.success();
    }
}
