<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Probando AllVenues</title>
</head>
<body>
	<table>
		<tr><th>Nombre</th><th>Tipo</th></tr>
		<c:forEach items="${requestScope.venues}" var="venue">
		<tr><td><c:out value="${venue.name}"></c:out></td><td><c:out value="${venue.category}"></c:out></td></tr>
		</c:forEach>
	</table>
</body>
</html>