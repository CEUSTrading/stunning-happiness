<%@ include file="view/header.jsp" %>
<title>Cryptocurrency Exchange Unified Service</title>
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
	
	function masInfo(){
		document.getElementById('a-mas-info').setAttribute("onclick", "menosInfo()");
		document.getElementById('mas-info').innerHTML = '<div class="container c-left"> <h2>�Qu� ofrecemos?</h2>' +
			'<p>Desde nuetra web, puedes acceder a diversas funcionalidades que satisfar�n tus necesidades ' + 
			'en cuanto a Bitcoin se refieren. Podr�s controlar el hist�rico de valores de Bitcoin en diversas ' +
			'monedas, consultar el balance de tu monedero o encontrar lugares cercanos donde poder usar tus Bitcoin. ' +
			'Adem�s, a trav�s de la aplicaci�n de mensajer�a <a href="https://telegram.org/">Telegram</a> podr�s ' +
			'recibir, peri�dicamente, las variaciones en el precio del Bitcoin, para que no pierdas detalle de las ' +
			'novedades donde quiera que vayas.</p>' +
		'</div>' +
		'<div class="container c-center">' +
			'<h2>�Por qu� usar CEUS?</h2>' +
			'<p>Si bien es cierto que no ofrecemos nada nuevo, pues todas nuestras funcionalidades ya exist�an antes, ' +
			'<strong>CEUS</strong> une todas estas funcionalidades en una sola aplicaci�n, de modo que toda la informaci�n ' +
			'que se puede necesitar se puede encontrar en un �nico lugar, en vez de en varias aplicaciones separadas.</p>' +
		'</div>'+
		'<div class="container c-right">'+
			'<h2>�Qu� gano al loguearme?</h2>' +
			'<p>Si te registras en nuestra aplicaci�n, a todas las funcionalidades anteriores se unir� tambi�n el poder ' +
			'guardar las direcciones que consultas. De este modo, en vez de tener que copiar y pegar tus direcciones de ' +
			'la Blockchain cada vez que quieras consultarlas, al introducirlas una vez podr�s acceder a ellas siempre ' +
			'que quieras.</p>' +
		'</div>';
	}
	function menosInfo(){
		document.getElementById('a-mas-info').setAttribute("onclick", "masInfo()");
		document.getElementById('mas-info').innerHTML = "";
	}
</script>
<main>
	<h1 class="center">Un �nico lugar para todo lo que necesitas saber sobre Bitcoin</h1>
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
		<p class="center">Adem�s, tambi�n puedes:</p>
		<div class="container c-left">
			<form action="#">
			<button class="boton-light">Consultar el hist�rico de precios de un Bitcoin</button>
			</form>
		</div>
		<div class="container c-center">
			<form action="#">
			<button class="boton-light">Consultar lugares donde usar tus Bitcoin</button>
			</form>
		</div>
		<div class="container c-right">
			<form action="https://t.me/CryptoEUS">
			<button class="boton-light">Consultar nuestro canal en Telegram</button>
			</form>
		</div>
		
	<h1 class="center"><a onclick="masInfo()" id="a-mas-info">�Qu� es CEUS (Cryptocurrency Exchange Unified Service)?</a></h1>
	<div id="mas-info">	</div>
	
</main>
</body>
<%@ include file = "view/footer.html" %>

</html>