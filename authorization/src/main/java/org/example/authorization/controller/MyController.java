package org.example.authorization.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

//    @Secured("ROLE_abc")
    //ROLE_前缀要不要都可以
    @PreAuthorize("hasRole('ROLE_abc')")
    @RequestMapping("toMain")
    public String welcomeHome(){
        System.out.println("执行welcomeHome方法");
        return "redirect:main.html";
    }

    @RequestMapping("toError")
    public String toError(){
        System.out.println("执行welcomeHome方法");
        return "redirect:error.html";
    }
    @RequestMapping("/user/info")
    @ResponseBody
    public String user(){
        System.out.println("执行user方法");
        return "用户信息";
    }
}
