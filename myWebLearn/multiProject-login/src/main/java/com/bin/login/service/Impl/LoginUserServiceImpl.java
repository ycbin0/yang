package com.bin.login.service.Impl;

import com.bin.common.datasource.DataSourceKey;
import com.bin.common.datasource.DbSource;
import com.bin.common.util.JwtUtil;
import com.bin.login.domain.Authority;
import com.bin.login.domain.LoginUser;
import com.bin.login.domain.Role;
import com.bin.login.domain.UserTotal;
import com.bin.login.mapper.LoginUserAndRoleMapper;
import com.bin.login.mapper.LoginUserMapper;
import com.bin.login.service.AuthorityService;
import com.bin.login.service.LoginUserService;
import com.bin.login.service.RoleService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: LoginUserServiceImpl
 * @Description: 用户业务实现类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Service
public class LoginUserServiceImpl implements LoginUserService {

    private final LoginUserMapper loginUserMapper;

    private final LoginUserAndRoleMapper loginUserAndRoleMapper;

    public LoginUserServiceImpl(LoginUserMapper loginUserMapper, LoginUserAndRoleMapper loginUserAndRoleMapper) {
        this.loginUserMapper = loginUserMapper;
        this.loginUserAndRoleMapper = loginUserAndRoleMapper;
    }


    /**
     * 多数据源切换  解决事务导致多数据源切换失败
     * @param username
     * @return
     */
    @DbSource(value = DataSourceKey.db1)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public LoginUser selectLoginUser1(String username) {
        LoginUser login = new LoginUser();
        login.setUserId(1);
        return loginUserMapper.selectOneLoginUser(login);
    }

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    @Override
    public LoginUser selectLoginUser(String username) {
        LoginUser login = new LoginUser();
        login.setUsername(username);
        return loginUserMapper.selectOneLoginUser(login);
    }

    /**
     * 新增用户
     * @param userTotal
     * @return
     */
    @Transactional
    @Override
    public int addLoginUser(UserTotal userTotal) {
        // 插入用户信息
        int i = loginUserMapper.insertLoginUser(userTotal.getLoginUser());
        if(userTotal.getRoles() != null ? userTotal.getRoles().length > 0 : false){
            i = loginUserAndRoleMapper.insertLoginAndRole(userTotal.getLoginUser().getUserId(), userTotal.getRoles());
        }
        return i;
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @Transactional
    @Override
    public int removeLoginUser(Integer userId) {
        loginUserMapper.deleteLoginUser(userId);
        int i = loginUserAndRoleMapper.deleteLoginAndRole(userId);
        return i;
    }


    /**
     * 更新用户信息
     * @param userTotal
     * @return
     */
    @Transactional
    @Override
    public int editLoginUser(UserTotal userTotal) {
        loginUserAndRoleMapper.deleteLoginAndRole(userTotal.getLoginUser().getUserId());
        loginUserAndRoleMapper.insertLoginAndRole(userTotal.getLoginUser().getUserId(), userTotal.getRoles());
        int i = loginUserMapper.updateLoginUser(userTotal.getLoginUser());
        return i;
    }
}
