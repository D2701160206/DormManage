<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
		
		$(document).ready(function () {
			$("ul li:eq(2)").addClass("active");

		});

	</script>

<div class="container">

	<h3 class="text-info">宿舍信息</h3>

	<div>
		<table class="table table-striped table-bordered table-hover datatable">
			<thead class="bg-info">
				<tr>
					<th>宿舍号</th>
					<th>卫生</th>
					<th>电费</th>	
					<!-- <th>操作</th>	 -->
				</tr>
			</thead>
			<tbody>
				<c:forEach varStatus="i" var="dorm" items="${dormList }">
					<tr>

						<td>${dorm.dormName }</td>
						<td>${dorm.hygiene }</td>
						<td>${dorm.electric }</td>
					<%-- 
						<td><button class="btn btn-xs btn-info" type="button"
								onclick="javascript:window.location='DormServlet?action=preSave&dormId=${dorm.dormId }'">修改</button>&nbsp;
						</td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>