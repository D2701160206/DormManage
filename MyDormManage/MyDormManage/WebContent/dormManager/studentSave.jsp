<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function checkForm() {
		var userName = document.getElementById("userName").value;
		var password = document.getElementById("password").value;
		var rPassword = document.getElementById("rPassword").value;
		var dormBuildName = document.getElementById("dormBuildName").value;
		var dormName = document.getElementById("dormName").value;
		var stuNumber = document.getElementById("stuNumber").value;
		var sex = document.getElementById("sex").value;
		var tel = document.getElementById("tel").value;
		if (userName == "" || password == "" || rPassword == ""
				|| stuNumber == "" || sex == "" || tel == ""
				|| dormBuildName == "" || dormName == "") {
			document.getElementById("error").innerHTML = "信息填写不完整！";
			return false;
		}  else if(!/^1(3|4|5|7|8)\d{9}$/.test(tel)){
		    document.getElementById("error").innerHTML="手机号不合法，请重新输入";
		    return false;
		    }else if (password != rPassword) {
			document.getElementById("error").innerHTML = "密码填写不一致！";
			return false;
		}
		return true;
	}

	$(document).ready(function() {
		$("ul li:eq(1)").addClass("active");
	});
</script>
<div class="contianer">
	<div>
		<h3 class="text-info">
			<c:choose>
				<c:when test="${student.studentId!=null }">
						修改学生信息
					</c:when>
				<c:otherwise>
						添加学生
					</c:otherwise>
			</c:choose>
		</h3>
	</div>
	<form class="form" action="StudentServlet?action=save" method="post"
		onsubmit="return checkForm()">
		<div class="from-group">
			<input type="hidden" id="studentId" name="studentId"
				value="${student.studentId }" />

		</div>

		<div class="form-group">
			<label for="stuNumber">学号：</label> <input type="text" id="stuNumber"
				class="form-control" name="stuNumber" value="${student.stuNumber }" />
		</div>

		<div class="form-group">
			<label for="userName">姓名：</label> <input type="text" id="userName"
				class="form-control" name="userName" value="${student.userName }" />
		</div>

		<div class="form-group">
			<label>密码：</label> <input type="password" id="password"
				class="form-control" name="password" value="${student.password }" />
		</div>

		<div class="form-group">
			<label>重复密码：</label> <input type="password" id="rPassword"
				class="form-control" name="rPassword" value="${student.password }" />
		</div>

		<div class="form-group row">
			<div class=" col-md-6">
				<label>性别：</label> <select class="form-control" id="sex" name="sex"
					style="width: 90px;">
					<option value="">请选择...</option>
					<option value="男" ${student.sex eq "男" ?'selected':'' }>男</option>
					<option value="女" ${student.sex eq "女" ?'selected':'' }>女</option>
				</select>
			</div>

			<div class=" col-md-6">
				<label>宿舍楼：</label> <select class="form-control" id="dormBuildName"
					name="dormBuildName" style="width: 90px;">
					<c:forEach var="dormBuild" items="${dormBuildList }">
						<option value="${dormBuild.dormBuildId }"
							${student.dormBuildName==dormBuild.dormBuildId?'selected':'' }>
							${dormBuild.dormBuildName }</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="form-group">
			<label>寝室：</label> <input class="form-control" type="text"
				id="dormName" name="dormName" value="${student.dormName }" />
		</div>

		<div class="form-group">
			<label>联系电话：</label> <input class="form-control"  type="text"
				id="tel" name="tel" value="${student.tel }" />
		</div>

		<div align="center">
			<input type="submit" class="btn btn-primary" value="保存" /> &nbsp;
			<button class="btn btn-primary" type="button"
				onclick="javascript:window.location='StudentServlet'">返回</button>
		</div>
		<div align="center">
			<font id="error" color="red">${error }</font>
		</div>
</form>
</div>