package com.bin.business.Mapper;

import com.bin.business.domain.HkCamera;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: HkCameraMapper
 * @Description: 海康威视摄像头 Mapper
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Mapper
public interface HkCameraMapper {

    /**
     * 查询海康威视摄像头数据
     * @return
     */
    @Select("select * from ct_device_hk_camera")
    public List<HkCamera> selectAll();
}
