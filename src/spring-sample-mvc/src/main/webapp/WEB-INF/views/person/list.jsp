<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Persons</h1>

	<table style="border: 1px solid black">
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="person" items="${persons}">
				<tr>
					<td>${person.name}</td>
					<td>${person.age}</td>
					<c:url value="/person/delete/${person.name}" var="delete" />
					<td><form:form action="${delete}" method="delete">
							<input type="submit" value="Delete" />
						</form:form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<c:url value="/person/save" var="save" />
	<form:form action="${save}" method="get">
		<form:errors path="*" />
		<br />
		<input type="text" name="name" />
		<form:errors path="name" />
		<br />
		<input type="text" name="age" />
		<form:errors path="age" />
		<br />
		<input type="submit" value="New (Get)" />
	</form:form>
	<form:form action="${save}" method="post" commandName="person">
		<br />
		<input type="text" name="name" />
		<form:errors path="name" />
		<br />
		<input type="text" name="age" />
		<form:errors path="age" />
		<br />
		<input type="submit" value="New (Post + Valid)" />
	</form:form>
</body>
</html>