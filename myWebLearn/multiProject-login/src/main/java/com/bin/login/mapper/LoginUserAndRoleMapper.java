package com.bin.login.mapper;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName:
 * @Description:
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Mapper
public interface LoginUserAndRoleMapper {

    /**'
     * 插入用户和角色关联关系
     * @param userId
     * @param roles
     * @return
     */
    public int insertLoginAndRole(@Param("userId") Integer userId, @Param("roles") String[] roles);


    /**
     * 删除原本的用户关联
     * @param userId
     * @return
     */
    public int deleteLoginAndRole(@Param("userId") Integer userId);


}
