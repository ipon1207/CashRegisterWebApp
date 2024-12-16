package com.example.auto_record.controller.group;

import com.example.auto_record.model.group.Group;
import com.example.auto_record.service.group.GroupRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

/* Group の新規登録 Controller */
@Controller
public class GroupRegisterController {

    @Autowired
    GroupRegisterService groupRegisterService;

    // ハッシュ化を行うためのオブジェクト
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    // register.html に遷移
    @GetMapping("/admin/viewRegister")
    public String getViewRegister(Model inputModel) {
        inputModel.addAttribute("registerGroup", new Group());
        return "groupRegister";
    }

    // Group の新規登録
    @PostMapping("/admin/register")
    public String postRegister(@ModelAttribute Group registerGroup, Model model) {

        // 入力された password をハッシュ化
        registerGroup.setPassword(encoder.encode(registerGroup.getPassword()));
        // createdAt を set
        registerGroup.setCreatedAt(LocalDateTime.now());

        // DBに追加
        groupRegisterService.register(registerGroup);

        model.addAttribute("loginGroup", new Group());
        return "login";
    }

}
