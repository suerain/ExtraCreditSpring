<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create new Project</title>
</head>
<body>
	<h1>Project Description</h1>
	<form:form action="createProject" commandName="project">
		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name"></form:errors>
			</tr>
			<tr>
				<td>Location</td>
				<td><form:input path="location" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td><form:input path="startDate" /></td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><form:input path="endDate" /></td>
			</tr>
		</table>
		<input type="submit" value="Add Project" />
	</form:form>
</body>
</html>