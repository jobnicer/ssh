package org.ssh.common.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.ssh.common.entity.DTO;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware {
	
	private static final long serialVersionUID = 1L;
	
	protected ServletContext application;
	
	protected Map<String, Object> session;
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	// 数据传输对象
	protected DTO dto;
	
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public DTO getDto() {
		if (dto == null) {
			dto = new DTO();
		}
		return dto;
	}

	public void setDto(DTO dto) {
		this.dto = dto;
	}
	
}
