package com.example.auto_record.controller.group;

import com.example.auto_record.model.group.Group;
import com.example.auto_record.service.group.GroupEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;

/* グループの編集機能 Controller */
@Controller
public class GroupEditController {

    @Autowired
    GroupEditService groupEditService;

    // グループ一覧画面へ遷移
    @GetMapping("/admin/viewGroupList")
    public String getViewGroupList(Model model) {

        List<Group> groupList;

        // グループ一覧を取得
        groupList = groupEditService.searchAll();
        // グループ一覧の並び替え
        groupList.sort(Comparator.comparing(Group::getGroupId));

        model.addAttribute("groupList", groupList);
        return "groupList";
    }

    // グループ編集画面へ遷移
    @PostMapping("/admin/viewGroupEdit")
    public String postGroupEdit(@RequestParam("id") Integer editId, Model model) {

        Group editGroup;

        editGroup = groupEditService.searchOne(editId);

        model.addAttribute("editGroup", editGroup);
        return "groupEdit";
    }

    // グループ情報を変更
    @PostMapping("/admin/groupEdit")
    public String postGroupEdit(@ModelAttribute Group editGroup, Model model) {

        List<Group> groupList;

        // グループ情報を変更
        groupEditService.updateOne(editGroup);
        // グループ情報を全件取得
        groupList = groupEditService.searchAll();
        groupList.sort(Comparator.comparing(Group::getGroupId));

        model.addAttribute("groupList", groupList);
        return "groupList";
    }

    // グループ情報を削除
    @PostMapping("/admin/delete")
    public String postDelete(@RequestParam("id") Integer deleteId, Model model) {

        List<Group> groupList;

        // グループ情報を削除
        groupEditService.deleteOne(deleteId);
        // グループ情報を全件取得
        groupList = groupEditService.searchAll();
        groupList.sort(Comparator.comparing(Group::getGroupId));

        model.addAttribute("groupList", groupList);
        return "groupList";

    }

}
