package com.example.auto_record.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    // トップページを表示
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

}
