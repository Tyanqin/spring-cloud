package com.tx.common.util;

import com.tx.common.Annotation.Table;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TanXiao
 * @date 2022-05-20 10:19
 */
public class Ref {

    public static Field[] getField(final Class clazz){
        Field[] declaredFields = clazz.getDeclaredFields();
        return declaredFields;
    }

    /**
     * 根据属性，获取get方法
     * @param clazz 对象
     * @return
     * @throws Exception
     */
    public static List<Method> getGetMethod(final Class clazz){
        Method[] methods = clazz.getMethods();
        List<Method> listMethod = new ArrayList<>();
        for (Method method : methods) {
            String methodName = method.getName().toUpperCase();
            if(methodName.startsWith("GET") && !methodName.equals("GETCLASS")){
                listMethod.add(method);
            }
        }
        return listMethod;
    }


    /**
     * 通过反射, 获得Class定义中声明的父类的泛型参数的类型.
     * 如无法找到, 返回Object.class.
     *
     * 如public UserDao extends HibernateDao<User,Long>
     *clazz The class to introspect
     * @param
     * @param index the Index of the generic ddeclaration,start from 0.
     * @return the index generic declaration, or Object.class if cannot be determined
     */
    public  Class getClassGenType(final int index) {

        Type genType = getClass().getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }

    public static String getAnnotation(Class clazz)  {
        Assert.notNull(clazz, "clazz must not be null");
        Table tableAnnotation = (Table) clazz.getAnnotation(Table.class);
        Assert.notNull(tableAnnotation, "tableAnnotation must not be null");
        String value = tableAnnotation.value();
        Assert.notNull(tableAnnotation, "tableAnnotation must not be null");
        return value;
    }

}
