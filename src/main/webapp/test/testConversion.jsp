<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Probando la conversi�n de monedas</title>
</head>
<body>
	<p><c:out value="${requestScope.results[0]}"></c:out> <c:out value="${requestScope.results[1]}"></c:out> 
	son <c:out value="${requestScope.results[2]}"></c:out> BTC </p>

</body>
</html>