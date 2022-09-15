package com.bin.login.service;

import com.bin.login.domain.Role;

import java.util.List;
import java.util.Set;

/**
 * @ClassName: RoleService
 * @Description: 角色接口类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
public interface RoleService {

    /**
     * 获取对应用户的角色列表
     * @return
     */
     public List<Role> selectAllRole();

    /**
     * 新增新的角色
     * @return
     */
    public int addRole(Role role);

    /**
     * 删除指定角色
     * @return
     */
    public int removeRole(String roleId);

    /**
     * 修改角色信息
     * @param role
     * @return
     */
    public int editRole(Role role);

    /**
     * 根据用户获取角色信息
     * @param userId
     * @return
     */
    public List<Role> selectByUserId(Integer userId);
}
