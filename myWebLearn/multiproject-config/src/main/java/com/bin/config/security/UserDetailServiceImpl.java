package com.bin.config.security;

import com.bin.login.domain.Authority;
import com.bin.login.domain.LoginUser;
import com.bin.login.domain.Role;
import com.bin.login.domain.UserTotal;
import com.bin.login.service.AuthorityService;
import com.bin.login.service.LoginUserService;
import com.bin.login.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: UserDetailServiceImpl
 * @Description: springSecurity实现用户认证核心逻辑
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private LoginUserService loginUserService;
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private AuthorityService authorityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username == null || "".equals(username)){
            throw new RuntimeException("用户名不能为空");
        }
        LoginUser loginUser = loginUserService.selectLoginUser(username);
        if(loginUser == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        Set<String> authoritySet = new HashSet<>();
        List<Role> roles = roleService.selectByUserId(loginUser.getUserId());
        roles.stream().forEach(item -> {
            List<Authority> authorities = authorityService.selectByRoleId(item.getRoleId());
            authorities.forEach(authority -> authoritySet.add(authority.getAuthCode()));
        });
        System.out.println("该用户的权限是：" + authoritySet);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authoritySet.stream().forEach(item -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(item);
            authorityList.add(grantedAuthority);
        });

        return new UserTotal(loginUser.getUsername(), loginUser.getPassword(), authorityList);
    }
}
