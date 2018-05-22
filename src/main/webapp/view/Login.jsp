<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn</title>
</head>
<body>

	<div id="centrado">
		<h1>Bienvenido a CEUS</h1>
		<img src="../images/protologo.png" />
		<c:set var="err" value="${sessionScope.err}" />
		<c:if test="${empty err }">
			<c:out value="${sessionScope.err }"></c:out>
		</c:if>
		
		<form action="../loginController" method="Post">
			<label>email:</label><input name="email" type="text" placeholder="example@somewhere.com">
			<input type="submit" value="Entrar">
		</form>
	</div>
	
</body>
</html>