package com.bin.login.mapper;

import com.bin.login.domain.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoginUserMapper {

    /**
     * 对于查询单条可以保留适当的字段
     * @param loginUser
     * @return
     */
    public LoginUser selectOneLoginUser(LoginUser loginUser);

    /**
     * 查询全部类似单条
     * @param loginUser
     * @return
     */
    public List<LoginUser> selectAllLoginUser(LoginUser loginUser);

    /**
     * 插入新的用户数据
     * @param loginUser
     * @return
     */
    public int insertLoginUser(LoginUser loginUser);

    /**
     * 更新用户信息
     * @param loginUser
     * @return
     */
    public int updateLoginUser(LoginUser loginUser);

    /**
     * 删除指定用户
     * @param userId
     * @return
     */
    public int deleteLoginUser(@Param("userId") Integer userId);
}
