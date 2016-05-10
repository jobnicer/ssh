<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>用户管理系统</title>
  <link rel="stylesheet" href="js/amazeUI/css/amazeui.css"/>
  <script type="text/javascript" src="js/jQuery/jquery-1.7.1.js"></script>
  
  <style>
    .header {
      text-align: center;
    }
    .header h1 {
      font-size: 200%;
      color: #333;
      margin-top: 30px;
    }
    .header p {
      font-size: 14px;
    }
  </style>
  
  <script type="text/javascript">
	$(document).ready(function(){
		if(document.location.href!=top.document.location.href){
			top.document.location.href = document.location.href;
		}
		$("#login_sub").click(function(){
			$("#submitForm").attr("action", "loginAction_login.action").submit();
		});
	});
	
	/*回车事件*/
	function EnterPress(e){ //传入 event 
		var e = e || window.event; 
		if(e.keyCode == 13){ 
			$("#submitForm").attr("action", "loginAction_login.action").submit();
		} 
	} 
	
</script>
</head>
<body>
<div class="header">
  <div class="am-g">
    <h1>用户管理系统</h1>
    <p>User Management System<br/>用户手册</p>
  </div>
  <hr />
</div>
<div class="am-g">
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
    <h3>登录</h3>
    <hr>
    <br>
    <br>

    <form id="submitForm" method="post" class="am-form">
      <label for="text">用户名:</label>
      <input type="text" name="loginBean.username" id="text" value="">
      <br>
      <label for="password">密码:</label>
      <input type="password" name="loginBean.password" id="password" value="">
      <br>
      <label for="remember-me">
        <input id="remember-me" type="checkbox">
        记住密码
      </label>
      <br />
      <div class="am-cf">
        <input type="submit" id="login_sub" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl">
        <input type="submit" id="foreget_pwd" value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fr">
      </div>
    </form>
    <hr>
    <p>© 2016 MY Demo, Inc. Licensed under MIT license.</p>
  </div>
</div>
</body>
</html>