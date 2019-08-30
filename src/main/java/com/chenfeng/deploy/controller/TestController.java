package com.chenfeng.deploy.controller;

import com.chenfeng.deploy.util.JsonUtil;
import com.chenfeng.deploy.util.OcrUtil;
import com.chenfeng.deploy.util.TimeTransferUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello,world!";
    }

    // 返回当前时间
    @GetMapping("/getTime")
    @ResponseBody
    public String now(String pattern) {
        return TimeTransferUtil.transferTime(pattern);
    }

    @GetMapping("/ocr")
    @ResponseBody
    public String getOcrResult(String picUrl) {
        return OcrUtil.getOcrResult(picUrl);
    }

    /*@PostMapping("/ocr2")
    @ResponseBody
    public String getOcrResult2(String picUrl) {
        return OcrUtil.getOcrResult(picUrl);
    }*/

}

