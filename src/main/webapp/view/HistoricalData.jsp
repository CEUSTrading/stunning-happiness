<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Histórico BTC</title>
</head>
<body>
	<!-- HEADER -->

	<div class="tabla-h">

		<c:forEach items="${requestScope.map}" var="entry">
			<span><p>Día: ${entry.key}</p><p>Valor: ${entry.value}</p></span>
		</c:forEach>

	</div>

	<!-- FOOTER -->
</body>
</html>