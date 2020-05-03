<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	$(document).ready(function() {
		$("ul li:eq(1)").addClass("active");
	});
</script>
<div class="container">
	<h3 class="text-info">个人信息</h3>

	<form>
		<div class="from-group">
			<input type="hidden" id="studentId" name="studentId"
				value="${student.studentId }" />
		</div>

		<div class="form-group">
			<label>学号：</label> <input type="text" id="oldPassword"
				class="form-control" name="oldPassword"
				value="${student.stuNumber }" disabled />
		</div>
		<div class="form-group">
			<label>姓名：</label> <input type="text" id="oldPassword"
				class="form-control" name="oldPassword" value="${student.userName }"
				disabled />
		</div>
		<div class="form-group">
			<label>性别：</label> <input type="text" id="oldPassword"
				class="form-control" name="oldPassword" value="${student.sex}"
				disabled />
		</div>
		<div class="form-group">
			<label>宿舍楼：</label> <input type="text" id="oldPassword"
				class="form-control" name="oldPassword"
				value="${student.dormBuildName }" disabled />
		</div>
		<div class="form-group">
			<label>寝室：</label> <input type="text" id="oldPassword"
				class="form-control" name="oldPassword" value="${student.dormName }"
				disabled />
		</div>
		<div class="form-group">
			<label>联系电话：</label> <input type="text" id="oldPassword"
				class="form-control" name="oldPassword" value="${student.tel}"
				disabled />
		</div>

	</form>
</div>