<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="header.jsp" %>
<title>Precio del bitcoin</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
	<p class="center">Convertir una cantidad dada de cualquier moneda a BTC</p>
	<form  class="center" action="BlockchainConverterController">
		<input  class="center" type="number" name="cantidad" placeholder="Cantidad"  min="0" required="">
		 <select name="moneda" required="">
			<option value="USD">USD</option>
			<option value="EUR">EUR</option>
			<option value="GBP">GBP</option>
			<option value="KRW">KRW</option>
			<option value="JPY">JPY</option>
		</select> <input type="submit" value="Convertir a BTC">
	</form>
	<br />
	<c:choose>
		<c:when test="${fn:length(requestScope)!=0|| requestScope!=null}">
			<p  class="center">
				<c:out value="${requestScope.results[0]}"></c:out>
				<c:out value="${requestScope.results[1]}"></c:out>
				son
				<c:out value="${requestScope.results[2]}"></c:out>
				BTC
			</p>

			<br />
		</c:when>
		<c:otherwise>
			<br />
		</c:otherwise>
	</c:choose>

</body>
<%@ include file = "footer.html" %>

</html>