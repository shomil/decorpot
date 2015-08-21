var services = angular.module('decorpot');

services.service('interiors', function($http) {

	return {
		getImages : function(imagePath, params, from, to, page) {
			var url = "";
			console.log('services:interiors');
			url = imagePath + "/" + params + "?from=" + from + "&to=" + to
					+ "&page=" + page;
			return $http.get(url);
		}
	};

});

services.service('imageView', function($http) {

	return {
		getColors : function(groupid) {
			var url = "";
			url = "color/" + groupid;
			return $http.get(url);
		},
		getViewsByColors : function(groupid, color) {
			var url = "";
			url = "image/group/" + groupid + "/color/" + color;
			return $http.get(url);
		}
	};

});

services.service('cart', function($http, User, $auth) {
	
	var cartImages = (sessionStorage.getItem('cartImages') === null) ? []
			: JSON.parse(sessionStorage.getItem('cartImages'));
	sessionStorage.setItem('cartImages', JSON.stringify(cartImages));
	return {
		checkout : function() {
			if (!$auth.isAuthenticated()) {
				// ask to login
			}

		},

		addToCart : function(CartImagesDetails) {
			cartImages = JSON.parse(sessionStorage.getItem('cartImages'));
			if (cartImages.indexOf(CartImagesDetails.groupid) < 0) {
				cartImages.push(CartImagesDetails);
				sessionStorage
						.setItem('cartImages', JSON.stringify(cartImages));
				if ($auth.isAuthenticated()) {
					CartImagesDetails.email = User.getUser().email;
					CartImagesDetails.name = User.getUser().given_name;
					$http({
						method : "post",
						url : "cart",
						data : {
							CartImagesDetails
						}
					});
				}
			}

			return cartImages.length;
		},

		getCartCounter : function() {
			return cartImages.length;
		},
		
		removeFromCart : function(groupId){
			cartImages = JSON.parse(sessionStorage.getItem('cartImages'));
			var imageIndex = cartImages.indexOf(CartImagesDetails.groupid);
			iif (imageIndex > -1) {
				cartImages = cartImages.splice(imageIndex, 1);
				sessionStorage.setItem('cartImages', JSON.stringify(cartImages));
			}
			if (!$auth.isAuthenticated()) {
				$http({
					method: "delete",
					url: "cart/" +User.getUser().email+ "/" +groupId
				});
			}
		},
		
		refreshCart : function(){
			
		}

	};
});

services.service('User', function() {
	var userObj = {};
	this.setUser = function(obj) {
		userObj = obj;
	}
	this.getUser = function() {
		return userObj;
	}
});