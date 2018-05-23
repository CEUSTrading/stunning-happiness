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
<title>Cuentas</title>
</head>
<body>

	<%@ include file="../view/header.jsp"%>
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
      	margin-top: 4em;
        height: 50%;
        width: 50%;
        position: fixed;
        border: 3px solid #160f29;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
    <div class="container c-left">
  <p>Listado de los lugares donde se pueden usar BTC cerca de una ciudad dada</p>
		<form id="searchForm" action="../CoinmapLocationController" method="post">
			<input type="text" name="City" placeholder="Localización" required="">
			<input type="submit" value="Buscar">
		</form> <br />
	<p>Si tiene problemas con una localización, especifiquela más (localidad, provincia, país, código postal, calle... ) </p>
		<span hidden="" id="Name"><c:out value="${requestScope.venues[0]}"/></span>
		<span hidden="" id="Lat"><c:out value="${requestScope.venues[1]}"/></span>
		<span hidden="" id="Lon"><c:out value="${requestScope.venues[2]}"/></span>
		<span hidden="" id="Cat"><c:out value="${requestScope.venues[3]}"/></span>
		<span hidden="" id="Address"><c:out value="${requestScope.venues[4]}"/></span>
	</div>
    <div class="container" id="map"></div>
    <script>
    	// Array de información de las localizaciones obtenidas de coinmap
        var nameString = document.getElementById('Name').innerHTML;
        var latString = document.getElementById('Lat').innerHTML;
        var lonString = document.getElementById('Lon').innerHTML;
        var catString = document.getElementById('Cat').innerHTML;
        var addressString = document.getElementById('Address').innerHTML;
        
		var nameArray = nameString.split("#|");
		var latArray = latString.split("#|");
		var lonArray = lonString.split("#|");
		var catArray = catString.split("#|");
		var addressArray = addressString.split("#|");
		
		var z = 8;
		if(latArray.length==1 || latArray.length==0){
			var z = 1;
		}
		//creo el mapa
		 var map;
	      function initMap() {
	    	var centroLatLon = new google.maps.LatLng(latArray[0] ,lonArray[0]);
	        map = new google.maps.Map(document.getElementById('map'), {
	          zoom: z,
	          center: centroLatLon,
	          mapTypeId: 'roadmap'
	        });
	    
	      //creo los marcadores de los arrays anteriormente mencionados
        for (var i = 1; i < (nameArray.length)-1; i++) {
        	var myLatLng = new google.maps.LatLng(latArray[i], lonArray[i]);
        	var marker = new google.maps.Marker({
        	    position: myLatLng,
        	    map: map,
            	title: nameArray[i],
        	  });
            var content = '<h3>'+nameArray[i]+'</h3>'+
            'Tipo: '+catArray[i]+'</br>'+
            'Dirección: '+addressArray[i]+'</br>'+
            '<a href="https://www.google.com/maps?q='+latArray[i]+','+lonArray[i]+'" target="_blank">Como ir.</a>';
          	//Ventanas de información de negocio
            var infowindow = new google.maps.InfoWindow()
            google.maps.event.addListener(marker,'click', (function(marker,content,infowindow){ 
    	   	    return function() {
    	   	    	/*
    	   	    	en vez de una pantalla de infowindow, se muestra la información del negocio
    	   	    	para que sean ventanas de infowindow basta con descomentar las dos líneas
    	   	    	*/
    	   	    	var escribir = document.getElementById("Write");
    	   	    	escribir.innerHTML = content;
    	   	       //infowindow.setContent(content);
    	   	       //infowindow.open(map,marker);
    	   	    };
    	   	})(marker,content,infowindow));
        	};	
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC7AUgzLoCOLuNWjWlYQEHVTuVqP7jUJtI&callback=initMap">
    </script>
    <p class="container l-left" id="Write"></p>
  </body>
  <%@ include file="../view/footer.html"%>
</html>
