<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>    
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Historico BTC</title>
</head>
<body>
	<!-- HEADER -->

	<div class="tabla-h">
		<form action="">
			<select>
				<option value="1">$</option>
				<option value="2">€</option>
				<option value="3">£</option>
				<option value="4">¥</option>
				<option value="5">₩</option>
			</select> <input type="submit" />
		</form>

		<table>
			<tr>
				<th>DIA</th>
				<th>VALOR</th>
			</tr>
			<c:forEach items="${requestScope.map}" var="entry">
				<tr>
					<td>${entry.key}</td>
					<td>${entry.value}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<!-- FOOTER -->
</body>
</html>