package org.ssh.web.dao.impl;

import org.springframework.stereotype.Repository;
import org.ssh.common.dao.BaseDaoImpl;
import org.ssh.web.dao.IFunctionsDao;
import org.ssh.web.entity.Functions;

@Repository("functionsDao")
public class FunctionsDaoImpl extends BaseDaoImpl<Functions, Long> implements IFunctionsDao {

}
