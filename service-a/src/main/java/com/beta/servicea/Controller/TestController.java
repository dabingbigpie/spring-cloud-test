package com.beta.servicea.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {
    @Value("${server.port}")
    private String port;
    @Value("${name}")
    private String name;

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/hello")
    public String hello(){
        return "hello啊" + "端口："+ port;
    }

    String fallback(){
        return "服务器繁忙";
    }


    @RequestMapping("/hello2")
    String hello2() {
        return name;
    }
}
