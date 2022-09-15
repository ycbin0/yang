package com.bin.login.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName: UserTotal
 * @Description: SpringSecurity 的登录结果类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"enabled","accountNonExpired", "accountNonLocked", "credentialsNonExpired", "authorities", "password", "username"})
public class UserTotal implements UserDetails {

    /**
     * 用户
     */
    private LoginUser loginUser;

    /**
     * 角色数组
     */
    private String[] roles;

    /**
     * 角色集合
     */
    private List<Role> roleList;

    /**
     * 角色权限符数组
     */
    private String[] auths;

    /**
     * 权限集合
     */
    private List<Authority> authorityList;

    /**
     * 存储用户 redis 主键
     */
    private String uuid;

    /**
     * 用户主体的 token 信息
     */
    private String token;

    /**
     * 权限信息
     */
    private Collection<? extends GrantedAuthority> Authorities;

    public UserTotal(String username, String password, Collection<? extends GrantedAuthority> Authorities) {
        this.loginUser = new LoginUser(username, password);
        this.auths = auths;
        this.Authorities = Authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Authorities;
    }

    @Override
    public String getPassword() {
        return loginUser.getPassword();
    }

    @Override
    public String getUsername() {
        return loginUser.getUsername();
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
