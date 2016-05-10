package org.ssh.web.service;

import org.ssh.common.PageModel;
import org.ssh.common.exception.ServiceException;
import org.ssh.web.entity.User;

public interface ILoginService {

	public User login(String name, String pass) throws ServiceException;
	 
	public PageModel loadMenu(PageModel pageModel, User user) throws ServiceException;
}
