package org.ssh.web.entity;
// Generated 2016-1-2 0:06:30 by Hibernate Tools 3.4.0.CR1

import org.ssh.common.entity.BasePojo;


public class UserGroup extends BasePojo {

	/**
	 * serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 9171498424698218866L;
	
	private Long usergroupid;
	
	private String usergroupname;

	public Long getUsergroupid() {
		return usergroupid;
	}

	public void setUsergroupid(Long usergroupid) {
		this.usergroupid = usergroupid;
	}

	public String getUsergroupname() {
		return usergroupname;
	}

	public void setUsergroupname(String usergroupname) {
		this.usergroupname = usergroupname;
	}

}
