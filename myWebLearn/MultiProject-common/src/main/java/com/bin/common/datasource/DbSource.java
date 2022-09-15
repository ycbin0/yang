package com.bin.common.datasource;

import java.lang.annotation.*;

/**
 * @ClassName: DbSource
 * @Description: 动态数据源注解类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DbSource {

    /**
     * 数据源的key值
     * @return
     */
    DataSourceKey value() default  DataSourceKey.master;
}
