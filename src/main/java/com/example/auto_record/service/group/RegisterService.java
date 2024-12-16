package com.example.auto_record.service.group;

import com.example.auto_record.model.group.Group;
import com.example.auto_record.repository.group.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    GroupRepository groupRepository;

    // group を追加
    public void register(Group group) {
        groupRepository.save(group);
    }

}
