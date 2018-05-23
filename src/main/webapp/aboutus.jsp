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
<title>Sobre Nosotros</title>
</head>
<body>

	<%@ include file="../view/header.jsp"%>
	<main>
	<h1>Sobre nosotros</h1>
	<p>
		<strong>CEUS</strong> es un proyecto realizado para la asignatura de
		AISS, impartida en la Universidad de Sevilla.
	</p>
	<p>El equipo de CEUS está formado por:</p>
	<div class="center">
		<div class="container au-left">
			<img src="images/team/gonperfil.jpg" class="au-img" height="200" width="200" />
			<h3>Gonzalo García Granés</h3>
			<p>
				<i>"En mi tiempo libre intento escribir. <u>Intento</u>."
				</i>
			</p>
		</div>
		<div class="container au-center">
			<img src="images/team/manuperfil.jpg" class="au-img" height="200"
				width="200" />
			<h3>Manuel Cecilio Pérez Guitiérrez</h3>
			<p>
				<i>"Tú pon que me gusta comer."</i>
			</p>
		</div>
		<div class="container au-right">
			<img src="images/team/chemaperfil.jpg" class="au-img" height="200"
				width="200" />
			<h3>Jose Manuel López Carnicer</h3>
			<p>
				<i>"Sayonara, baby."</i>
			</p>
		</div>
	</div>
	</main>
</body>
<%@ include file="../view/footer.html"%>
</html>
