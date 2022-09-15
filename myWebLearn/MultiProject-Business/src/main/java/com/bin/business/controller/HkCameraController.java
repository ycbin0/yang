package com.bin.business.controller;

import com.bin.business.service.HkCameraSevice;
import com.bin.common.baseObj.BaseController;
import com.bin.common.baseObj.ResultResponse;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HkCameraController
 * @Description: 海康威视摄像头 Controller 层
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@RequestMapping("/business")
@RestController
@Api(tags = {"HkCameraController"}, description = "海康威视摄像头")
public class HkCameraController extends BaseController {

    @Autowired
    private HkCameraSevice hkCameraSevice;


    @ApiOperation("海康威视摄像头数据")
    @GetMapping("/list")
    public ResultResponse selectAll(){
        startPage();
        return ResultResponse.success(hkCameraSevice.selectAll());
    }
}
