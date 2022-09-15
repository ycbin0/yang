package com.bin.microservicesimpleconsumermovie.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "bin-Learn", fallbackFactory = FeignConsumer.class)
public interface FeignConsumerController {

    @GetMapping("/firstProvider")
    public String feignConsumer();
}
