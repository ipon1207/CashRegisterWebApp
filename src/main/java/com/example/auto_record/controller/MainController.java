package com.example.auto_record.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // login.htmlに遷移
    @GetMapping("/toLogin")
    public String getLogin() {
        return "login";
    }

    // main.html に遷移
    @GetMapping("/main")
    public String getMain(){
        return "main";
    }

    // admin.html に遷移
    @GetMapping("/admin")
    public String getAdmin(){
        return "admin";
    }

}
