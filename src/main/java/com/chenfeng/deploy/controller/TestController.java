package com.chenfeng.deploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/")
    public String index() {
        System.out.println("AAAA");
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello,world!";
    }
}

