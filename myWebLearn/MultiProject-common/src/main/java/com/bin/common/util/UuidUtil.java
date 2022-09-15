package com.bin.common.util;

import java.util.UUID;

/**
 * @ClassName: UuidUtil
 * @Description: UUID 工具类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
public class UuidUtil {

    /**
     * 36位 UUID
     * @return
     */
    public static String getUUid(){
        String s = UUID.randomUUID().toString();
        return s;
    }

    /**
     * 32位 UUID
     * @return
     */
    public static String getSimpleUUid(){
        String s = UUID.randomUUID().toString().replace("-","");
        return s;
    }
}
