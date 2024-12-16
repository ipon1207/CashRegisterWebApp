package com.example.auto_record.model.group;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class GroupPrincipal implements UserDetails {

    private final Group group;
    private final Collection<GrantedAuthority> authorities;

    public GroupPrincipal(Group group) {
        this.group = group;
        this.authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_" + group.getRole()));
    }

    // group に付与された権限を返す
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // password を返す
    @Override
    public String getPassword() {
        return group.getPassword();
    }

    // mail を返す
    @Override
    public String getUsername() {
        return group.getMail();
    }

    // アカウント期限切れでないかを示す
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // アカウントがロックされていないかを示す
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 資格情報が期限切れでないかを示す
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // アカウントが有効かを示す
    @Override
    public boolean isEnabled() {
        return true;
    }
}
