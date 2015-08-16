var services = angular.module('decorpot');

services.service('interiors', function($http){
	
	return{
		getImages : function(imagePath,params,from,to,page){
			var url = "";
			console.log('services:interiors');
			url = imagePath+"/"+params+"?from="+from+"&to="+to+"&page="+page;
			return $http.get(url);
		}
	};
	
});


services.service('imageView', function($http){
	
	return{
		getColors : function(groupid){
			var url = "";
			url = "color/"+groupid;
			return $http.get(url);
		},
		getViewsByColors : function(groupid, color){
			var url = "";
			url = "image/group/" +groupid+ "/color/" + color;
			return $http.get(url);
		}
	};
	
});

services.service('cart', function($http){
	var counter =0 ;
	sessionStorage.setItem('cartCounter', counter);
	return {
		checkout : function(){
			
		},
		
		addToCart : function(gruopid){
			
			counter++;
			return counter;
		},
		
		getCartCounter : function(){
			return counter;
		}
		
	};
});