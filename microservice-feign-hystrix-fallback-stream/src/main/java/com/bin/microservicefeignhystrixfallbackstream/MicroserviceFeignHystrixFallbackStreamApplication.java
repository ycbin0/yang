package com.bin.microservicefeignhystrixfallbackstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

//@EnableHystrixDashboard //开启hystrix 的界面监控
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceFeignHystrixFallbackStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceFeignHystrixFallbackStreamApplication.class, args);
    }

}
