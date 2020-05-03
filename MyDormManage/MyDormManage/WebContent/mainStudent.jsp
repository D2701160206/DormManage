<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>宿舍管理系统</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
function information(dormManagerId) {
	if(confirm("您确定要删除这个宿管吗？")) {
		window.location="StudentServlet?action=infor&stuNumber="+dormManagerId;
	}
}
</script>
<style type="text/css">
        .bleft {
            margin-top: 55px;
            margin-left: -100px;
        }
        
		form {
			width: 350px;
			border: 1px solid #e5e5e5;
			border-radius: 5px;
			margin: 0 auto;
			padding: 1%;
		}
	
    </style>
</head>
<body>
 <div class="container">
        <nav class="navbar navbar-fixed-top bg-primary">
            <div class="navbar-header">
                <a href="javascript:;" class="navbar-brand" style="color: white;"> <span
                        class="glyphicon glyphicon-education"></span> 宿舍管理系统</a>
            </div>
            <p class="navbar-text right" style="float: right;"> <span class="glyphicon glyphicon-user"></span>
                当前用户：&nbsp;${currentUser.userName }
            </p>
        </nav>
    </div>

    <div class="container">
        <div class="row ">
            <div class="col-md-2 bleft bg-success">
                <ul class=" nav nav-pills nav-stacked">
                    <li><a href="BlankServlet">首页</a></li>
                    <li><a href="StudentServlet?action=infor">个人信息</a></li>
                    <li><a href="PasswordServlet?action=preChange">修改密码</a></li>
                    <li><a href="login.jsp">退出系统</a></li>
                </ul>
            </div>
            <div class="col-md-10" style="margin-top:60px;">
                <jsp:include page="${mainPage==null?'admin/blank.jsp':mainPage}"></jsp:include>
            </div>
        </div>
    </div>
</body>
</html>