package com.example.demo;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@RequestMapping("/actuator")
@Controller
public class ActuatorController {
    @Resource
    DiscoveryClient discoveryClient;

    @RequestMapping("/info")
    @ResponseBody
    public String Info() {
        var instance = discoveryClient.getServices();
        var sb = new StringBuilder();
        for (var str : instance) {
            sb.append(str + " ");
        }

        return sb.toString();
    }
}
