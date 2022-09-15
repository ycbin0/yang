package com.bin.common.util;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ConvertObjectUtil {

    /**
     * 将 object 对象转化成对应的数组类型
     * @param
     * @return
     */
//    public static <T> T objToStringArray(Object o, Class<T> yclass) throws IllegalAccessException, InstantiationException {
//        T as = ((List<?>) o).stream().map(i -> ((T) i)).toArray(yclass.getClass().newInstance());
//        return as;
//    }

    /**
     * SET 对象转化成 LIST
     * @param set
     * @param <T>
     * @return
     */
    public static <T> List<T> setToList(Set<T> set){
        List<T> list = new ArrayList<>();
        if(set != null && set.size() > 0){
            set.stream().forEach(i ->
                    list.add(i));
        };
        return list;
    }

    /**
     * 将 List 转化成 Array
     * @param list
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T[] listToArray(List<T> list, Class tClass){
        if(list != null && list.size() > 0){
            T[] array = (T[]) Array.newInstance(tClass, list.size());
            for(int i = 0; i < list.size(); i++){
                array[i] = list.get(i);
            }
            return array;
        }
        return (T[]) Array.newInstance(tClass.getClass(),0);
    }

}
