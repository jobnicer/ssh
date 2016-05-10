package org.ssh.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
* @Package : org.ssh.utils
* @FileName : SpringContext
* @Description : 获取spring管理的bean
* @Author : YJ
* @Date : 2016年1月5日 上午11:20:31
*/
public class SpringContext implements ApplicationContextAware
{
    protected static ApplicationContext context;

    public void setApplicationContext( ApplicationContext applicationContext ) throws BeansException
    {
        context = applicationContext;
    }

    public static ApplicationContext getContext()
    {
        return context;
    }

    public static Object getBean( String name )
    {
        return getContext().getBean( name );
    }
}