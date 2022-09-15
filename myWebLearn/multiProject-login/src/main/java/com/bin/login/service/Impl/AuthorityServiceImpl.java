package com.bin.login.service.Impl;

import com.bin.common.util.UuidUtil;
import com.bin.login.domain.Authority;
import com.bin.login.mapper.AuthorityMapper;
import com.bin.login.mapper.RoleAndAuthorityMapper;
import com.bin.login.service.AuthorityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName: AuthorityServiceImpl
 * @Description: 权限实现类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityMapper authorityMapper;

    public AuthorityServiceImpl(AuthorityMapper authorityMapper) {
        this.authorityMapper = authorityMapper;
    }

    /**
     * 新增权限信息
     * @param authority
     * @return
     */
    @Override
    public int addAuthority(Authority authority) {
        int i = authorityMapper.insertAuthority(authority);
        return i;
    }


    /**
     * 更新权限信息
     * @param authority
     * @return
     */
    @Override
    public int editAuthority(Authority authority) {
//        authority.setAuthId(UuidUtil.getSimpleUUid());
        int i = authorityMapper.updateAuthority(authority);
        return i;
    }


    /**
     * 删除权限信息
     * @param authId
     * @return
     */
    @Override
    public int removeAuthority(String authId) {
        int i = authorityMapper.deleteAuthority(authId);
        return i;
    }


    /**
     * 查询所有权限信息
     * @return
     */
    @Override
    public List<Authority> selectAllAuthority() {
        Authority authority = new Authority();
        List<Authority> authorities = authorityMapper.selectAllAuthority(authority);
        return authorities;
    }

    /**
     * 通过角色查询权限信息
     * @param roleId
     * @return
     */
    @Override
    public List<Authority> selectByRoleId(String roleId) {
        List<Authority> authorities = authorityMapper.selectByRole(roleId);
        return authorities;
    }
}
