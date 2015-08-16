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
	if ($auth.isAuthenticated()) {
		//get all images from db check through sessionStorage if any missing add it. and post all new.
	}
	console.log(User.getUser());
	var cartImages = (sessionStorage.getItem('cartImages') === null) ? []
			: JSON.parse(sessionStorage.getItem('cartImages'));
	sessionStorage.setItem('cartImages', JSON.stringify(cartImages));
	return {
		checkout : function() {
			if (!$auth.isAuthenticated()) {
				//ask to login
			}

		},

		addToCart : function(groupid) {
			cartImages = JSON.parse(sessionStorage.getItem('cartImages'));
			if (cartImages.indexOf(groupid) < 0) {
				cartImages.push(groupid);
				sessionStorage
						.setItem('cartImages', JSON.stringify(cartImages));
				//post
				if ($auth.isAuthenticated()) {
					var groupIds = [];
					groupIds.push(groupid)
					$http({
						method : "post",
						url : "addToCart",
						data : {
							email : User.getUser().email,
							name : User.getUser().given_name,
							groupId : groupIds
						}
					});
				}
			}

			return cartImages.length;
		},

		getCartCounter : function() {
			return cartImages.length;
		}

	};
});

services.service('User', function() {
	this.User = {};
	this.setUser = function(obj) {
		this.User = obj;
	}
	this.getUser = function() {
		return this.User;
	}
});