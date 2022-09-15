package com.bin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderUserController {

    @GetMapping("/firstProvider")
    public String firstMethod(){
        System.out.println("自己本");
        return "ProviderUserController 控制类";
    }
}
