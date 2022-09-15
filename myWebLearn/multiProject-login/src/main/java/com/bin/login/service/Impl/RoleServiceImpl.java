package com.bin.login.service.Impl;

import com.bin.common.util.UuidUtil;
import com.bin.login.domain.Role;
import com.bin.login.mapper.RoleAndAuthorityMapper;
import com.bin.login.mapper.RoleMapper;
import com.bin.login.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName: RoleServiceImpl
 * @Description: 角色实现类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleAndAuthorityMapper roleAndAuthorityMapper;

    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleAndAuthorityMapper roleAndAuthorityMapper, RoleMapper roleMapper) {
        this.roleAndAuthorityMapper = roleAndAuthorityMapper;
        this.roleMapper = roleMapper;
    }


    /**
     * 获取对应用户的角色列表
     * @return
     */
    @Override
    public List<Role> selectAllRole() {
        return null;
    }

    /**
     * 新增新的角色
     * @return
     */
    @Override
    public int addRole(Role role) {
        role.setRoleId(UuidUtil.getSimpleUUid());
        int i = roleMapper.insertRole(role);
        if(role.getAuths() != null ? role.getAuths().length > 0 : false){
            i = roleAndAuthorityMapper.insertRoleAndAuthority(role.getRoleId(), role.getAuths());
        }
        return i;
    }

    /**
     * 删除指定角色
     * @return
     */
    @Transactional
    @Override
    public int removeRole(String roleId) {
        roleAndAuthorityMapper.deleteRoleAndAuthority(roleId);
        int i = roleMapper.deleteRole(roleId);
        return i;
    }


    /**
     * 修改角色信息
     * @param role
     * @return
     */
    @Transactional
    @Override
    public int editRole(Role role) {
        roleAndAuthorityMapper.deleteRoleAndAuthority(role.getRoleId());
        roleAndAuthorityMapper.insertRoleAndAuthority(role.getRoleId(), role.getAuths());
        int i = roleMapper.updateRole(role);
        return i;
    }


    /**
     * 根据用户获取角色信息
     * @param userId
     * @return
     */
    @Override
    public List<Role> selectByUserId(Integer userId) {
        List<Role> roles = roleMapper.selectByUserId(userId);
        return roles;
    }
}
