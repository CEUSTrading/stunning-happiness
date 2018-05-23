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
<title>LogUp</title>
</head>
<body>

	<%@ include file="../view/header.jsp"%>
	<h2>Bienvenido al sistema de registro de CEUS</h2>

	<div id="reg-pro">
		<p>Puedes registrarte añadiendo tu nombre y email</p>
		<form action="../AddUsuarioController" method="Post">
			<c:if test="${empty sessionScope.email}">
				<label>Nombre:</label>
				<input type="text" name="nombre" placeholder="nombre" />
				<label>email:</label>
				<input type="text" name="email" placeholder="example@somewhere.com" />
				<label>contraseña:</label>
				<input name="pass" type="password">
			</c:if>
			<c:if test="${not empty sessionScope.email}">

				<label>Nombre:</label>
				<input type="text" name="nombre" placeholder="nombre" value="${sessionScope.nombre }"/>
				<label>email:</label>
				<input type="text" name="email" placeholder="example@somewhere.com" value="${sessionScope.email }"/>
				<label>contraseña:</label>
				<input name="pass" type="password">

			</c:if>

			<input type="submit" value="Registrate">
		</form>
	</div>
	<div id="google">
		<p>Si lo prefieres puedes registrarte a través de Google</p>
		<a href="../googleAuth">Google</a>
	</div>
	<%@ include file="../view/footer.html"%>
</body>
</html>