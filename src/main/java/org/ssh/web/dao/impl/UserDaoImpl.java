package org.ssh.web.dao.impl;

import org.springframework.stereotype.Repository;
import org.ssh.common.dao.BaseDaoImpl;
import org.ssh.web.dao.IUserDao;
import org.ssh.web.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements IUserDao {

}
