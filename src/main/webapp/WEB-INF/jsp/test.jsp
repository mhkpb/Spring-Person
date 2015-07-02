<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>TestCase Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a Test
</h1>
 
<c:url var="addAction" value="/t/test/add" ></c:url>
 
<form:form action="${addAction}" commandName="test">
<table>
    <c:if test="${!empty test.date}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="date">
                <spring:message text="Date"/>
            </form:label>
        </td>
        <td>
            <form:input path="date" />
        </td> 
    </tr>
     <tr>
        <td>
            <form:label path="clock">
                <spring:message text="Clock"/>
            </form:label>
        </td>
        <td>
            <form:input path="clock" />
        </td> 
    </tr>
   
    <tr>
        <td colspan="2">
            <c:if test="${!empty test.date}">
                <input type="submit"
                    value="<spring:message text="Edit Test"/>" />
            </c:if>
            <c:if test="${empty test.date}">
                <input type="submit"
                    value="<spring:message text="Add Test"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>Tests List</h3>
<c:if test="${!empty listTests}">
    <table class="tg">
    <tr>
        <th width="80">Teste ID</th>
        <th width="120">Teste Date</th>
        <th width="120">Teste Clock</th>
      
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listTests}" var="testcase">
        <tr>
            <td>${test.id}</td>
            <td>${test.date}</td>
        
            <td><a href="<c:url value='/tc/edit/${test.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/tc/remove/${test.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>