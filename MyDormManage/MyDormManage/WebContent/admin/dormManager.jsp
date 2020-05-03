<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
		function dormManagerDelete(dormManagerId) {
			if (confirm("您确定要删除这个宿管吗？")) {
				window.location = "DormManagerServlet?action=delete&dormManagerId=" + dormManagerId;
			}
		}

		$(document).ready(function () {
			$("ul li:eq(1)").addClass("active");
		});
</script>
	<div class="container">
		<p class="text-info">宿舍管理员管理</p>
	
		<button class="btn btn-info" type="button"
			onclick="javascript:window.location='DormManagerServlet?action=preSave'">添加</button>
		<div>
			<table class="table table-striped table-bordered table-hover datatable">
			<thead class="bg-info">
				<tr>
					<th>编号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>电话</th>
					<th>用户名</th>
					<th>操作</th>
				</tr>
				</thead>
					<tbody>
				<c:forEach varStatus="i" var="dormManager" items="${dormManagerList }">
					<tr>
						<td>${dormManager.dormManagerId }</td>
						<td>${dormManager.name }</td>
						<td>${dormManager.sex }</td>
						<td>${dormManager.tel }</td>
						<td>${dormManager.userName }</td>
						<td><button class="btn btn-mini btn-info" type="button"
								onclick="javascript:window.location='DormManagerServlet?action=preSave&dormManagerId=${dormManager.dormManagerId }'">修改</button>&nbsp;
							<button class="btn btn-mini btn-danger" type="button"
								onclick="dormManagerDelete(${dormManager.dormManagerId})">删除</button></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div align="center">
			<font color="red">${error }</font>
		</div>
	</div>