<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
		function StudentDelete(studentId) {
			if (confirm("您确定要删除这个学生吗？")) {
				window.location = "StudentServlet?action=delete&studentId=" + studentId;
			}
		}
		$(document).ready(function () {
			$("ul li:eq(1)").addClass("active");

		});

	</script>

<div class="container">

	<h3 class="text-info">学生管理</h3>

	<form class="form-inline" align="right" name="myForm" method="post"
		action="StudentServlet?action=search">

		<div class="form-group">
			<select class="form-control" name="searchType" style="width: 80px;">
				<option value="name">姓名</option>
				<option value="number" ${searchType eq "number" ?'selected':'' }>学号</option>
				<option value="dorm" ${searchType eq "dorm" ?'selected':'' }>寝室</option>
			</select>
		</div>
		<div class="form-group">


			&nbsp;<input id="s_studentText" class="form-control"
				name="s_studentText" type="text" style="width: 120px;"
				value="${s_studentText }"> &nbsp;
			<button type="submit" class="btn btn-info"
				onkeydown="if(event.keyCode==13) myForm.submit()">搜索</button>
		</div>

		<div class="form-group">
			<button class="btn  btn-info" type="button"
				onclick="javascript:window.location='StudentServlet?action=preSave'">添加</button>
		</div>
	</form>

	<div>
		<table class="table table-striped table-bordered table-hover datatable">
			<thead class="bg-info">
				<tr>
					<th>学号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>宿舍楼</th>
					<th>寝室</th>
					<th>电话</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach varStatus="i" var="student" items="${studentList }">
					<tr>

						<td>${student.stuNumber }</td>
						<td>${student.userName }</td>
						<td>${student.sex }</td>
						<td>${student.dormBuildName==null?"无":student.dormBuildName }</td>
						<td>${student.dormName }</td>
						<td>${student.tel }</td>
						<td><button class="btn btn-xs btn-info" type="button"
								onclick="javascript:window.location='StudentServlet?action=preSave&studentId=${student.studentId }'">修改</button>&nbsp;
							<button class="btn btn-xs btn-danger" type="button"
								onclick="StudentDelete(${student.studentId})">删除</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div align="center">
		<font color="red">${error }</font>
	</div>
</div>