package org.ssh.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @Package : amdb.baseui.log
* @FileName : Log
* @Description : 日志封装类
* @Author : YJ
* @Date : 2016年1月6日 下午2:11:56
*/
public class MyLog {

	/**
     * 获得Logger
     * @param clazz 日志发出的类
     * @return Logger
     */
    public static Logger get(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
 
    /**
     * 获得Logger
     * @param name 自定义的日志发出者名称
     * @return Logger
     */
    public static Logger get(String name) {
        return LoggerFactory.getLogger(name);
    }
     
    /**
     * @return 获得日志，自动判定日志发出者
     */
    public static Logger get() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return LoggerFactory.getLogger(stackTrace[2].getClassName());
    }
     
    //----------------------------------------------------------- Logger method start
     
    //------------------------ debug
    /**
     * Debug等级日志，小于Info<br>
     * 由于动态获取Logger，效率较低，建议在非频繁调用的情况下使用！！
     * @param msg 提示信息
     * @param e 需在日志中堆栈打印的异常
     */
    public static void debug(String msg, Throwable e) {
        debug(innerGet(), msg, e);
    }
     
    /**
     * Debug等级日志，小于Info
     * @param log 日志对象
      * @param msg 提示信息
     * @param e 需在日志中堆栈打印的异常
     */
    public static void debug(Logger log, String msg, Throwable e) {
        log.debug(msg, e);
    }
     
    //------------------------ info
    /**
     * Info等级日志，小于Warn<br>
     * 由于动态获取Logger，效率较低，建议在非频繁调用的情况下使用！！
     * @param msg 提示信息
     */
    public static void info(String msg) {
        info(innerGet(), msg);
    }
     
    /**
     * Info等级日志，小于Warn
     * @param log 日志对象
      * @param msg 提示信息
     */
    public static void info(Logger log, String msg) {
        log.info(msg);
    }
     
    //------------------------ warn
    /**
     * Warn等级日志，小于Error<br>
     * 由于动态获取Logger，效率较低，建议在非频繁调用的情况下使用！！
     * @param msg 提示信息
     * @param e 需在日志中堆栈打印的异常
     */
    public static void warn(String msg, Throwable e) {
        warn(innerGet(), msg, e);
    }
     
    /**
     * Warn等级日志，小于Error
     * @param log 日志对象
     * @param msg 提示信息
     * @param e 需在日志中堆栈打印的异常
     */
    public static void warn(Logger log, String msg, Throwable e) {
        log.warn(msg, e);
    }
     
    /**
     * Warn等级日志，小于Error<br>
     * 由于动态获取Logger，效率较低，建议在非频繁调用的情况下使用！！
     * @param e 需在日志中堆栈打印的异常
     * @param format 格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void warn(Throwable e, String format, Object... arguments) {
        warn(innerGet(), e, format(format, arguments));
    }
     
    /**
     * Warn等级日志，小于Error
     * @param log 日志对象
     * @param e 需在日志中堆栈打印的异常
     * @param format 格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void warn(Logger log, Throwable e, String format, Object... arguments) {
        log.warn(format(format, arguments), e);
    }
     
    //------------------------ error
    /**
     * Error等级日志<br>
     * 由于动态获取Logger，效率较低，建议在非频繁调用的情况下使用！！
     * @param msg 提示文本
     */
    public static void error(String msg) {
        error(innerGet(), msg, null);
    }
    
    /**
     * Error等级日志<br>
     * 由于动态获取Logger，效率较低，建议在非频繁调用的情况下使用！！
     * @param e 需在日志中堆栈打印的异常
     */
    public static void error(Throwable e) {
        error(innerGet(), null, e);
    }
    
    /**
     * Error等级日志<br>
     * 由于动态获取Logger，效率较低，建议在非频繁调用的情况下使用！！
     * @param msg 提示信息
     * @param e 需在日志中堆栈打印的异常
     */
    public static void error(String msg, Throwable e) {
        error(innerGet(), msg, e);
    }
     
    /**
     * Error等级日志<br>
     * @param log 日志对象
     * @param msg 提示信息
     * @param e 需在日志中堆栈打印的异常
     */
    public static void error(Logger log, String msg, Throwable e) {
        log.error(msg, e);
    }
     
    /**
     * Error等级日志<br>
     * 由于动态获取Logger，效率较低，建议在非频繁调用的情况下使用！！
     * @param e 需在日志中堆栈打印的异常
     * @param format 格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void error(Throwable e, String format, Object... arguments) {
        error(innerGet(), e, format(format, arguments));
    }
     
    /**
     * Error等级日志<br>
     * 由于动态获取Logger，效率较低，建议在非频繁调用的情况下使用！！
     * @param log 日志对象
     * @param e 需在日志中堆栈打印的异常
     * @param format 格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void error(Logger log, Throwable e, String format, Object... arguments) {
        log.error(format(format, arguments), e);
    }
    //----------------------------------------------------------- Logger method end
     
    //----------------------------------------------------------- Private method start
    /**
     * 格式化文本
     * @param template 文本模板，被替换的部分用 {} 表示
     * @param values 参数值
     * @return 格式化后的文本
     */
    private static String format(String template, Object... values) {
        return String.format(template.replace("{}", "%s"), values);
    }
     
    /**
     * @return 获得日志，自动判定日志发出者
     */
    private static Logger innerGet() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return LoggerFactory.getLogger(stackTrace[3].getClassName());
    }
    //----------------------------------------------------------- Private method end
	
}
