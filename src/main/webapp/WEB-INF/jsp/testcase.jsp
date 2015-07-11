<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>TestCase Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<h1>Add a TestCase</h1>

	<c:url var="addAction" value="/tc/testcase/add"></c:url>



	<%-- <form:select path="personDao">
    <form:options items="${listPersons}" />
</form:select>
 --%>
	<form:form action="${addAction}" commandName="testcase">
		<table>
			<c:if test="${!empty testcase.name}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>

			<%-- 
			<c:if test="${!empty listPersons}">
						<select id="person">
							<c:forEach items="${listPersons}" var="person">

								<option value=" ${person.person_id}">Select Person :
									${person.person_id} - ${person.firstName} ${person.lastName}</option>

							</c:forEach>
						</select>
					</c:if>
					 --%>


			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>


			<form:select path="person">
				<form:options items="${listPersons}" itemValue="person_id" />
			</form:select>


			<tr>

				<td colspan="2"><c:if test="${!empty testcase.name}">
						<input type="submit"
							value="<spring:message text="Edit Testcase"/>" />
					</c:if> <c:if test="${empty testcase.name}">
						<input type="submit" value="<spring:message text="Add Testcase"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>

	<h3>Testcases List</h3>
	<c:if test="${!empty listTestCases}">
		<table class="tg">
			<tr>
				<th width="80">Testcase ID</th>
				<th width="120">Testcase Name</th>

				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listTestCases}" var="testcase">
				<tr>
					<td>${testcase.id}</td>
					<td>${testcase.name}</td>

					<td><a href="<c:url value='/tc/edit/${testcase.id}' />">Edit</a></td>
					<td><a href="<c:url value='/tc/remove/${testcase.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>