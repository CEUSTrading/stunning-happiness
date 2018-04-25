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
    <div id="map"></div>
    <script>
      var map;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          zoom: 6,
          center: new google.maps.LatLng(40.2871091,-3.7984027),
          mapTypeId: 'roadmap'
        });
        
        var marcadores = [
        	['Perico', 31.385064, 2.173404],
        	['Jacinta', 41.119019, 2.245212],
        	['Clorox', 21.9794, 1.821426],
        	['Sarin', 1.60034, 0.609762],
        	];
        
        for (var i = 0; i < marcadores.length; i++) {
        	var myLatLng = new google.maps.LatLng(marcadores[i][1], marcadores[i][2]);
        	var marker = new google.maps.Marker({
        	    position: myLatLng,
        	    map: map,
            	title: marcadores[i][0],
        	  });
        	};
        // Create a <script> tag and set the USGS URL as the source.
        //var script = document.createElement('script');
        // This example uses a local copy of the GeoJSON stored at
        // http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.geojsonp
        //script.src = 'http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.geojsonp';
        //document.getElementsByTagName('head')[0].appendChild(script);
      }

      // Loop through the results array and place a marker for each
      // set of coordinates.
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
  </body>
</html>





















