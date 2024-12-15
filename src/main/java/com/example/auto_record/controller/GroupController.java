package com.example.auto_record.controller;

import com.example.auto_record.model.Group;
import com.example.auto_record.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GroupController {

    @Autowired
    GroupService groupService;

    // ハッシュ化を行うためのオブジェクト
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

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

    // Group の新規登録
    @PostMapping("/group/register")
    public String postRegister(@ModelAttribute Group registerGroup, Model model) {

        // 入力された password をハッシュ化
        registerGroup.setPassword(encoder.encode(registerGroup.getPassword()));

        // DBに追加
        groupService.register(registerGroup);

        model.addAttribute("loginGroup", new Group());
        return "login";
    }

}
