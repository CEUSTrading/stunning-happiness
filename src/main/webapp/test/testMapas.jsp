<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
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
  </head>
  <body>
		<span hidden="" id="Name"><c:out value="${requestScope.venues[0]}"/></span>
		<span hidden="" id="Lat"><c:out value="${requestScope.venues[1]}"/></span>
		<span hidden="" id="Lon"><c:out value="${requestScope.venues[2]}"/></span>
		<span hidden="" id="Cat"><c:out value="${requestScope.venues[3]}"/></span>
    <div id="map"></div>
    <script>
    	// Array de información de las localizaciones obtenidas de coinmap
        var nameString = document.getElementById('Name').innerHTML;
        var latString = document.getElementById('Lat').innerHTML;
        var lonString = document.getElementById('Lon').innerHTML;
        var catString = document.getElementById('Cat').innerHTML;
        
		var nameArray = nameString.split("#|");
		var latArray = latString.split("#|");
		var lonArray = lonString.split("#|");
		var catArray = catString.split("#|");

		//creo el mapa
		 var map;
	      function initMap() {
	    	var centroLatLon = new google.maps.LatLng(latArray[0] ,lonArray[0]);
	        map = new google.maps.Map(document.getElementById('map'), {
	          zoom: 10,
	          center: centroLatLon,
	          mapTypeId: 'roadmap'
	        });
	    
	       	//Ventanas de información start
      	var myLatLng = new google.maps.LatLng(latArray[1], lonArray[1]);
	       	var contentString = '<div id="content">'+
          '<h1 id="firstHeading" class="firstHeading">'+nameArray[1]+'</h1>'+
          '<h2 id="secondHeading" class="secondHeading">'+catArray[1]+'</h2>'+
          '<p><a href="https://www.google.es/maps/place/"'+myLatLng+'>'+myLatLng+'</a>'+
          '</p>'+
          '</div>';
          //ventana de información End
	        var infowindow = new google.maps.InfoWindow({
              content: contentString
            });
	      //creo los marcadores de los arrays anteriormente mencionados
        for (var i = 1; i < (nameArray.length)-1; i++) {
        	var myLatLng = new google.maps.LatLng(latArray[i], lonArray[i]);
        	var marker = new google.maps.Marker({
        	    position: myLatLng,
        	    map: map,
            	title: nameArray[i],
        	  });

        	};
        	
              }
      	
	   	//Ventanas de información de negocio
	   	 marker.addListener('click', function() {
          infowindow.open(map, marker);
        });
		//forma de la ventana
      window.eqfeed_callback = function(results) {
        for (var i = 0; i < results.features.length; i++) {
          var coords = results.features[i].geometry.coordinates;
          var latLng = new google.maps.LatLng(coords[1],coords[0]);
          var marker = new google.maps.Marker({
            position: latLng,
            map: map
          });
        }
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC7AUgzLoCOLuNWjWlYQEHVTuVqP7jUJtI&callback=initMap">
    </script>
    <table>
    	<tr><th>Nombre</th></tr>
    	<c:forEach items="${requestScope.names}" var="name">
    	<tr><td><c:out value="${name}"></c:out></td></tr>
    	</c:forEach>
    </table>
  </body>
</html>





















