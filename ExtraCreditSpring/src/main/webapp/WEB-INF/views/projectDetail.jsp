<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project Detail</title>
</head>
<body>
	<h1>List of task</h1>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Status</th>
			<th>Start Date</th>
			<th>End Date</th>
		</tr>
		<c:forEach var="task" items="${taskList}">
			<tr>
				<td>${task.taskName}</td>
				<td>${task.status}</td>
				<td>${task.startDate}</td>
				<td>${task.endDate}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="addTask/${id}">Add Task</a>
	<br />
	<br />
	<h1>List of beneficiary</h1>
	<table border="1">
		<tr>
			<th>Name</th>
		</tr>
		<c:forEach var="beneficiary" items="${beneficiaryList}">
			<tr>
				<td>${beneficiary.name}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="addBeneficiary/${id}">Add Beneficiary</a>
	<br />
</body>
</html>