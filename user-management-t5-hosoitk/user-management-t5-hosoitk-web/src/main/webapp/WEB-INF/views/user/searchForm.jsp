<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>User Search Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>

	<div class="container">

	    <form:form action="${pageContext.request.contextPath}/user/search"
	        method="post" modelAttribute="userForm">

			<h2>User Search Page</h2>
			<table>
				<tr>
					<td><form:label path="userId" cssErrorClass="error-label">userId</form:label></td>
					<td><form:input path="userId" cssErrorClass="error-input" /> <form:errors
							path="userId" cssClass="error-messages" /></td>
				</tr>
				<tr>
					<td><form:label path="username" cssErrorClass="error-label">username</form:label></td>
					<td><form:input path="username" cssErrorClass="error-input" /> <form:errors
							path="username" cssClass="error-messages" /></td>
				</tr>
				<tr>
					<td><form:label path="birthday" cssErrorClass="error-label">birthday</form:label></td>
					<td><fmt:formatDate value="${userForm.birthday}"
							pattern="yyyy-MM-dd" var="formattedBirthday" /><input
						type="date" id="birthday" name="birthday"
						value="${formattedBirthday}"> <form:errors path="birthday"
							cssClass="error-messages" /></td>
				</tr>
				<tr>
					<td><form:label path="address" cssErrorClass="error-label">address</form:label></td>
					<td><form:input path="address"
							value="${f:h(userForm.address)}"
							cssErrorClass="error-input" /> <form:errors path="address"
							cssClass="error-messages" /></td>
				</tr>
				<tr>
					<td><form:label path="telNum" cssErrorClass="error-label">telNum</form:label></td>
					<td><form:input path="telNum" cssErrorClass="error-input" /> <form:errors
							path="telNum" cssClass="error-messages" /></td>
				</tr>
				<tr>
					<td><form:label path="roles" cssErrorClass="error-label">roles</form:label></td>
					<td><form:input path="roles" cssErrorClass="error-input" /> <form:errors
							path="roles" cssClass="error-messages" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="Search" /></td>
				</tr>
			</table>
		</form:form>

	</div>
</body>
</html>