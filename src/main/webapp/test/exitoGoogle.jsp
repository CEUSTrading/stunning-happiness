<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Probando el login de Google</title>
</head>
<body>
	<p>Nombre: <c:out value="${requestScope.Infos[0]}"></c:out></p>
	<p>Email: <c:out value="${requestScope.Infos[1]}"></c:out></p>
</body>
</html>