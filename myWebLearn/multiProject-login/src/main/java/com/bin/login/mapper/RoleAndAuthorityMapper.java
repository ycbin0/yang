package com.bin.login.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName:
 * @Description:
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Mapper
public interface RoleAndAuthorityMapper {

    /**'
     * 插入用户和角色关联关系
     * @param roleId
     * @param auths
     * @return
     */
    public int insertRoleAndAuthority(@Param("roleId") String roleId, @Param("auths") String[] auths);


    /**
     * 删除原本的用户关联
     * @param roleId
     * @return
     */
    public int deleteRoleAndAuthority(@Param("roleId") String roleId);


}
