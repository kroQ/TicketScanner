package com.krok.springboot.dao;

import com.krok.data.UserRoleData;
import com.krok.springboot.dao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mateusz Krok on 2018-06-06
 */
@Service("userDetailsService")
public class MyUserDetailsDAO implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
        System.out.print("AUTORYZACJA Przyszedl nick: " + username);
        com.krok.data.UserData user = userService.getUserToLogin(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
        System.out.println(" ma tyle roli: " + user.getUserRole().size());
        return buildUserForAuthentication(user, authorities);

    }

    // Converts com.krok.data.UserData user to
    // org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(com.krok.data.UserData user,
                                            List<GrantedAuthority> authorities) {
        System.out.println("AUTORYZACJA Budowanie nicku: " + user.getLogin());
        return new User(user.getLogin(), user.getPassword(),
                true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRoleData> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (UserRoleData userRole : userRoles) {
            System.out.println("AUTORYZACJA Pobranie roli: " + userRole.getUserData().getLogin());
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

}