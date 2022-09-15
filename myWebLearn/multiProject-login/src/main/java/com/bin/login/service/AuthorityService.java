package com.bin.login.service;

import com.bin.login.domain.Authority;

import java.util.List;
import java.util.Set;

/**
 * @ClassName: AuthorityService
 * @Description: 权限接口类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
public interface AuthorityService {

    /**
     * 新增权限信息
     * @param authority
     * @return
     */
    public int addAuthority(Authority authority);

    /**
     * 更新权限信息
     * @param authority
     * @return
     */
    public int editAuthority(Authority authority);

    /**
     * 删除权限信息
     * @param authId
     * @return
     */
    public int removeAuthority(String authId);

    /**
     * 查询所有权限信息
     * @return
     */
    public List<Authority> selectAllAuthority();

    /**
     * 通过角色查询权限信息
     * @param roleId
     * @return
     */
    public List<Authority> selectByRoleId(String roleId);
}
