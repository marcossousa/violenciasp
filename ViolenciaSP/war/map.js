var infowindow;
(function () {

  google.maps.Map.prototype.markers = new Array();
    
  google.maps.Map.prototype.addMarker = function(marker) {
    this.markers[this.markers.length] = marker;
  };
    
  google.maps.Map.prototype.getMarkers = function() {
    return this.markers
  };
})();
  
  function initialize(endereco, lat_endereco, lon_endereco, delegacia, lat_delegacia, lon_delegacia) {
	var diferenceLong = (parseFloat(lon_endereco) - parseFloat(lon_delegacia))/2;
	var diferenceLat = (parseFloat(lat_endereco) - parseFloat(lat_delegacia))/2;
	
    var latlng = new google.maps.LatLng(parseFloat(lat_delegacia) + diferenceLong, parseFloat(lon_delegacia) + diferenceLat);
    var myOptions = {
      zoom: 13,
      center: latlng,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
    
    var a = new Array();
    var t =  new Object();
    t.name = "Seu endereco: " + endereco
    t.lat =  lat_endereco
    t.lng =  lon_endereco
    a[0] = t;
  
    var t =  new Object();
    t.name = "Delegacia Proxima: " + delegacia
    t.lat =  lat_delegacia
    t.lng =  lon_delegacia
    a[1] = t;

    alert("Delegacia: " + a[1].lat + " / " + a[1].lng);
   
    for (var i = 0; i < a.length; i++) {
    	alert("colocando o ponto no mapa: " + a.length);
        var latlng = new google.maps.LatLng(a[i].lat, a[i].lng);
        alert(latlng);
        map.addMarker(createMarker(a[i].name,latlng));
        alert("ok");
     }   
  }
  
  function createMarker(name, latlng) {
    var marker = new google.maps.Marker({position: latlng, map: map});
    google.maps.event.addListener(marker, "click", function() {
      if (infowindow) infowindow.close();
      infowindow = new google.maps.InfoWindow({content: name});
      infowindow.open(map, marker);
    });
    return marker;
  }