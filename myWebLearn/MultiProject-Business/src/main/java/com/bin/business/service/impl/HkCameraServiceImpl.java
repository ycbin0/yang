package com.bin.business.service.impl;

import com.bin.business.Mapper.HkCameraMapper;
import com.bin.business.domain.HkCamera;
import com.bin.business.service.HkCameraSevice;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: HkCameraServiceImpl
 * @Description: 海康威视摄像头 Service 实现类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Service
public class HkCameraServiceImpl implements HkCameraSevice {

    @Autowired
    private HkCameraMapper hkCameraMapper;

    @Override
    public List<HkCamera> selectAll() {
        return hkCameraMapper.selectAll();
    }
}
