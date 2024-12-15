package com.example.auto_record.service;

import com.example.auto_record.model.Group;
import com.example.auto_record.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    public void register(Group group) {
        groupRepository.save(group);
    }

}
