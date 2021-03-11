package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtlis {
    /**
     * 这是�?个将map集合放进实体类的方法
     * @param bean
     * @param map
     * @param <T>
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static <T> T copyParamToBean(T bean, Map map) throws InvocationTargetException, IllegalAccessException {

        BeanUtils.populate(bean,map);

        return  bean;
    }

    /**
     * 这是将字符串转换为int的方�?
     * @param str
     * @param delfvalue
     * @return
     */
    public static int parseInt(String str, int delfvalue){
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return delfvalue;
    }
}
