package com.twb.user_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="order-service")
public interface FeignApiCaller {
    @GetMapping("/order/hello")
    String getOrderHello();
}
