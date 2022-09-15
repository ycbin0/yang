package com.bin.business.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: NacosController
 * @Description: nacos 控制层
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@RestController
@Api(tags = {"NacosController"}, description = "nacos 测试类")
@RequestMapping("/nacos")
public class NacosController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @GetMapping(value = "/get")
    @ResponseBody
    @ApiOperation("测试")
    public boolean get() {
        return useLocalCache;
    }
}
