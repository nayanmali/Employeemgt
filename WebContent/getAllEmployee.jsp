<%@include file="components/header.jsp"%>
<%@include file="components/menu.jsp"%>

<table class="table table-bordered">
	<c:forEach items="${employeeList}" var="employee">
		<tr>
			<td>${employee.id}</td>
			<td>${employee.name}</td>
			<td>${employee.email}</td>
		</tr>
	</c:forEach>
</table>
<%@include file="components/footer.jsp"%>