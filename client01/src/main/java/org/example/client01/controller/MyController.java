package org.example.client01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping("/user/info")
    @ResponseBody
    public String user(){
        System.out.println("执行user方法");
        return "用户信息";
    }
}
