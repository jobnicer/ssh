package org.ssh.web.entity;

import org.ssh.common.entity.BasePojo;

public class UserGroupFunctions extends BasePojo {

	/**
	 * serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 4492882564441956371L;

	private Functions functions;
	
	private UserGroup userGroup;

	public Functions getFunctions() {
		return functions;
	}

	public void setFunctions(Functions functions) {
		this.functions = functions;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

}
