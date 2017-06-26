<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>User Register Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
    <script type="text/javascript">
    <!--
        function alertValue(obj) {
    	    // alert(obj.value);
    	    // alert(document.getElementById("password").value);
    	    //	alert(document.getElementById("confirm").value);
    	    if(obj.value != document.getElementById("noEncodedPassword").value){
    	    	document.getElementById("confirmPassword").style.backgroundColor = "red";
    	        document.getElementById("confirm").disabled = true;
    	    } else {
    	        document.getElementById("confirmPassword").style.backgroundColor = "white";
    	        document.getElementById("confirm").disabled = false;
    	    }
    	}
    // -->
    </script>
</head>
<body>
	<div class="container">

		<form:form action="${pageContext.request.contextPath}/user/register"
			method="post" modelAttribute="userForm">

			<h2>User Register Page</h2>
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
					<td><fmt:formatDate value="${userForm.birthday}" pattern="yyyy-MM-dd" var="formattedBirthday" /><input
						type="date" id="birthday" name="birthday"
						value="${formattedBirthday}"> <form:errors path="birthday"
							cssClass="error-messages" /></td>
				</tr>
				<tr>
					<td><form:label path="address" cssErrorClass="error-label">address</form:label></td>
					<td><form:input path="address" cssErrorClass="error-input" /> <form:errors
					    path="address" cssClass="error-messages" /></td>
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
					<td><form:label path="noEncodedPassword" cssErrorClass="error-label">password</form:label></td>
					<td><form:password path="noEncodedPassword" cssErrorClass="error-input" />
						<form:errors path="noEncodedPassword" cssClass="error-messages" /></td>
				</tr>
				<tr>
				    <td><label for="confirmPassword">confirmPassword</label></td>
					<td>
					    <input type="password" id="confirmPassword" onChange="alertValue(this)" />
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input disabled type="submit" name="confirm" id="confirm"
						value="confirm" /></td>
				</tr>
			</table>
		</form:form>

		<form method="get"
			action="${pageContext.request.contextPath}/topmenu">
			<input type="submit" name="home" id="home" value="Top Menu" />
		</form>
	</div>
</body>
</html>