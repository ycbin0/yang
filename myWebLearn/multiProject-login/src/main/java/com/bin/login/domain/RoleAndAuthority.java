package com.bin.login.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: RoleAndAuthority
 * @Description: 角色资源关联类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Getter
@Setter
public class RoleAndAuthority {

    /**
     * 角色主键
     */
    @ApiModelProperty("角色主键")
    private String roleId;

    /**
     * 权限主键
     */
    @ApiModelProperty("权限主键")
    private String authId;

}
