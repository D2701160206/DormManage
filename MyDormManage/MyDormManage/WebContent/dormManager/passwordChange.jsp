<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
function checkForm(){
	var oldPassword=document.getElementById("oldPassword").value;
	var newPassword=document.getElementById("newPassword").value;
	var rPassword=document.getElementById("rPassword").value;
	if(oldPassword==""||newPassword==""||rPassword==""){
		document.getElementById("error").innerHTML="信息填写不完整！";
		return false;
	} else if(newPassword!=rPassword){
		document.getElementById("error").innerHTML="密码填写不一致！";
		return false;
	}
	return true;
}
	
	$(document).ready(function(){
		$("ul li:eq(3)").addClass("active");
	});
</script>
<div class="container">
		<h3 class="text-info">
			修改密码
		</h3>
		<form class="form" action="PasswordServlet?action=change" method="post" onsubmit="return checkForm()">
			<div>
				<div class="from-group">
					<input type="hidden" id="studentId" name="studentId" value="${student.studentId }" />
				</div>

				<div class="form-group">
					<label for="oldPassword">原密码：</label>
					<input type="password" id="oldPassword" class="form-control" name="oldPassword"
						value="${oldPassword }" />
				</div>

				<div class="form-group">
					<label>新密码：</label>
					<input type="password" id="newPassword" class="form-control" name="newPassword"
						value="${newPassword }" />
				</div>
				<div class="form-group">
					<label>重复密码：</label>
					<input type="password" id="rPassword" class="form-control" name="rPassword" value="${rPassword }">
				</div>


				<div align="center">
					<input type="submit" class="btn btn-primary" value="提交" />
				</div>
				<div align="center">
					<font id="error" color="red">${error }</font>
				</div>
			</div>
		</form>
	</div>