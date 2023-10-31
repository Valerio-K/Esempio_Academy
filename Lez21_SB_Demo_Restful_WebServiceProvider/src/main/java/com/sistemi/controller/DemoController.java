package com.sistemi.controller;

import com.sistemi.bean.MessageBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo-service")
public class DemoController {

    /* La richiesta dovrà essere
    http://localhost:9090/welcome */
    @GetMapping("/welcome")
    public MessageBean getMessage() {

        return new MessageBean("Welcome!");
    }
}
