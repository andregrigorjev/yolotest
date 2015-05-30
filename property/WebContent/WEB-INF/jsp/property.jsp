<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>springshop</title>
</head>
<body bgcolor="white">
<a href='s'>servlet</a> | <a href='http://imbi.ld.ttu.ee/tomcat_webapp_logs/property/log.txt'>log.txt</a> <br>
Property: 
<br>

	   
<c:if test="${not empty property}">
<form:form modelAttribute="property">
    <form:hidden path="property" />
	<table>
		<tr>
			<td>name:</td>
			<td><form:input path="type" />
				<form:errors path="type" />
	        </td>
	    </tr>       
	    <tr>
	    	<td>description:</td>
	    	<td><form:input path="description" /><form:errors path="description"/></td>
	    </tr>
	    <tr>
	    	<td colspan=2>
	    		<input type="submit"/>
	    	</td>
	    </tr>
	</table>
</form:form>
   </c:if>		   	  
   
</body>
</html>