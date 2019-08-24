package com.chenfeng.deploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @GetMapping("/time")
    @ResponseBody
    public String now(String pattern) {
        if (pattern == null) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            return df.format(new Date());
        }
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(new Date());
    }
}

