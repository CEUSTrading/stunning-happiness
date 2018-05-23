<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/ceustyle.css">
<link rel="icon" href="/images/favicon.png" type="image/gif"
	sizes="16x16">
<title>Error</title>
</head>
	<%@ include file="../view/header.jsp"%>
<body>
	<div class="container c-medium-left">
		<h1>¡Ups! - Se ha producido un error</h1>
		<h4>Ha habido un error con su petición</h4>
		<p>Parece que se ha producido un error inesperado.</p>
		<p class="l-left">
			Vuelva a intentar realizar la operación que quiera, si persiste el
			error, pongase en contacto con el equipo técnico. <i>Todos
				cometemos errores</i>.
		</p>
		<a href="index.jsp">Volver a la página principal</a>
	</div>
	<div class="container c-center">
		<img src="images/sad-zeus.png" height="500" width="530" />
	</div>
</body>
<%@ include file="view/footer.html"%>
</html>
