<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/ceustyle.css">
</head>
<body>
<header>
	<div class="nav">
		<div id=nav-iz>
			<img alt="logo" src="../images/protologo2white.png" class="logo" />
		</div>
	</div>
		<ul id=menu-header>
			<li><a href="../index.jsp">Inicio</a></li>
			<li><a href="header.html">Mapa</a></li>
			<li><a href="#">Consulta de precios</a></li>
			<li><a href="#">Consulta de direcciones</a></li>
			<c:set var="infos" value="${requestScope.Infos}" />
			<c:if test="${empty infos}">
    		<div class="dropdown">
				  <button class="dropbtn">Login</button>
				  <div class="dropdown-content">
				    <a href="#">Registro con CEUS</a>
				    <a href="../googleAuth">Registro con Google</a>
				  </div>
				</div>
			</c:if>
			<c:if test="${not empty infos}">
			   	<li>¡Bienvenido, <c:out value="${requestScope.Infos[0]}"></c:out>!</li>
			</c:if>
			<!-- <div id="nav-login">
				<p>Login</p>
				</div> -->
		</ul>
</header>
</body>
</html>