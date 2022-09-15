package com.bin.common.baseObj;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: BaseEntity
 * @Description: 基类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 创建用户id
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改人id
     */
    private Integer updateBy;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 是否删除 0 否， 1 是
     */
    private Integer delFlag;

    /**
     * 备用字段
     */
    private String bak;

    /**
     * 备注
     */
    private String remark;
}
