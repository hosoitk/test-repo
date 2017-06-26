<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Item List Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/vendor/bootstrap-3.0.0/css/bootstrap.css"
	type="text/css" media="screen, projection">
</head>
<body>

	<sec:authentication property="principal.account" var="account" />
	<div style="display: inline-flex">
		welcome&nbsp;&nbsp; <span id="username">${f:h(account.userId)} ${f:h(account.username)}</span>
		<form method="post" action="${pageContext.request.contextPath}/logout">
			<input type="submit" id="logout" value="logout" />
			<sec:csrfInput />
		</form>
		<!-- <form method="get"
			action="${pageContext.request.contextPath}/account/update">
			<input type="submit" name="form1" id="updateAccount"
				value="Account Update" />
		</form> -->
	</div>
	<br>
	<br>

	<div class="container">
		<p>select a category</p>
		<br />
		<t:messagesPanel />
		<table>
			<tr>
			    <th></th>
				<th>NO.</th>
				<th>USER ID</th>
				<th>USER NAME</th>
				<th>BIRTHDAY</th>
				<th>ADDRESS</th>
				<th>TELEPHONE</th>
				<th>ROLE</th>
				<th>STATUS</th>
				<th>LAST UPDATE</th>
			</tr>
			<c:forEach items="${page.content}" var="account" varStatus="status">
				<tr>
				    <td>
				    <!-- <input id="selectedIsbns1" name="selectedIsbns" type="checkbox" value="${f:h(account.userId)}" form="form2" /> -->
				    </td>
				    <td>${status.count}</td>
					<td>
					<form:form id="form1" method="get" action="${pageContext.request.contextPath}/user/update" modelAttribute="userForm">
					    <input type=hidden name="form" />
					    <input type="hidden" name="userId" value="${f:h(account.userId)}" />
					    <a href="#" onClick="document.getElementById(&quot;form1&quot;).submit();">${f:h(account.userId)}</a>
				    </form:form>
				    <!-- <a id="${f:h(account.userId)}"
						href="${pageContext.request.contextPath}/user/update/${f:h(goods.id)}">${f:h(goods.name)}</a> -->
			        </td>
					<td>${f:h(account.username)}</td>
					<td>${f:h(account.birthday)}</td>
					<td>${f:h(account.address)}</td>
					<td>${f:h(account.telNum)}</td>
					<td>${f:h(account.roles)}</td>
					<td>${f:h(account.status)}</td>
					<td>${f:h(account.lastUpdate)}</td>
				</tr>
			</c:forEach>
		</table>
		<t:pagination page="${page}" outerElementClass="pagination" />
	</div>
	<div>
		<p>
			<fmt:formatNumber value="${page.totalElements}" />
			results <br> ${f:h(page.number + 1) } / ${f:h(page.totalPages)}
			Pages
		</p>
	</div>

</body>
</html>