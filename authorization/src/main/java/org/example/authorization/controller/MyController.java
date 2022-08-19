package org.example.authorization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("main")
    public String welcomeHome(){
        System.out.println("执行登录方法");
        return "redirect:main.html";
    }
}
