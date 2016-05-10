package org.ssh.web.entity;

import org.ssh.common.entity.BasePojo;

public class User extends BasePojo {

	/**
	 * serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 1460954708147634483L;

	private Long userid;
	
	private UserGroup userGroup;
	
	private String username;
	
	private String password;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
