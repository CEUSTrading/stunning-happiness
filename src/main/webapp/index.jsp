<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<title>Cryptocurrency Exchange Unified Service</title>
<link rel="stylesheet" href="css/ceustyle.css">
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
</script>
</head>
<body>
<%@ include file="view/header.html" %>
<!-- <header>
	<div class="nav">
		<div id=nav-iz>
			<img alt="logo" src="images/protologo2white.png" class="logo" />
		</div>
	</div>	
</header>  -->
<main>
	<h1 class="center">Un único lugar para todo lo que necesitas saber sobre Bitcoin</h1>
		<p class="center">El precio actual de un BTC es de 
		<c:out value="${requestScope.results[0]}"></c:out><c:out value="${requestScope.results[1]}"></c:out>. </p>
		<form action="BlockchainPriceController">
		<p class="center">Puedes verlo en 
			<select name="moneda-price">
				<option value="1">USD</option>
				<option value="2">EUR</option>
				<option value="3">GBP</option>
				<option value="4">KRW</option>
				<option value="5">JPY</option>
			</select>
			<input type="submit" value="Cambiar moneda"/></p>
		</form>
		<!-- TODO: añadir botones para las demás cosas -->
	
	<h1 class="center">¿Qué es CEUS (Cryptocurrency Exchange Unified Service)?</h1>
	<div class="container c-left">
		<h2>¿Qué ofrecemos?</h2>
		<p>Desde nuetra web, puedes acceder a diversas funcionalidades que satisfarán tus necesidades
		en cuanto a Bitcoin se refieren. Podrás controlar el histórico de valores de Bitcoin en diversas
		monedas, consultar el balance de tu monedero o encontrar lugares cercanos donde poder usar tus Bitcoin.
		Además, a través de la aplicación de mensajería <a href="https://telegram.org/">Telegram</a> podrás
		recibir, periódicamente, las variaciones en el precio del Bitcoin, para que no pierdas detalle de las
		novedades donde quiera que vayas.</p>
	</div>
	<div class="container c-center">
		<h2>¿Por qué usar CEUS?</h2>
		<p>Si bien es cierto que no ofrecemos nada nuevo, pues todas nuestras funcionalidades ya existían antes,
		<strong>CEUS</strong> une todas estas funcionalidades en una sola aplicación, de modo que toda la información
		que se puede necesitar se puede encontrar en un único lugar, en vez de en varias aplicaciones separadas.</p>
	</div>
	<div class="container c-right">
		<h2>¿Qué gano al loguearme?</h2>
		<p>Si te registras en nuestra aplicación, a todas las funcionalidades anteriores se unirá también el poder
		guardar las direcciones que consultas. De este modo, en vez de tener que copiar y pegar tus direcciones de
		la Blockchain cada vez que quieras consultarlas, al introducirlas una vez podrás acceder a ellas siempre
		que quieras.</p>
	</div>
	
</main>
<%@ include file = "view/footer.html" %>
<!-- <footer>
		<div id="fot-iz">
			<img alt="logo" src="../images/protologo2black.png" class="logo-footer" /> <br/>
			<a class="twitter-follow-button"
				href="https://twitter.com/CryptoEUS" data-size="large"
				data-show-count="false"> Siguenos @CryptoEUS</a>
		</div>
		<div id="fot-der">
			<ul>
				<li><h3>Más Información:</h3></li>
				<li><a href="../tyc.html">Términos y condiciones</a></li>
				<li><a href="mailto:contact.ceus@gmail.com">Contacto</a></li>
				<li><a href="../aboutus.html">Sobre nosotros</a></li>
				<li><a href="../politicaPrivacidad.html">Política de privacidad</a>
				<li><a href="http://cryptoeus.appspot.com/docs/index.html">Documentaci�n de la api</a></li>
			</ul>
		</div>
	</footer> -->
</body>
</html>