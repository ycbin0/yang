package com.bin.business.service;

import com.bin.business.domain.HkCamera;

import java.util.List;

/**
 * @ClassName: HkCameraSevice
 * @Description: 海康威视摄像头 Service
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
public interface HkCameraSevice {

    /**
     * 查询海康威视摄像头数据
     * @return
     */
    public List<HkCamera> selectAll();
}
