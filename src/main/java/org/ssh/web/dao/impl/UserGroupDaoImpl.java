package org.ssh.web.dao.impl;

import org.springframework.stereotype.Repository;
import org.ssh.common.dao.BaseDaoImpl;
import org.ssh.web.dao.IUserGroupDao;
import org.ssh.web.entity.UserGroup;

@Repository("userGroupDao")
public class UserGroupDaoImpl extends BaseDaoImpl<UserGroup, Long> implements IUserGroupDao{

}
