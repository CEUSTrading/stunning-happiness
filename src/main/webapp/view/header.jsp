<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/ceustyle.css">
<link rel="icon" href="../images/favicon.png" type="image/gif" sizes="16x16">
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
			<li><a href="../view/mapa.jsp">Mapa</a></li>
			<li><a href="../view/converter.jsp">Consulta de precios</a></li>
			<li><a href="#">Consulta de direcciones</a></li>
			<c:set var="infos" value="${sessionScope.Infos}" />
			<c:if test="${empty infos}">
    		<div class="dropdown">
				  <button class="dropbtn">Login</button>
				  <div class="dropdown-content">
				  	<a href="./view/Login.jsp">Entrar</a>
				    <!-- <a href="#">Registro con CEUS</a> -->
				    <!-- <a href="../googleAuth">Registro con Google</a> -->
				    <a href="./view/Logup.jsp">Registrate</a>
				  </div>
				</div>
			</c:if>
			<c:if test="${not empty infos}">
			   	<!-- <li><a href="../closeSession">¡Bienvenido, <c:out value="${sessionScope.Infos[0]}"></c:out>!</a></li>  -->
			   	<li>!Bienvenido, <c:out value="${sessionScope.nombre}"></c:out></li>
			</c:if>
		</ul>
</header>
