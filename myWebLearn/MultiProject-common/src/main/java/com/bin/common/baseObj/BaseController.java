package com.bin.common.baseObj;

import com.bin.common.util.ServletRequestUtil;
import com.github.pagehelper.PageHelper;

/**
 * @ClassName:
 * @Description:
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
public class BaseController {

    public void startPage(){
        Integer size = Integer.parseInt(ServletRequestUtil.getPara("size").toString());
        Integer page = Integer.parseInt(ServletRequestUtil.getPara("page").toString());
        PageHelper.startPage(size, page);
    }
}
