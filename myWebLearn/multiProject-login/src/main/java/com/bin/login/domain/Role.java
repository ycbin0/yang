package com.bin.login.domain;

import com.bin.common.baseObj.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName: Role
 * @Description: 角色
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("角色")
public class Role extends BaseEntity {

    /**
     * 角色主键
     */
    @ApiModelProperty("角色主键")
    private String roleId;

    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String roleName;

    /**
     * 角色描述
     */
    @ApiModelProperty("角色描述")
    private String roleDescription;

    private String[] auths;

}
