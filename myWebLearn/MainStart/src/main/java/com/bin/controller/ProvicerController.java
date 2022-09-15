package com.bin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
public class ProvicerController {

    @Autowired
    private DiscoveryClient discoveryClient;

    // 无效服务端
    @GetMapping("/instance")
    public List<ServiceInstance> showInfo(){
        return this.discoveryClient.getInstances("consumer-movie");
    }
}
