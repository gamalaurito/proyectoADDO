<!DOCTYPE html>
<html>
<head>
<title>Jamaica Flower Shop</title>
<%@include file = "imports.jsp"%>
<style>
    /* Always set the map height explicitly to define the size of the div
     * element that contains the map. */
    #map {
      height: 100%;
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
	<%if(request.getSession().getAttribute("active") != null) {%>
		<%@include file="headerL.jsp"%>
	<%} else {%>
		<%@include file="header.jsp"%>
        <%}%>
        <!---->
               <%@include file="menu.jsp"%>
        <!---->
<!---->
    <div id="map"></div>
    
    <script>
        var map;
        var pedido = {
              num: "Pedido <%=(Integer)session.getAttribute("pedido")%>",
              lng: -99.24601,
              lat: 19.29414
        }
        var marker;
	  
        function initMap() {
            map = new google.maps.Map(document.getElementById('map'), {
              center: {lng: -99.24601, lat: 19.29414},
              zoom: 15
            });

            marker = new google.maps.Marker({
                    position: {lng: pedido.lng, lat: pedido.lat},
                    map: map,
                    title: pedido.num
              });
              getPosition();
        }
        
        function change(lng1, lat1) {
            //var latlng = new google.maps.LatLng(lat, lng);
            marker.setMap(null);
            marker = new google.maps.Marker({
                    position: {lng: lng1, lat: lat1}});
            marker.setMap(map);
        }
        
        function getPosition() {
            $.ajax({
                type: 'POST',
                url: 'getCoorPed',
                statusCode: {
                    404: function() {
                            alert('Alerta ');
                    },
                    500: function(){
                            alert('Error oooohh');
                    }
                },
                success: function(datos) {
                    datos = datos.split(',');
                    //alert(datos);
                    if(datos.length == 1) {
                        alert('pedido entregado');
                    } else {
                        change(parseFloat(datos[0]), parseFloat(datos[1]))
                        setTimeout(function(){getPosition();}, 10000);
                    }
                },
                complete : function() {
                    console.log(name);
                }
            });
        }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDtfMLfHlYviUW1bWaB9HUfgO9OB90VM1Y&callback=initMap"
    async defer></script>
<%@include file='footer.jsp'%>
</body>
</html>
