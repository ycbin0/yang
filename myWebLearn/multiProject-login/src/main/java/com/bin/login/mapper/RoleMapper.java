package com.bin.login.mapper;

import com.bin.login.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {

    /**
     * 对于查询单条可以保留适当的字段
     * @param role
     * @return
     */
    public Role selectOneRole(Role role);

    /**
     * 查询全部类似单条
     * @param role
     * @return
     */
    public List<Role> selectAllRole(Role role);

    /**
     * 插入新的用户数据
     * @param role
     * @return
     */
    public int insertRole(Role role);

    /**
     * 更新用户信息
     * @param role
     * @return
     */
    public int updateRole(Role role);

    /**
     * 删除指定用户
     * @param roleId
     * @return
     */
    public int deleteRole(@Param("roleId") String roleId);


    /**
     * 根据用户获取角色信息
     * @param userId
     * @return
     */
    public List<Role> selectByUserId(@Param("userId") Integer userId);
}
