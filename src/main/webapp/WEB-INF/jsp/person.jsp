<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Person Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a Person
</h1>
 
<c:url var="addAction" value="/p/person/add" ></c:url>
<c:url var="addTestCaseAction" value="/tc/testcases" ></c:url>
 
<form:form action="${addAction}" commandName="person">
<table>
    <c:if test="${!empty person.firstName}">
    <tr>
        <td>
            <form:label path="person_id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="person_id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="person_id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="firstName">
                <spring:message text="firstName"/>
            </form:label>
        </td>
        <td>
            <form:input path="firstName" />
        </td> 
    </tr>
    <tr>
        <td>
            <form:label path="lastName">
                <spring:message text="lastName"/>
            </form:label>
        </td>
        <td>
            <form:input path="lastName" />
        </td>
    </tr>
    
     <tr>
        <td>
            <form:label path="email">
                <spring:message text="email"/>
            </form:label>
        </td>
        <td>
            <form:input path="email" />
        </td> 
    </tr>
     <tr>
        <td>
            <form:label path="password">
                <spring:message text="password"/>
            </form:label>
        </td>
        <td>
            <form:input path="password" />
        </td> 
    </tr>
     <tr>
        <td>
            <form:label path="user_name">
                <spring:message text="user_name"/>
            </form:label>
        </td>
        <td>
            <form:input path="user_name" />
        </td> 
    </tr>
    
    <tr>
        <td colspan="2">
            <c:if test="${!empty person.firstName}">
                <input type="submit"
                    value="<spring:message text="Edit Person"/>" />
            </c:if>
            <c:if test="${empty person.firstName}">
                <input type="submit"
                    value="<spring:message text="Add Person"/>" />
            </c:if>
        </td>
    </tr>
</table> 

</form:form>



<%-- 
<form:form action="${addTestCaseAction}" commandName="testcase">
 <c:if test="${!empty listTestCases}">
  <select>
    <c:forEach items="${listTestCases}" var="testcase">
   
       <option value= " ${testcase.name} " >  ${testcase.name}  </option>

    </c:forEach>
     </select>
</c:if>
</form:form> 
--%>






<br>
<h3>Persons List</h3>
<c:if test="${!empty listPersons}">
    <table class="tg">
    <tr>
        <th width="80">Person ID</th>
        <th width="120">Person FirstName</th>
        <th width="120">Person LastName</th>
        <th width="120">Person Email</th>
        <th width="120">Person Password</th>
        <th width="120">Person UserName</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listPersons}" var="person">
        <tr>
            <td>${person.person_id}</td>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
             <td>${person.email}</td>
              <td>${person.password}</td>
               <td>${person.user_name}</td>
            <td><a href="<c:url value='/p/edit/${person.person_id}' />" >Edit</a></td>
            <td><a href="<c:url value='/p/remove/${person.person_id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>