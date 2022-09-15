package com.bin.login.domain;

import com.bin.common.baseObj.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: LoginUser
 * @Description: 用户类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("登录用户")
@NoArgsConstructor
public class LoginUser extends BaseEntity {

    /**
     * 用户主键
     */
    @ApiModelProperty("用户主键")
    private Integer userId;

    /**
     * 账户
     */
    @ApiModelProperty("账户")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickName;

    /**
     * 最后登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH mm:ss")
    @ApiModelProperty("最后登录时间")
    private Date lastLoginTime;


    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
