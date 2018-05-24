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
<title>Historico BTC</title>
</head>
<body>
	<%@ include file="../view/header.jsp"%>
</head>
<body>
	<!-- HEADER -->

	<c:set var="email" value="${sessionScope.email}" />
	<c:if test="${empty email}">
		<h1>WOPS! Algo no va bien!</h1>
		<br />
		<p>
			<a href="../../index.jsp">INICIO</a>
		</p>
	</c:if>
	<c:if test="${not empty email }">
		<div class="container c-left" id="busqueda">
			<form action="/BlockchainHistoricalDataController" method="Post">
				<label>Días:</label>
				<input name="nCons" type="number" min="0" max="30"/>
				 <select name="cCons">
					<option value="1">$</option>
					<option value="2">€</option>
					<option value="3">£</option>
					<option value="4">¥</option>
					<option value="5">₩</option>
				</select>
				 <input type="submit" />
			</form>
			<p>Si desea, puede buscar los últimos 30 días si no incluye ningún día, se mostrarán los últimos 30.
			</p>
		</div>
		<div class="container c-center" id="mostrar busqueda">
			<c:set var="map" value="${requestScope.map}" />
			<c:if test="${not empty map }">
				<table id="tabla-precios">
					<tr>
						<th>DIA</th>
						<th>VALOR</th>
					</tr>
					<c:forEach items="${map}" var="entry">
						<tr>
							<td>${entry.key}</td>
							<td>${entry.value}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</c:if>
	<%@ include file="../view/footer.html"%>
	<!-- FOOTER -->
</body>
</html>