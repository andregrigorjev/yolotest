<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>property</title>
</head>
<body bgcolor="white">
<a href="s">servlet</a> | <a href='http://imbi.ld.ttu.ee/tomcat_webapp_logs/property/log.txt'>log.txt</a> <br> 
<br>

	   
<c:if test="${not empty property}">
Property:
<br>
<form:form modelAttribute="property">
    <form:hidden path="propertyID" />
	<table bgcolor='#000000' border=0 cellpadding=0 cellspacing=0>
		<tr>
			<td>
				<table width=100% border=0 cellpadding=2 cellspacing=1>
					<tr BGCOLOR='#ffffff'>
						<td BGCOLOR='#cccccc' nowrap>id:</td>
						<td>&nbsp;<b><font color='#0000ff'>
							<form:input path="propertyID" disabled="true" /></font></b>
						</td>
					</tr>
					<tr BGCOLOR='#ffffff'>
						<td BGCOLOR='#cccccc' nowrap>type:</td>
						<td>&nbsp;<b><font color='#0000ff'>
							<form:input path="type" /></font></b>
							<form:errors path="type" />
						</td>
					</tr>
					<tr BGCOLOR='#ffffff'>
						<td BGCOLOR='#cccccc' nowrap>rooms:</td>
						<td>&nbsp;<b><font color='#0000ff'>
							<form:input path="rooms" /></font></b>
							<form:errors path="rooms" />
						</td>
					</tr>
					<tr BGCOLOR='#ffffff'>
						<td BGCOLOR='#cccccc' nowrap>description:</td>
						<td>&nbsp;<b><font color='#0000ff'>
							<form:textarea path="description" cols="25" rows="6" /></font></b>
							<form:errors path="description" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	 
   <c:if  test="${not empty saveinfo}">
      <br>
   	${saveinfo} 
   </c:if>
	<br>
	<input type="submit"/>
            
</form:form>

   </c:if>		 
   <c:if  test="${empty property}">
      <br>
   	Viga! Sellise ID-ga Property puuudub! 
   </c:if>
</body>
</html>