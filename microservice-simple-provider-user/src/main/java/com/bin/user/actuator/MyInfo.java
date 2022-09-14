package com.bin.user.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MyInfo
 * @Description: yml文件中的 info 不生效，使用类配置
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Component
public class MyInfo implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, String> map = new HashMap<>();
        map.put("bin", "yqy");
        builder.withDetail("test", map);
    }
}
