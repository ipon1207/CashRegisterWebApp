package com.example.auto_record.service.group;

import com.example.auto_record.model.group.Group;
import com.example.auto_record.repository.group.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EditService {

    @Autowired
    GroupRepository groupRepository;

    // Groups テーブルの全件取得
    public List<Group> searchAll()  {

        List<Group> result;

        result = groupRepository.findAll();

        // 実行結果の検証
        if(result.isEmpty()) {
            System.out.println("GroupList is Not Found");
            throw new IllegalArgumentException("GroupList is Not Found");
        }

        return result;
    }

    // Groups テーブルを groupId で1件取得
    public Group searchOne(Integer groupId) {

        Group result;

        result = groupRepository.findByGroupId(groupId);

        // 実行結果の検証
        if (result == null) {
            System.out.println("Group is Not Found");
            throw new IllegalArgumentException("Group is Not Found");
        }

        return result;

    }

    // Group テーブルの1件変更
    public void updateOne(Group group) {

        Group existingGroup;

        // 既存のデータを上書き
        existingGroup = groupRepository.findByGroupId(group.getGroupId());
        existingGroup.setGroupName(group.getGroupName());
        existingGroup.setMail(group.getMail());
        existingGroup.setPassword(group.getPassword());
        existingGroup.setRole(group.getRole());
        existingGroup.setCreatedAt(group.getCreatedAt());

        groupRepository.save(existingGroup);

    }

    // Group テーブルの1件削除
    @Transactional
    public void deleteOne(Integer groupId) {

        groupRepository.deleteByGroupId(groupId);

    }
}
