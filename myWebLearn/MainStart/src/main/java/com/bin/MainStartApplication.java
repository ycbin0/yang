package com.bin;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// 排除security和数据源的自动注入（这样可以实现多数据源的配置）
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
//@EnableNacosDiscovery(globalProperties = @NacosProperties(serverAddr = "127.0.0.1:8848"))
//@NacosPropertySource(dataId = "yqy", autoRefreshed = true, type = ConfigType.YAML)
//@NacosPropertySource(dataId = "dev", autoRefreshed = true, type = ConfigType.YAML)
//@NacosPropertySource(dataId = "bootstrap", autoRefreshed = true, type = ConfigType.YAML)
//@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "127.0.0.1:8848"))
@EnableEurekaClient
public class MainStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainStartApplication.class, args);
    }

}
