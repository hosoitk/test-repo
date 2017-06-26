<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>

<!-- (1) -->
<sec:authentication property="principal.account" var="account" />

<body>
    <div id="wrapper">
        <h1>Hello world!</h1>
        <p>The time on the server is ${serverTime}.</p>
        <!-- (2) -->
        <p>Welcome ${f:h(account.userId)} ${f:h(account.username)} !!</p>
        <form method="get"
			action="${pageContext.request.contextPath}/user/search">
			<input type="submit" name="form" value="Search" />
		</form>
		<form method="get"
			action="${pageContext.request.contextPath}/user/register">
			<input type="submit" name="form" value="Register" />
		</form>
    </div>
</body>
</html>