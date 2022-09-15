package com.bin.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: HkCamera
 * @Description: 海康摄像头
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Data
@ApiModel("海康威视摄像头类")
public class HkCamera {

    /**
     * 监控点编号（通用唯一识别码UUID）
     */
    @ApiModelProperty("监控点编号（通用唯一识别码UUID）")
    private String cameraIndexCode;

    /**
     * 监控点名称
     */
    @ApiModelProperty("监控点名称")
    private String name;

    /**
     * 所属区域编号（通用唯一识别码UUID）
     */
    @ApiModelProperty("所属区域编号（通用唯一识别码UUID）")
    private String unitIndexCode;

    /**
     * 监控点国标编号
     */
    @ApiModelProperty("监控点国标编号")
    private String gbIndexCode;

    /**
     * 所属设备编号（通用唯一识别码UUID）
     */
    @ApiModelProperty("所属设备编号（通用唯一识别码UUID）")
    private String deviceIndexCode;

    /**
     * 纬度（WGS84坐标系）
     */
    @ApiModelProperty("纬度（WGS84坐标系）")
    private String latitude;

    /**
     * 经度（WGS84坐标系）
     */
    @ApiModelProperty("经度（WGS84坐标系）")
    private String longitude;

    /**
     * 海拔高度（WGS84坐标系，单位：米）
     */
    @ApiModelProperty("海拔高度（WGS84坐标系，单位：米）")
    private String altitude;

    /**
     * 摄像机像素（1-普通像素，2-130万高清，3-200万高清，4-300万高清
     */
    @ApiModelProperty("摄像机像素（1-普通像素，2-130万高清，3-200万高清，4-300万高清")
    private Integer pixel;

    /**
     * 监控点类型（0-枪机，1-半球，2-快球，3-带云台枪机，
     */
    @ApiModelProperty("监控点类型（0-枪机，1-半球，2-快球，3-带云台枪机，")
    private Integer cameraType;

    /**
     * 安装位置
     */
    @ApiModelProperty("安装位置")
    private String installPlace;

    /**
     * 矩阵编号
     */
    @ApiModelProperty("矩阵编号")
    private String matrixCode;

    /**
     * 通道号
     */
    @ApiModelProperty("通道号")
    private Integer chanNum;

    /**
     * 可视域相关（JSON格式）
     */
    @ApiModelProperty("可视域相关（JSON格式）")
    private String viewshed;

    /**
     * 能力集
     */
    @ApiModelProperty("能力集")
    private String capabilitySet;

    /**
     * 智能分析能力集
     */
    @ApiModelProperty("智能分析能力集")
    private String intelligentSet;

    /**
     * 录像存储位置（0-中心存储，1-设备存储，
     */
    @ApiModelProperty("录像存储位置（0-中心存储，1-设备存储，")
    private String recordLocation;

    /**
     * 云台控制（1-DVR,2-模拟矩阵,3-MU4000,4-NC600
     */
    @ApiModelProperty("云台控制（1-DVR,2-模拟矩阵,3-MU4000,4-NC600")
    private Integer ptzController;

    /**
     * 所属设备类型
     */
    @ApiModelProperty("所属设备类型")
    private String deviceResourceType;

    /**
     * 通道子类型
     */
    @ApiModelProperty("通道子类型")
    private String channelType;

    /**
     * 传输协议（0-UDP，1-TCP，
     */
    @ApiModelProperty("传输协议（0-UDP，1-TCP，")
    private Integer transType;

    /**
     * 监控点更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH mm:ss")
    @ApiModelProperty("监控点更新时间")
    private Date updateTime;

    /**
     * 监控点创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH mm:ss")
    @ApiModelProperty("监控点创建时间")
    private Date createTime;

    /**
     * 在线状态（0-不在线，1-在线
     */
    @ApiModelProperty("在线状态（0-不在线，1-在线")
    private Integer status;

    /**
     * 状态说明
     */
    @ApiModelProperty("状态说明")
    private String cameraTypeName;

    /**
     * 能力集说明
     */
    @ApiModelProperty("能力集说明")
    private String capabilitySetName;

    /**
     * 智能分析能力集说明
     */
    @ApiModelProperty("智能分析能力集说明")
    private String intelligentSetName;

    /**
     * 录像存储位置说明
     */
    @ApiModelProperty("录像存储位置说明")
    private String recordLocationName;

    /**
     * 	云台控制说明
     */
    @ApiModelProperty("	云台控制说明")
    private String ptzControllerName;

    /**
     * 所属设备类型说明
     */
    @ApiModelProperty("所属设备类型说明")
    private String deviceResourceTypeName;

    /**
     * 通道子类型说明
     */
    @ApiModelProperty("通道子类型说明")
    private String channelTypeName;

    /**
     * 传输协议类型说明
     */
    @ApiModelProperty("传输协议类型说明")
    private String transTypeName;

    /**
     * 接入协议
     */
    @ApiModelProperty("接入协议")
    private String treatyType;

    /**
     * 接入协议类型说明
     */
    @ApiModelProperty("接入协议类型说明")
    private String treatyTypeName;

    /**
     * 状态说明
     */
    @ApiModelProperty("状态说明")
    private String statusName;

    /**
     * 是否删除 0 否，1 是
     */
    @ApiModelProperty("是否删除 0 否，1 是")
    private Integer delFlag;


}
