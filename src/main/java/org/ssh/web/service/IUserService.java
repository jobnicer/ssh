package org.ssh.web.service;

import org.ssh.common.PageModel;
import org.ssh.common.exception.ServiceException;

public interface IUserService {

	public PageModel initUserList(PageModel pageModel) throws ServiceException;
	
	public PageModel initEditUser(PageModel pageModel) throws ServiceException;
	
	public PageModel editUser(PageModel pageModel) throws ServiceException;
	
	public PageModel deleteUser(PageModel pageModel) throws ServiceException;
	
	public PageModel changePass(PageModel pageModel) throws ServiceException;
	
	public PageModel resetPass(PageModel pageModel) throws ServiceException;
}
