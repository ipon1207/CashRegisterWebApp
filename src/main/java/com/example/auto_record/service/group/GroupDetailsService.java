package com.example.auto_record.service.group;

import com.example.auto_record.model.Group;
import com.example.auto_record.model.GroupPrincipal;
import com.example.auto_record.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GroupDetailsService implements UserDetailsService {

    @Autowired
    GroupRepository groupRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {

        Group group;

        // 1件取得
        group = groupRepository.findByMail(mail);

        // 検索結果を検証
        if(group == null) {
            System.out.println("Group Not Found");
            throw new UsernameNotFoundException("Group Not Found");
        }

        return new GroupPrincipal(group);
    }
}
