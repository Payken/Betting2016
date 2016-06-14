package com.ai.config;

import com.ai.controllers.SearchController;
import com.ai.domain.Role;
import com.ai.domain.User;
import com.ai.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.switchuser.SwitchUserGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by fdarmoch on 2016-01-13.
 */

public class UserDet implements UserDetails {

    @Autowired
    RoleRepository roleRepository;

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;
    private Integer id;

    public UserDet(User user) {
        username = user.getLogin();
        password = user.getPassword();
        authorities = new ArrayList<GrantedAuthority>();
        id = user.getId();
//        for(Role role : worker.getRoles()) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }

authorities.add(new SimpleGrantedAuthority(user.getRole().getType()));
        System.out.println(authorities.size());
        System.out.println(authorities.get(0).toString());
        System.out.println(id);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
