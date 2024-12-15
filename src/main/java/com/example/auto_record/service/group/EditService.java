package com.example.auto_record.service.group;

import com.example.auto_record.model.Group;
import com.example.auto_record.repository.group.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditService {

    @Autowired
    GroupRepository groupRepository;

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
}
