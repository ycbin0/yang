package com.bin.login.service;

import com.bin.login.domain.Authority;
import com.bin.login.domain.LoginUser;
import com.bin.login.domain.UserTotal;

import java.util.Set;

/**
 * @ClassName: LoginUserService
 * @Description: 用户接口类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
public interface LoginUserService {


    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    public LoginUser selectLoginUser(String username);


    /**
     * 多数据源切换  解决事务导致多数据源切换失败
     * @param username
     * @return
     */
    public LoginUser selectLoginUser1(String username);


    /**
     * 新增用户
     * @param userTotal
     * @return
     */
    public int addLoginUser(UserTotal userTotal);


    /**
     * 删除用户
     * @param userId
     * @return
     */
    public int removeLoginUser(Integer userId);

    /**
     * 更新用户信息
     * @param userTotal
     * @return
     */
    public int editLoginUser(UserTotal userTotal);

}
