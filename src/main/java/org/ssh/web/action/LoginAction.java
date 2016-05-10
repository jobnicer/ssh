package org.ssh.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.ssh.common.PageModel;
import org.ssh.common.action.BaseAction;
import org.ssh.common.exception.ServiceException;
import org.ssh.utils.Const;
import org.ssh.utils.MyLog;
import org.ssh.web.bean.LoginBean;
import org.ssh.web.entity.User;
import org.ssh.web.service.ILoginService;

@Controller
public class LoginAction extends BaseAction {

	/**
	 * serialVersionUID:TODO
	 */
	private static final long serialVersionUID = -3010380171066701162L;
	
	private LoginBean loginBean;
	
	private PageModel pageModel = new PageModel();
	
	@Autowired
	private ILoginService loginService;
	
	public String login() {
		validateLogin();
		try {
			User user = loginService.login(loginBean.getUsername(), loginBean.getPassword());
			if(user!=null){
				session.put(Const.SESSION_USERINFO_KEY, user);
				pageModel = loginService.loadMenu(pageModel, user);
				return "login";
			}
		} catch (Exception e) {
			MyLog.error(e);
		}
		this.addActionError("用户名或密码错误！");
		return "input";
	}
	
	public String menu() {
		try {
			pageModel = loginService.loadMenu(pageModel, (User) session.get(Const.SESSION_USERINFO_KEY));
		} catch (ServiceException e) {
			MyLog.error(e);
		}
		return "menu";
	}

	// 验证用户名和密码
	public void validateLogin() {
		// 清空消息队列
		this.clearErrorsAndMessages();
		if(loginBean.getUsername()==null||"".equals(loginBean.getUsername().trim())){
			this.addFieldError("username", "用户名不能为空！");
		}
		if(loginBean.getPassword()==null||"".equals(loginBean.getPassword().trim())){
			this.addFieldError("password", "密码不能为空！");
		}
	}

}
