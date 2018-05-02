<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Probando los valores historicos del BTC</title>
</head>
<body>
	<h2>Valores de BTC de treinta días atrás</h2>
	<c:forEach items="${requestScope.map}" var="entry" >
		<p>Día: ${entry.key}</p>
		<p>Valor: ${entry.value}</p>
	</c:forEach>
</body>
</html>