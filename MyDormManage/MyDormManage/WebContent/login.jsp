<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>宿舍管理系统登录</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
function checkForm() {
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	var userTypes = document.getElementsByName("userType");
	var userType = null;
	for(var i=0;i<userTypes.length;i++) {
		if(userTypes[i].checked) {
			userType=userTypes[i].value;
			break;
		}
	}
	if (userName == null || userName == "") {
		document.getElementById("error").innerHTML = "用户名不能为空";
		return false;
	}
	if (password == null || password == "") {
		document.getElementById("error").innerHTML = "密码不能为空";
		return false;
	}
	if (userType == null || userType == "") {
		document.getElementById("error").innerHTML = "请选择用户类型";
		return false;
	}
	return true;
}
</script>
<style type="text/css">
    body {
      background-image: url('images/bg.jpg');
      background-position: center;
      background-repeat: no-repeat;
      background-attachment: fixed;
    }

    form {
      width: 300px;
      
      background-color: #eee;
      border: 1px solid #e5e5e5;
      border-radius: 5px;
      opacity: 0.85;
      margin: 200 auto;
      padding: 1%;
    }
  </style>

</head>

<body>
  <div class="container">

    <form name="form" action="LoginServlet" method="post" onsubmit="return checkForm()">
      <h2 class="text-center">宿舍管理系统</h2>
      <div class="form-group">
        <label for="userName">用户名</label>
        <input id="userName" class="form-control" name="userName" value="${user.userName }" type="text"
          placeholder="用户名...">
      </div>

      <div class="form-group">
        <label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
        <input id="password" class="form-control" name="password" value="${user.password }" type="password"
          placeholder="密码...">
      </div>

      <div class="form-group">
        <label class="radio-inline">
          <input id="student" type="radio" name="userType" value="student" checked /> 学生
        </label>
        <label class="radio-inline">
          <input id="dormManager" type="radio" name="userType" value="dormManager" /> 宿舍管理员
        </label>
        <label class="radio-inline">
          <input id="admin" type="radio" name="userType" value="admin" /> 系统管理员
        </label>
      </div>
      <div class="btn-group btn-group-justified">

        <div class="btn-group">
          <button class="btn btn-primary" type="submit">登录</button>
        </div>

        <div class="btn-group">
          <button class="btn btn-danger" type="reset">重置</button>
        </div>

      </div>

      <label class="checkbox">
        <font id="error" color="red">${error }</font>
      </label>

    </form>
</div>
</body>
</html>