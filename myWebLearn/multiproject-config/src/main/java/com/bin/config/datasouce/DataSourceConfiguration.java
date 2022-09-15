package com.bin.config.datasouce;

import com.bin.common.datasource.DataSourceKey;
import com.bin.common.datasource.DatasourceDynamic;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DataSource Configuration
 * @Description: 数据源配置类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Configuration
public class DataSourceConfiguration {

    @Bean("master")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource master(){
        return DataSourceBuilder.create().build();
    }


    @Bean("db1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource db1(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 配置多数据源
     * @return
     */
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource(){
        DatasourceDynamic datasourceDynamic = new DatasourceDynamic();
        // 配置默认数据源
        datasourceDynamic.setDefaultTargetDataSource(master());
        // 配置多数据源
        Map<Object, Object> map = new HashMap<>(4);
        map.put(DataSourceKey.master, master());
        map.put(DataSourceKey.db1, db1());
        datasourceDynamic.setTargetDataSources(map);
        return datasourceDynamic;
    }

    /**
     * 数据库连接会话工厂
     * @return
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dynamicDataSource());
        sessionFactoryBean.setTypeAliasesPackage("com.bin.*.domain");
        PathMatchingResourcePatternResolver resolve = new PathMatchingResourcePatternResolver();
        sessionFactoryBean.setMapperLocations(resolve.getResources("classpath:mapper/*.xml"));
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sessionFactoryBean.setConfiguration(configuration);
        return sessionFactoryBean;
    }

//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
//        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory().getObject());
//        return sqlSessionTemplate;
//    }

    /**
     * 配置事务管理器
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dynamicDataSource());
    }


}
