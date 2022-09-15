package com.bin.microservicesimpleconsumermovie.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerMovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private FeignConsumerController feignConsumerController;

//    @HystrixCommand(fallbackMethod = "findNoneBack")
    @HystrixCommand(fallbackMethod = "findNoneBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000")
    },
    threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "1"),
            @HystrixProperty(name = "maxQueueSize", value = "10")
    })
    @GetMapping("/consumer")
    public String consumerMoview(){
        return this.restTemplate.getForObject("http://bin-Learn/firstProvider", String.class);
    }

    @GetMapping("/instance")
    public List<ServiceInstance> showInfo(){
        return this.discoveryClient.getInstances("consumer-movie");
    }

    @GetMapping("/loadBlanced")
    public void logUserInstance(){
        ServiceInstance choose = this.loadBalancerClient.choose("bin-Learn");
        System.out.println(choose.getHost() + ":" + choose.getPort() + ":" + choose.getServiceId());
    }

//    @GetMapping("/firstProvider")
//    public String firstMethod(){
//        System.out.println("consumer 消费者");
//        return "ProviderUserController 控制类";
//    }
    public String findNoneBack(){
        return "服务器已经瘫痪";
    }

    @GetMapping("/feignConsumer")
    public String feignConsumer(){
        return this.feignConsumerController.feignConsumer();
    }
}
