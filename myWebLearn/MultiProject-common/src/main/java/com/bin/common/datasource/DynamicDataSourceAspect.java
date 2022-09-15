package com.bin.common.datasource;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName: DynamicDataSourceAspect
 * @Description: 动态数据源切面类，切面应当先与 @Transactional 执行
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Aspect
@Component
@Order(-1)
public class DynamicDataSourceAspect {


// 第一种增强aop方式
//    @Pointcut("@annotation(com.bin.common.datasource.DbSource)")
//    public void dataSourcePointCut(){
//        System.out.println(1);
//    }
//
//    /**
//     * 切换数据源
//     * @param point
//     * @param
//     */
//    @Before("dataSourcePointCut()")
//    public void switchDataSource(JoinPoint point){
//        MethodSignature signature = (MethodSignature) point.getSignature();
//        Method method = signature.getMethod();
//        DbSource annotation = method.getAnnotation(DbSource.class);
//        DataSourceKey value = annotation.value();
//        DynamicDataSourceContextHolder.setDataSourceKeys(value);
//    }
//
//    @After("dataSourcePointCut()")
//    public void restoreDataSource(JoinPoint point){
//        DynamicDataSourceContextHolder.clear();
//    }
        // 其他方法 test
//    @Before("dataSourcePointCut()")
//    public void switchDataSource(JoinPoint point){
//        System.out.println("before 0");
//        System.out.println(point.getSignature());
//        MethodSignature methodSignature = (MethodSignature) point.getSignature();
//        Method method = methodSignature.getMethod();
//        System.out.println(method);
//        if(method.getDeclaringClass().isInterface()){
//            try{
//                method = point.getTarget().getClass()
//                        .getDeclaredMethod(point.getSignature().getName(), method.getParameterTypes());
//            } catch (NoSuchMethodException e){
//                e.printStackTrace();
//            }
//            if(null == method.getAnnotation(DbSource.class)){
//                DynamicDataSourceContextHolder.setSlave();
//            }
//        }
//    }

// 第二种aop增强方式
    @Before("@annotation(source)")
    public void doBefore(JoinPoint point, DbSource source){
        System.out.println("Before 2");
        System.out.println(point);
        DynamicDataSourceContextHolder.setDataSourceKeys(source.value());
    }

    @After("@annotation(source)")
    public void doAfter(JoinPoint point, DbSource source){
        System.out.println("After 2");
        DynamicDataSourceContextHolder.clear();
    }

}
