<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>property</title>
<script src="static/js/property.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<a href='s'>servlet</a> | <a href='http://imbi.ld.ttu.ee/tomcat_webapp_logs/property/log.txt'>log.txt</a>
<br>
<h2>Kinnisvara nimekiri</h2>
<c:if test="${not empty properties}">
	<table bgcolor='#000000' border=0 cellpadding=0 cellspacing=0>
		<tr>
			<td>
				<table width=100% border=0 cellpadding=2 cellspacing=1>
					<thead>
						<tr bgcolor='#cccccc'>
							<td><STRONG> kood&nbsp;</STRONG></td>
							<td><STRONG>tyyp&nbsp;</STRONG></td>
							<td><STRONG>tubade arv&nbsp;</STRONG></td>
							<td>......</td>
							<td>......</td>
						</tr>
						<tr></tr>
					</thead> 
					<tbody> 
						<c:forEach var="property" items="${properties}">	   
							<TR BGCOLOR='#FFFFFF' >
								<td style="text-align:center" nowrap>${property.propertyID}</td>
								<td>${property.type}</td>
								<td style="text-align:center">${property.rooms}</td>
								<TD nowrap><a HREF='javascript:get_property(${property.propertyID})' TARGET='_self'><b><u>kirjeldus</u></b></a></TD>
								<TD nowrap><b>
									<a href="<c:url  value="s"><c:param name="id" value="${property.propertyID}"/></c:url>">muuda</a>
								</b></TD>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
</c:if>
<br>
<br>
<div ID="ajax_response">
</div>
<div ID="description_form" style="visibility:hidden;">
<form name=description_form>
<TABLE BGCOLOR='#cccccc'>
<TR BGCOLOR='#ffffff'><TD BGCOLOR='#eeeeee' COLSPAN=2>Kirjeldus</TD></tr>
<TR BGCOLOR='#ffffff'><TD BGCOLOR='#cccccc' nowrap>kinnisvara id</td><td BGCOLOR='#cccccc'><input type=text name=property_id size=4 disabled></TD></tr>
<TR BGCOLOR='#ffffff'><TD BGCOLOR='#cccccc' nowrap>kirjeldus:</td><td BGCOLOR='#cccccc'><textarea name=description cols=25 rows=5></textarea></TD></tr>
<TR BGCOLOR='#ffffff'><TD BGCOLOR='#cccccc' nowrap COLSPAN=2><input type="button" value="KINNI" onClick="hide_description_form()"></TD></tr>
</TABLE>
</form>
</div>
</body>
</html>