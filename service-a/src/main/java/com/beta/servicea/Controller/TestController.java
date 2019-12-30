package com.beta.servicea.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    private String port;

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/hello")
    public String hello(){
        return "hello" + "端口："+ port;
    }

    String fallback(){
        return "服务器繁忙";
    }
}
