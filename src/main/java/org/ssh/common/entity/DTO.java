package org.ssh.common.entity;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @Package : org.ssh.common.entity
* @FileName : 数据传输对象
* @Description : 
* @Author : YJ
* @Date : 2015年12月30日 下午7:34:40
*/
public class DTO extends HashMap<String, Object> {
	
	static final long serialVersionUID = 429999L;

	protected final transient Logger logger = LoggerFactory.getLogger(this.getClass());

	protected final transient String hcode = String.valueOf(hashCode());
}