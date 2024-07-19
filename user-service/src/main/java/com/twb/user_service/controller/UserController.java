package com.twb.user_service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.twb.user_service.FeignApiCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
    private RestTemplate restTemplate;
   @Autowired
   private FeignApiCaller feignApiCaller;
    @GetMapping("/hello")
    public String hello() {
        return "Hello from User Service";
    }
    @GetMapping("/getOrderTest")
    public String getOrder() {
//        return restTemplate.getForObject("http://order-service/order/hello", String.class);
        return feignApiCaller.getOrderHello();
    }
}
