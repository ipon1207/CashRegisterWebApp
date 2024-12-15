package com.example.auto_record.controller.group;

import com.example.auto_record.model.Group;
import com.example.auto_record.service.group.EditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;

/* グループの編集機能 Controller */
@Controller
public class EditController {

    @Autowired
    EditService editService;

    // グループ一覧画面へ遷移
    @GetMapping("/admin/viewGroupList")
    public String getViewGroupList(Model model) {

        List<Group> groupList;

        // グループ一覧を取得
        groupList = editService.searchAll();
        // グループ一覧の並び替え
        groupList.sort(Comparator.comparing(Group::getGroupId));

        model.addAttribute("groupList", groupList);
        return "groupList";
    }

}
