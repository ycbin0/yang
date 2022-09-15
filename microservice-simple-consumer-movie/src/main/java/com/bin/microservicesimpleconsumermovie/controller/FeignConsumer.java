package com.bin.microservicesimpleconsumermovie.controller;

import feign.Feign;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignConsumer implements FallbackFactory<FeignConsumerController> {

    @Override
    public FeignConsumerController create(Throwable cause) {
        return new FeignConsumerController() {
            @Override
            public String feignConsumer() {
                return "Feign 容错机制启用";
            }
        };
    }
}
