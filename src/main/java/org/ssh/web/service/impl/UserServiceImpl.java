package org.ssh.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssh.common.PageModel;
import org.ssh.common.exception.DaoException;
import org.ssh.common.exception.ServiceException;
import org.ssh.utils.Const;
import org.ssh.web.dao.IUserDao;
import org.ssh.web.entity.User;
import org.ssh.web.service.IUserService;

import com.opensymphony.xwork2.ActionContext;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	public PageModel initUserList(PageModel pageModel) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public PageModel initEditUser(PageModel pageModel) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public PageModel editUser(PageModel pageModel) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public PageModel deleteUser(PageModel pageModel) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public PageModel changePass(PageModel pageModel) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public PageModel resetPass(PageModel pageModel) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
