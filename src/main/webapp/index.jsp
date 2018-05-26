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
<title>Cryptocurrency Exchange Unified Service</title>
</head>

	<%@ include file="../view/header.jsp"%>
	<script>
		window.twttr = (function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0], t = window.twttr || {};
			if (d.getElementById(id))
				return t;
			js = d.createElement(s);
			js.id = id;
			js.src = "https://platform.twitter.com/widgets.js";
			fjs.parentNode.insertBefore(js, fjs);

			t._e = [];
			t.ready = function(f) {
				t._e.push(f);
			};

			return t;
		}(document, "script", "twitter-wjs"));

		function masInfo() {
			document.getElementById('a-mas-info').setAttribute("onclick",
					"menosInfo()");
			document.getElementById('mas-info').innerHTML = '<div class="container c-left"> <h2>¿Qué ofrecemos?</h2>'
					+ '<p>Desde nuetra web, puedes acceder a diversas funcionalidades que satisfarán tus necesidades '
					+ 'en cuanto a Bitcoin se refieren. Podrás controlar el histórico de valores de Bitcoin en diversas '
					+ 'monedas, consultar el balance de tu monedero o encontrar lugares cercanos donde poder usar tus Bitcoin. '
					+ 'Además, a través de la aplicación de mensajería <a href="https://telegram.org/">Telegram</a> podrás '
					+ 'recibir, periódicamente, las variaciones en el precio del Bitcoin, para que no pierdas detalle de las '
					+ 'novedades donde quiera que vayas.</p>'
					+ '</div>'
					+ '<div class="container c-center">'
					+ '<h2>¿Por qué usar CEUS?</h2>'
					+ '<p>Si bien es cierto que no ofrecemos nada nuevo, pues todas nuestras funcionalidades ya existían antes, '
					+ '<strong>CEUS</strong> une todas estas funcionalidades en una sola aplicación, de modo que toda la información '
					+ 'que se puede necesitar se puede encontrar en un único lugar, en vez de en varias aplicaciones separadas.</p>'
					+ '</div>'
					+ '<div class="container c-right">'
					+ '<h2>¿Qué gano al loguearme?</h2>'
					+ '<p>Si te registras en nuestra aplicación, a todas las funcionalidades anteriores se unirá también el poder '
					+ 'guardar las direcciones que consultas. De este modo, en vez de tener que copiar y pegar tus direcciones de '
					+ 'la Blockchain cada vez que quieras consultarlas, al introducirlas una vez podrás acceder a ellas siempre '
					+ 'que quieras. </p>'
					+ '</div>';
		}
		function menosInfo() {
			document.getElementById('a-mas-info').setAttribute("onclick",
					"masInfo()");
			document.getElementById('mas-info').innerHTML = "";
		}
	</script>
	<main> <c:set var="email" value="${sessionScope.email }" />
	<h1 class="center">Un único lugar para todo lo que necesitas saber
		sobre Bitcoin</h1>
	<c:if test="${email=='gongargra@alum.us.es' or email=='chema@alum.us.es' or email=='manuel@alum.us.es'}">
			<p class="center">Además, también puedes postear en Twitter y Telegram:</p>
			<form class="center" action="../TelegramController">
				<input type="submit" value="Postear">
			</form>
	</c:if>
	<div>
	<div class="container c-left">
		<c:if test="${not empty email}">
			<form action="../view/HistoricalData.jsp">
		</c:if>
		<c:if test="${empty email}">
			<form action="../view/Login.jsp">
		</c:if>
		<button class="boton-light">Consultar el histórico de precios
			de un Bitcoin</button>
		</form>
	</div>
	<div class="container c-center">
		<form action="../view/mapa.jsp">
			<button class="boton-light">Consultar lugares donde usar tus
				Bitcoin</button>
		</form>
	</div>
	<div class="container c-right">
		<form action="https://t.me/CryptoEUS">
			<button class="boton-light">Consultar nuestro canal en
				Telegram</button>
		</form>
	</div>

	<h1 class="center">
		<a onclick="masInfo()" id="a-mas-info">¿Qué es CEUS
			(Cryptocurrency Exchange Unified Service)?</a>
	</h1>
	<div id="mas-info"></div>

	</main>
</body>
<%@ include file="view/footer.html"%>

</html>