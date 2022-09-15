package com.bin.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @ClassName: DatasourceDynamic
 * @Description: 动态数据源
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
public class DatasourceDynamic extends AbstractRoutingDataSource {

//    动态数据源类集成了Spring提供的AbstractRoutingDataSource类，AbstractRoutingDataSource 中获取数据源的方法就是 determineTargetDataSource，而此方法又通过 determineCurrentLookupKey 方法获取查询数据源的key。
    @Override
    protected Object determineCurrentLookupKey() {
//        System.out.println("当前数据源是：" + DynamicDataSourceContextHolder.getDataSourceKeys());
        return DynamicDataSourceContextHolder.getDataSourceKeys();
    }
}
