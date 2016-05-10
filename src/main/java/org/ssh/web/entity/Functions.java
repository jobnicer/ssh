package org.ssh.web.entity;

import org.ssh.common.entity.BasePojo;

public class Functions extends BasePojo {

	/**
	 * serialVersionUID:TODO
	 */
	private static final long serialVersionUID = -612491398396473829L;

	private Long functionid;
	
	private Long functiongroupid;
	
	private String functionname;
	
	private String functionurl;

	public Long getFunctionid() {
		return functionid;
	}

	public void setFunctionid(Long functionid) {
		this.functionid = functionid;
	}

	public Long getFunctiongroupid() {
		return functiongroupid;
	}

	public void setFunctiongroupid(Long functiongroupid) {
		this.functiongroupid = functiongroupid;
	}

	public String getFunctionname() {
		return functionname;
	}

	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}

	public String getFunctionurl() {
		return functionurl;
	}

	public void setFunctionurl(String functionurl) {
		this.functionurl = functionurl;
	}

}
