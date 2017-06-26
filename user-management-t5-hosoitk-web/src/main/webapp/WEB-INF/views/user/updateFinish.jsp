<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Account Update Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
	<div class="container">

		<h3>Your account has updated.</h3>
		<table>
			<tr>
				<td><label for="userId">userId</label></td>
				<td><span id="userId">${f:h(userForm.userId)}</span></td>
			</tr>
			<tr>
				<td><label for="username">username</label></td>
				<td><span id="username">${f:h(userForm.username)}</span></td>
			</tr>
			<tr>
				<td><label for="birthday">birthday</label></td>
				<td><span id="birthday"><fmt:formatDate
							value="${userForm.birthday}" pattern="yyyy-MM-dd" /></span></td>
			</tr>
			<tr>
				<td><label for="address">address</label></td>
				<td><span id="address">${f:h(userForm.address)}</span></td>
			</tr>
			<tr>
				<td><label for="telNum">telNum</label></td>
				<td><span id="telNum">${f:h(userForm.telNum)}</span></td>
			</tr>
			<tr>
				<td><label for="roles">roles</label></td>
				<td><span id="roles">${f:h(userForm.roles)}</span></td>
			</tr>
			<tr>
				<td><label for="noEncodedPassword">password</label></td>
				<td><span id="noEncodedPassword">****</span></td>
			</tr>
		</table>

		<form method="get"
			action="${pageContext.request.contextPath}/topmenu">
			<input type="submit" id="home" name="home" value="Top Menu" />
		</form>

	</div>
</body>
</html>