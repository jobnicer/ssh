package org.ssh.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("rawtypes")
public class ReflectTool
{
    /**
     * 获取一个类的属性的类型
     * <li>如果该属性为普通类型，返回该类型</li>
     * <li>如果该属性为数组类型，返回该数组包含的元素的类型</li>
     * <li>不区分大小写</li>
     * <li>如果不存在该属性，返回 null</li>
     * 
     * @param clazz
     * @param attrName
     * @return
     * @throws Exception
     * 
     */
	public static Class getAttrClass( Class clazz, String attrName ) throws Exception
    {
        Field[] fields = clazz.getDeclaredFields();
        if( fields != null )
        {
            for( Field f : fields )
            {
                if( f.getName().toUpperCase().equals( attrName.toUpperCase() ) )
                {
                    boolean isArray = f.getType().isArray();
                    if( isArray )
                    {
                        return f.getType().getComponentType();
                    }
                    else
                    {
                        return f.getType();
                    }
                }
            }
        }
//        throw new Exception( "no such attr [" + clazz + "][" + attrName + "]" );
        return null;
    }

    /**
     * 获取一个类的某个属性的get方法
     * <li>如果存在该属性，返回该属性的get方法</li>
     * <li>如果不存在该属性，返回 null</li>
     * <li>不区分大小写</li>
     * 
     * @param clazz
     * @param attrName
     * @return
     * @throws Exception
     */
    public static Method getMehod( Class clazz, String attrName ) throws Exception
    {
        String methodName = "get" + attrName;
        Method[] ms = clazz.getMethods();
        if( ms != null )
        {
            for( Method m : ms )
            {
                if( m.getName().toUpperCase().equals( methodName.toUpperCase() ) )
                {
                    return m;
                }
            }
        }
        return null;
    }

    /**
     * 获取一个类的某个属性的set方法
     * <li>如果存在该属性，返回该属性的set方法</li>
     * <li>如果不存在该属性，返回 null</li>
     * <li>不区分大小写</li>
     * 
     * @param clazz
     * @param attrName
     * @return
     * @throws Exception
     */
    public static Method setMehod( Class clazz, String attrName ) throws Exception
    {
        String methodName = "set" + attrName;
        Method[] ms = clazz.getMethods();
        if( ms != null )
        {
            for( Method m : ms )
            {
                if( m.getName().toUpperCase().equals( methodName.toUpperCase() ) )
                {
                    return m;
                }
            }
        }
        return null;
    }

    /**
     * 获取一个对象的某个属性的值
     * <li>如果存在该属性，返回该属性的值</li>
     * <li>如果不存在该属性，返回 null</li>
     * <li>不区分大小写</li>
     * 
     * @param obj
     * @param attr
     * @return
     * @throws Exception
     */
    public static Object getValue( Object obj, String attr ) throws Exception
    {
        Method m = getMehod( obj.getClass(), attr );
        if( m != null )
        {
            return m.invoke(obj);
        }
        else
        {
            return null;
//            throw new Exception( "no such attr [" + obj.getClass() + "][" + attr + "]" );
        }
    }

    /**
     * 设置一个对象的某个属性的值
     * <li>如果存在该属性，设置该属性的值</li>
     * <li>如果不存在该属性，不做任何操作</li>
     * <li>不区分大小写</li>
     * 
     * @param obj
     * @param attr
     * @param value
     * @throws Exception
     */
    public static void setValue( Object obj, String attr, Object value ) throws Exception
    {
        Method m = setMehod( obj.getClass(), attr );
        if( m != null )
        {
            m.invoke( obj, value );
        }
        else
        {
//            throw new Exception( "no such attr [" + obj.getClass() + "][" + attr + "]" );
        }
    }

    /**
     * 获取一个对象的某个属性的值，该属性值可以带"."号
     * <li>如果存在该属性，返回该属性的值</li>
     * <li>如果不存在该属性，返回 null</li>
     * <li>不区分大小写</li>
     * 
     * @param obj
     * @param property
     * @return
     * @throws Exception
     */
    public static Object getValueWithDot( Object obj, String property ) throws Exception
    {
        if( obj == null )
        {
            return null;
        }
        if( property == null || "".equals( property ) )
        {
            return null;
        }
        if( property.contains( "." ) )
        {
            String head = property.substring( 0, property.indexOf( "." ) );
            String tail = property.substring( head.length() + 1 );
            return getValueWithDot( getValueWithDot( obj, head ), tail );
        }
        else
        {
            return getValue( obj, property );
        }
    }
    
}
