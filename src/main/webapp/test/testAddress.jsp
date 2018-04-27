<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Probando las direcciones de Blockchain</title>
</head>
<body>
	<p><strong>Dirección consultada: </strong> <c:out value="${requestScope.values[0]}"></c:out></p>
	<p>Total enviado: <c:out value="${requestScope.values[1]}"></c:out> BTC</p>
	<p>Total recibido: <c:out value="${requestScope.values[2]}"></c:out> BTC</p>
	<p>Balance total: <c:out value="${requestScope.values[3]}"></c:out> BTC</p>
</body>
</html>