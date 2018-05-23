<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<title>Conversion BTC</title>
</head>
<body>

	<%@ include file="../view/header.jsp"%>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<div class="container c-left converter">
	<p class="center">
		El precio actual de un BTC es de
		<c:out value="${requestScope.results1BTC[0]}"></c:out>
		<c:out value="${requestScope.results1BTC[1]}"></c:out>
		.
	</p>
	<form action="../BlockchainPriceController">
		<p class="center">
			Puedes verlo en <select name="moneda-price" required>
				<option value="1">USD</option>
				<option value="2">EUR</option>
				<option value="3">GBP</option>
				<option value="4">KRW</option>
				<option value="5">JPY</option>
			</select> <input type="submit" value="Cambiar moneda" />
		</p>
	</form>
</div>
<div class="container c-right converter2">
	<p class="center">Convierte la cantidad que quieras, de la moneda
		que desees a BTC</p>
	<form class="center" action="../BlockchainConverterController">
		<input class="center" type="number" name="cantidad"
			placeholder="Cantidad" min="0" required> <select
			name="moneda" required>
			<option value="USD">USD</option>
			<option value="EUR">EUR</option>
			<option value="GBP">GBP</option>
			<option value="KRW">KRW</option>
			<option value="JPY">JPY</option>
		</select> <input type="submit" value="Convertir a BTC">
	</form>
	<br />
	<p class="center">
		<c:out value="${requestScope.results[0]}"></c:out>
		<c:out value="${requestScope.results[1]}"></c:out>
		son
		<c:out value="${requestScope.results[2]}"></c:out>
		BTC

	</p>
</div>
<br />
</body>
<%@ include file="../view/footer.html"%>
</html>