package com.example.auto_record.controller.group;

import com.example.auto_record.model.Group;
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

    // 団体名で昇順並び替え
    @GetMapping("/admin/groupList/sortName")
    public String sortName(Model model) {

        List<Group> groupList;

        // 商品データの取得
        groupList = groupEditService.searchAll();
        groupList.sort(Comparator.comparing(Group::getGroupName));

        model.addAttribute("groupList", groupList);
        return "groupList";
    }

    // 団体名で降順並び替え
    @GetMapping("/admin/groupList/sortNameInv")
    public String sortNameInv(Model model) {

        List<Group> groupList;

        // 商品データの取得
        groupList = groupEditService.searchAll();
        groupList.sort(Comparator.comparing(Group::getGroupName).reversed());

        model.addAttribute("groupList", groupList);
        return "groupList";
    }

    // メールアドレスで昇順並び替え
    @GetMapping("/admin/groupList/sortMail")
    public String sortMail(Model model) {

        List<Group> groupList;

        // 商品データの取得
        groupList = groupEditService.searchAll();
        groupList.sort(Comparator.comparing(Group::getMail));

        model.addAttribute("groupList", groupList);
        return "groupList";
    }

    // メールアドレスで降順並び替え
    @GetMapping("/admin/groupList/sortMailInv")
    public String sortMailInv(Model model) {

        List<Group> groupList;

        // 商品データの取得
        groupList = groupEditService.searchAll();
        groupList.sort(Comparator.comparing(Group::getMail).reversed());

        model.addAttribute("groupList", groupList);
        return "groupList";
    }

    // 権限で昇順並び替え
    @GetMapping("/admin/groupList/sortRole")
    public String sortRole(Model model) {

        List<Group> groupList;

        // 商品データの取得
        groupList = groupEditService.searchAll();
        groupList.sort(Comparator.comparing(Group::getRole));

        model.addAttribute("groupList", groupList);
        return "groupList";
    }

    // 権限で降順並び替え
    @GetMapping("/admin/groupList/sortRoleInv")
    public String sortRoleInv(Model model) {

        List<Group> groupList;

        // 商品データの取得
        groupList = groupEditService.searchAll();
        groupList.sort(Comparator.comparing(Group::getRole).reversed());

        model.addAttribute("groupList", groupList);
        return "groupList";
    }

    // 作成更新日時で昇順並び替え
    @GetMapping("/admin/groupList/sortAt")
    public String sortAt(Model model) {

        List<Group> groupList;

        // 商品データの取得
        groupList = groupEditService.searchAll();
        groupList.sort(Comparator.comparing(Group::getCreatedAt));

        model.addAttribute("groupList", groupList);
        return "groupList";
    }

    // メールアドレスで降順並び替え
    @GetMapping("/admin/groupList/sortAtInv")
    public String sortAtInv(Model model) {

        List<Group> groupList;

        // 商品データの取得
        groupList = groupEditService.searchAll();
        groupList.sort(Comparator.comparing(Group::getCreatedAt).reversed());

        model.addAttribute("groupList", groupList);
        return "groupList";
    }


}
