package com.bin.login.mapper;

import com.bin.login.domain.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthorityMapper {

    /**
     * 对于查询单条可以保留适当的字段
     * @param authority
     * @return
     */
    public Authority selectOneAuthority(Authority authority);

    /**
     * 查询全部类似单条
     * @param authority
     * @return
     */
    public List<Authority> selectAllAuthority(Authority authority);

    /**
     * 插入新的用户数据
     * @param authority
     * @return
     */
    public int insertAuthority(Authority authority);

    /**
     * 更新用户信息
     * @param authority
     * @return
     */
    public int updateAuthority(Authority authority);

    /**
     * 删除指定用户
     * @param authorityId
     * @return
     */
    public int deleteAuthority(@Param("authorityId") String authorityId);

    /**
     * 通过角色查找权限
     * @param roleId
     * @return
     */
    public List<Authority> selectByRole(@Param("roleId") String roleId);
}
