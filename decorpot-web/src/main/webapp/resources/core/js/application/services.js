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

services.service('cart', function($http, $auth){
	if($auth.isAuthenticated()){
		//get all images from db check through sessionStorage if any missing add it. and post all new.
	}
	var cartImages = sessionStorage.getItem('cartImages') === null ? [] : sessionStorage.getItem('cartImages');
	sessionStorage.setItem('cartImages', cartImages);
	return {
		checkout : function(){
			if(!$auth.isAuthenticated()){
				//ask to login
			}
			
		},
		
		addToCart : function(gruopid){
			cartImages = sessionStorage.getItem('cartImages');
			if(cartImages.indexOf(gruopid) < 0){
				cartImages.push(groupid);
				sessionStorage.setItem('cartImages', cartImages);
				//post
			}
			
			return cartImages.length;
		},
		
		getCartCounter : function(){
			return cartImages.length;
		}
		
	};
});


services.service('User', function(){
	this.User = {};
	this.setUser = function(obj){
		this.User = obj;
	}
	this.getUser = function(){
		return this.User;
	}
});