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
<title>Error 404</title>
</head>
	<%@ include file="../view/header.jsp"%>
	<div class="container c-medium-left">
	<h1>¡Ups! - Error 404</h1>
		<h4>Ha habido un error cargando la página</h4>
		<p class="l-left">O la URL estaba mal escrita o estas buscando algo que no hemos
			implementado aún.
			Aun si estás 100% seguro de que no te ha pasado nada de eso,
			compruébalo otra vez. <i>Todos cometemos errores</i>.
		</p>
		<a href="index.jsp">Volver a la página principal.</a>
	</div>
	<div class="container c-center">
		<img src="images/sad-zeus.png" height="500" width="530" />
	</div>
</body>
<%@ include file="view/footer.html"%>
</html>
