<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Persons</h1>

	<P>The time on the server is ${serverTime}.</P>

	<a href="person/list">List</a>

	<c:url value="/j_spring_security_logout" var="logut" />

	<a href="${logut}">Logout</a>

</body>
</html>
