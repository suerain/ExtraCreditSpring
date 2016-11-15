<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Current Projects</title>
</head>
<body>
	<h1>List of current Projects</h1>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Location</th>
			<th>Description</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Status</th>
		</tr>
		<c:forEach var="project" items="${projects}">
			<tr>
				<td>${project.name}</td>
				<td>${project.location}</td>
				<td>${project.description}</td>
				<td>${project.startDate}</td>
				<td>${project.endDate}</td>
				<td>${project.status}</td>
				<td><a href="projects/${project.id}">View Task and
						Beneficiary</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a href="createProject">Create new Project</a>
	</sec:authorize>

	<br />
	<br /> Find Project By Resource
	<form action="findProjectByResource">
		Name: <input type="text" name="name" /> <input type="submit"
			value="Submit" />
	</form>
	<br /> Find Project By Location/Keyword
	<form action="findProjectByKeyword">
		Keyword/Location: <input type="text" name="name" /> <input
			type="submit" value="Submit" />
	</form>
	<br /> Find Project By Status
	<form action="findProjectByStatus">
		Status: <input type="text" name="name" /> <input type="submit"
			value="Submit" />
	</form>
	<br /> Find Project By Volunteer
	<form action="findProjectByVolunteer">
		Volunteer Name: <input type="text" name="name" /> <input
			type="submit" value="Submit" />
	</form>
	<br />
	<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>