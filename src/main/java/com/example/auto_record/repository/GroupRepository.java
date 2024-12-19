package com.example.auto_record.repository;

import com.example.auto_record.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    // mail で1件取得
    Group findByMail(String mail);

    // groupId で1件取得
    Group findByGroupId(Integer groupId);

    // groupId で1件削除
    @Transactional
    void deleteByGroupId(Integer groupId);

}
