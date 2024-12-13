package com.example.auto_record.controller;

import com.example.auto_record.model.Group;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroupController {

    // ログイン画面に遷移
    @GetMapping("/")
    public String getLogin(Model model) {

        model.addAttribute("inputGroup", new Group());
        return "login";
    }

}
