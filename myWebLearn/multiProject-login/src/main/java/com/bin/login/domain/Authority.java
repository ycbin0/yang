package com.bin.login.domain;

import com.bin.common.baseObj.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName: Authority
 * @Description: 权限类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("权限")
public class Authority extends BaseEntity {

    /**
     * 权限主键
     */
    @ApiModelProperty("权限主键")
    private String authId;

    /**
     * 权限名称
     */
    @ApiModelProperty("权限名称")
    private String authName;

    /**
     * 权限标识符
     */
    @ApiModelProperty("权限标识符")
    private String authCode;

}
