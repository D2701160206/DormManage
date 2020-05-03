<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function checkForm(){
		var userName=document.getElementById("userName").value;
		var password=document.getElementById("password").value;
		var rPassword=document.getElementById("rPassword").value;
		var name=document.getElementById("name").value;
		var sex=document.getElementById("sex").value;
		var tel=document.getElementById("tel").value;
		
		if(userName==""||password==""||rPassword==""||name==""||sex==""||tel==""){
			 
			document.getElementById("error").innerHTML="信息填写不完整！";
			return false;
		} else if(!/^1(3|4|5|7|8)\d{9}$/.test(tel)){
		    document.getElementById("error").innerHTML="手机号不合法，请重新输入";
		    return false;
		    }else if(password!=rPassword){
			document.getElementById("error").innerHTML="密码填写不一致！";
			return false;
		}
		return true;
	}
	
	$(document).ready(function(){
		$("ul li:eq(1)").addClass("active");
	});
</script>
	<div class="container">
		<h3 class="text-info">
			<c:choose>
				<c:when test="${dormManager.dormManagerId!=null }">
					修改管理员
				</c:when>
				<c:otherwise>
					添加管理员
				</c:otherwise>
			</c:choose>
		</h3>
		<form action="DormManagerServlet?action=save" method="post" onsubmit="return checkForm()">
			<div class="from-group">
				<input type="hidden" id="dormManagerId" name="dormManagerId" value="${dormManager.dormManagerId }" />
			</div>

			<div class="form-group">
				<label for="userName">用户名：</label>
				<input type="text" id="userName" class="form-control" name="userName"
					value="${dormManager.userName }" />
			</div>

			<div class="form-group">
				<label>密码：</label>
				<input type="password" id="password" class="form-control" name="password"
					value="${dormManager.password }" />
			</div>

			<div class="form-group">
				<label>重复密码：</label>
				<input type="password" id="rPassword" class="form-control" name="rPassword"
					value="${dormManager.password }" />
			</div>

			<div class="form-group">
				<label>姓名：</label>
				<input type="text" id="name" class="form-control" name="name"
				 value="${dormManager.name }"/>
			</div>

			<div class="form-group">
				<label>性别：</label>
				<select class="form-control" id="sex" name="sex" style="width: 90px;">
					<option value="">请选择...</option>
					<option value="男" ${dormManager.sex eq "男" ?'selected':'' }>男</option>
					<option value="女" ${dormManager.sex eq "女" ?'selected':'' }>女</option>
				</select>
			</div>
			<div class="form-group">
				<label>联系电话：</label>
				<input class="form-control" type="text" id="tel" name="tel" value="${dormManager.tel }" />
			</div>

			<div align="center">
				<input type="submit" class="btn btn-primary" value="保存" />
				&nbsp;<button class="btn btn-primary" type="button" onclick="javascript:history.back()">返回</button>
			</div>
			<div align="center">
				<font id="error" color="red">${error }</font>
			</div>
		</form>
	</div>