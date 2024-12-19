package com.example.auto_record.service.group;

import com.example.auto_record.model.Group;
import com.example.auto_record.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class GroupEditService {

    @Autowired
    GroupRepository groupRepository;

    // ハッシュ化を行うためのオブジェクト
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

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

        // 既存のデータを取得
        existingGroup = groupRepository.findByGroupId(group.getGroupId());

        // フィールドを更新
        existingGroup.setGroupName(group.getGroupName());
        existingGroup.setMail(group.getMail());
        existingGroup.setPassword(encoder.encode(group.getPassword()));
        existingGroup.setRole(group.getRole());

        // LocalDateTimeをフォーマットしてString型のcreatedAtに設定
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd/HH:mm");
        existingGroup.setCreatedAt(LocalDateTime.now().format(formatter));

        // データを更新
        groupRepository.save(existingGroup);
    }

    // Group テーブルの1件削除
    public void deleteOne(Integer groupId) {

        groupRepository.deleteByGroupId(groupId);

    }
}
