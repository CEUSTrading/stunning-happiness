<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/ceustyle.css">
<link rel="icon" href="../images/favicon.png" type="image/gif"
	sizes="16x16">
<title>LogIn</title>
</head>
<body>

	<%@ include file="../view/header.jsp"%>

	<div id="centrado">
		<h1>Bienvenido a CEUS</h1>
		<img src="../images/protologo.png" />
		<c:set var="err" value="${sessionScope.err}" />
		<c:if test="${empty err }">
			<c:out value="${sessionScope.err }"></c:out>
		</c:if>
		
		<form action="../loginController" method="Post">
			<label>email:</label><input name="email" type="text" placeholder="example@somewhere.com">
			<label>contraseña:</label><input name="pass" type="password">
			<input type="submit" value="Entrar">
		</form>
	</div>
	<%@ include file="../view/footer.html"%>
</body>
</html>