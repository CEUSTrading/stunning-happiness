<%@ include file="header.jsp" %>
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 50%;
        width: 50%;
        position: fixed;
        left: 50%;
        border: 3px solid #73AD21;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
  <h2 class="center">Búsqueda de lugares donde usar BTC</h2>
		<p>Introduce la ciudad donde quieras gastar tus BTC:</p> 
			<form id="searchForm" action="../CoinmapLocationController" method="post">
			<input type="text" name="City" placeholder="Ciudad/localidad">
			<input type="submit" value="Buscar">
			</form><br />
		<span hidden="" id="Name"><c:out value="${requestScope.venues[0]}"/></span>
		<span hidden="" id="Lat"><c:out value="${requestScope.venues[1]}"/></span>
		<span hidden="" id="Lon"><c:out value="${requestScope.venues[2]}"/></span>
		<span hidden="" id="Cat"><c:out value="${requestScope.venues[3]}"/></span>
		<span hidden="" id="Address"><c:out value="${requestScope.venues[4]}"/></span>
    <div class="center" id="map"></div>
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
    <p class="center" id="Write"></p>
  </body>
  <%@ include file = "footer.html" %>
</html>
