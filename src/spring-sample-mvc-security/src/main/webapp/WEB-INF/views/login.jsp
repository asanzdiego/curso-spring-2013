<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<style>
.errorblock {
		color: #ff0000;
		background-color: #ffEEEE;
		border: 3px solid #ff0000;
		padding: 8px;
		margin: 16px;
}
</style>
</head>
<body>
	<h3>Login with Username and Password (Custom Page)</h3>

	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

	<form action="<c:url value='j_spring_security_check' />" method='POST'>
		User: <input type='text' name='j_username' value='' /><br />
		Password: <input type='password' name='j_password' /><br />
		<br /> <input name="submit" type="submit" value="submit" />
	</form>
</body>
</html>