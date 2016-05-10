package org.ssh.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssh.common.PageModel;
import org.ssh.common.exception.DaoException;
import org.ssh.common.exception.ServiceException;
import org.ssh.utils.Const;
import org.ssh.web.dao.IFunctionsDao;
import org.ssh.web.dao.IUserDao;
import org.ssh.web.entity.Functions;
import org.ssh.web.entity.User;
import org.ssh.web.service.ILoginService;

import com.opensymphony.xwork2.ActionContext;

@Service
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IFunctionsDao functionsDao;
	
	@Override
	@SuppressWarnings("unchecked")
	public User login(String name, String pass) throws ServiceException {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("username", name);
		map.put("password", pass);
		try {
			List<User> users = (List<User>) userDao.query(User.class, "select * from USR_USER where username=:username and password=:password",map);
			if(users!=null && !users.isEmpty() && users.size()==1){
//				ActionContext.getContext().getSession().put(Const.SESSION_USERINFO, users.get(0));
//			    ActionAuditUtil.saveAudit("I", null, "用户登录成功！", userDao);
				return users.get(0);
			}
		} catch (DaoException e) {
			throw new ServiceException("验证用户登录信息异常",e);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public PageModel loadMenu(PageModel pageModel, User user) throws ServiceException {
//		User user = (User) ActionContext.getContext().getSession().get(Const.SESSION_USERINFO);
		if(user!=null){
			Long usergroupid = user.getUserGroup().getUsergroupid();
			String sql = "select * from usr_functions where functionid in (select functionid from usr_usergroupfunctions where usergroupid =" + usergroupid + ")";
			try {
				List<Functions> functions = (List<Functions>) functionsDao.query(Functions.class, sql, null);
				pageModel.setDatas(functions);
				return pageModel;
			} catch (DaoException e) {
				throw new ServiceException("获取用户权限信息异常",e);
			}
		}
		return null;
	}
	
}
