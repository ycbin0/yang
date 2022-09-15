package com.bin.common.datasource;

import org.apache.commons.lang3.RandomUtils;

/**
 * @ClassName: DynamicDataSourceContextHolder
 * @Description: 数据源上下文切换类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
public class DynamicDataSourceContextHolder {

    /**
     * 全局存储当前数据源
     */
    private static final ThreadLocal<DataSourceKey> DATASOURCE_TOTAL = ThreadLocal.withInitial(() -> DataSourceKey.master);



    /**
     * 设置当前使用的数据源
     * @param key
     */
    public static void setDataSourceKeys(DataSourceKey key){
        DATASOURCE_TOTAL.set(key);
    }

    /**
     * 设置当前使用的数据源
     * @return
     */
    public static DataSourceKey getDataSourceKeys(){
//        return DATASOURCE_TOTAL.get() == null ? DataSourceKey.master : DATASOURCE_TOTAL.get();
        return DATASOURCE_TOTAL.get();
    }

    /**
     * 清除当前数据源
     */
    public static void clear(){
        DATASOURCE_TOTAL.remove();
    }

    /**
     * 根据随机数选择不同的数据源
     */
    public static void setSlave(){
        if(RandomUtils.nextInt(0, 2) > 0){
            DynamicDataSourceContextHolder.setDataSourceKeys(DataSourceKey.db1);
        } else {
            DynamicDataSourceContextHolder.setDataSourceKeys(DataSourceKey.master);
        }
    }


}
