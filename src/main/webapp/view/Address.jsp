<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/ceustyle.css">
<link rel="icon" href="../images/favicon.png" type="image/gif"
	sizes="16x16">
<title>Cuentas</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script type="text/javascript">
	function cargaValorCuenta(cuenta) {

	}
</script>
</head>
<body>

	<%@ include file="../view/header.jsp"%>

	<c:set var="email" value="${sessionScope.email}" />
	<c:set var="lista" value="${requestScope.lista}" />

	<c:if test="${empty email}">
		<h1>WOPS! Parece que no estás loggeado.</h1>
		<a href="../index.jsp">Volver</a>
	</c:if>
	<c:if test="${not empty email}">
		<div id="selector_cuentas" class="container c-left">
			<div id="nueva_cuenta">
				<form action="../AddAddressController" method="Post">
					<label>Nueva Cuenta: </label><input type="text" name="addr" /> <input
						type="submit" />
				</form>
			</div>
			<c:if test="${not empty lista }">
				<div id="lista_cuentas"  class="container c-medium-left">
					<form action="../BlockchainAddressController" method="Post">
						<select name="address" size="${fn:length(lista)}">
							<c:forEach items="${lista}" var="dir">
								<option value="${dir}">${dir}</option>
							</c:forEach>
						</select> <input value="Consultar" type="submit">
					</form>
				</div>
			</c:if>

		</div>

		<div class="container c-medium-left" id="vista_movimientos">
			<h2>
				Cuenta:
				<c:out value="${requestScope.values[0]}"></c:out>
			</h2>
			<p>
				Total enviado:
				<c:out value="${requestScope.values[1]}"></c:out>
				BTC
			</p>
			<p>
				Total recibido:
				<c:out value="${requestScope.values[2]}"></c:out>
				BTC
			</p>
			<p>
				Balance total:
				<c:out value="${requestScope.values[3]}"></c:out>
				BTC
			</p>
		</div>
	</c:if>

	<%@ include file="../view/footer.html"%>

</body>
</html>