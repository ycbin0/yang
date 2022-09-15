package com.bin.login.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: LoginUserAndRole
 * @Description: 用户角色管理类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Getter
@Setter
public class LoginUserAndRole {

    /**
     * 用户主键
     */
    @ApiModelProperty("用户主键")
    private Integer userId;

    /**
     * 角色主键
     */
    @ApiModelProperty("角色主键")
    private String roleId;


}
