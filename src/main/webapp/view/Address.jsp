<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cuentas</title>
</head>
<body>

	<div id="selector_cuentas">
		<div id="nueva_cuenta">
			<form action="./BlockchainAddressController.java">
				<label>Nueva Cuenta: </label><input type="text" name="addr" /> <input
					type="submit" />
			</form>
		</div>

		<div id="lista_cuentas">
			<!-- TODO: consultar lista de cuentas de persona y mostrarlas -->
		</div>

	</div>

	<div id="vista_movimientos">
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
</body>
</html>