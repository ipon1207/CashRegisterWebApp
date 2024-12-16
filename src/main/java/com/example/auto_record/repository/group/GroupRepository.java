package com.example.auto_record.repository.group;

import com.example.auto_record.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    // mail で1件取得
    public Group findByMail(String mail);

    // groupId で1件取得
    public Group findByGroupId(Integer groupId);

    // groupId で1件削除
    public void deleteByGroupId(Integer groupId);

}
