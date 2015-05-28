<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Persons</h1>

	<c:url value="/j_spring_security_logout" var="logut" />

	<h2>
		Person Name: ${personName} [<a href="${logut}">Logout</a>]
	</h2>

	<table style="border: 1px solid black;">
		<thead>
			<tr>
				<th>Name</th>
				<th>Password</th>
				<th>Age</th>
				<th>Enabled</th>
				<th>Roles</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="person" items="${persons}">
				<tr>
					<td>${person.personName}</td>
					<td>${person.personPassword}</td>
					<td>${person.personAge}</td>
					<td>${person.personEnabled}</td>
					<td><c:forEach var="rol" items="${person.roles}">
						${rol.rolName}</c:forEach></td>
					<c:url value="/person/delete/${person.personName}" var="delete" />
					<td><form:form action="${delete}" method="delete">
							<input type="submit" value="Delete" />
						</form:form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br />

	<c:url value="/person/save" var="save" />
	<form:form action="${save}" method="post" commandName="person" >
		PersonName:
		<form:input path="personName" />
		<form:errors path="personName" />
		<br />
		PersonPassword:
		<form:password path="personPassword" />
		<form:errors path="personPassword" />
		<br />
		PersonAge:
		<form:input path="personAge" />
		<form:errors path="personAge" />
		<br />
		PersonEnabled:
		<form:checkbox path="personEnabled" />
		<form:errors path="personEnabled" />
		<br />
		<input type="submit" value="New" />
	</form:form>
</body>
</html>