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
			console.log('services:imageView:getColors');
			url = "color/" + groupid;
			return $http.get(url);
		},
		getViewsByColors : function(groupid, color) {
			console.log('services:imageView:getViewsByColors');
			var url = "";
			url = "image/group/" + groupid + "/color/" + color;
			return $http.get(url);
		},
		getViewsByGroupId : function(groupid) {
			console.log('services:imageView:getViewsByColors');
			var url = "";
			url = "groups/" + groupid + "/views";
			return $http.get(url);
		},
		getGroupDetails : function(groupId){
			return $http({
				method : "get",
				url : "groups/" + groupId + "/details"
			});
		},
		getGroupPrice : function(groupId){
			return $http({
				method : "get",
				url : "groups/" + groupId + "/price"
			});
		}
	};

});

services.service('cart', function($http, User, $auth) {
	
	var cartImages = (localStorage.getItem('cartImages') === null) ? []
			: JSON.parse(localStorage.getItem('cartImages'));
	localStorage.setItem('cartImages', JSON.stringify(cartImages));
	return {
		checkout : function() {
			if (!$auth.isAuthenticated()) {
				$('#modal_trigger').click();
			}
			return $http({
				method : "get",
				url : "cart/" + User.getUser().email
			});

		},

		addToCart : function(CartImagesDetails) {
			cartImages = JSON.parse(localStorage.getItem('cartImages'));
			if (cartImages.indexOf(CartImagesDetails.groupId) < 0) {
				cartImages.push(CartImagesDetails);
				localStorage
						.setItem('cartImages', JSON.stringify(cartImages));
				if ($auth.isAuthenticated()) {
					CartImagesDetails.email = User.getUser().email;
					CartImagesDetails.name = User.getUser().given_name;
					$http({
						method : "post",
						url : "cart",
						data : CartImagesDetails
					});
				}
			}

			return cartImages.length;
		},

		getCartCounter : function() {
			return cartImages.length;
		},
		
		removeFromCart : function(groupId){
			cartImages = JSON.parse(localStorage.getItem('cartImages'));
			var imageIndex = cartImages.indexOf(groupid);
			if (imageIndex > -1) {
				cartImages = cartImages.splice(imageIndex, 1);
				localStorage.setItem('cartImages', JSON.stringify(cartImages));
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
		localStorage
		.setItem('userObj', JSON.stringify(userObj));
	}
	this.getUser = function() {
		return JSON.parse(localStorage.getItem('userObj'));;
	}
});

services.service('apartments', function($http){
	return{
		getAllApartments : function(apartmentName){
			return $http({
				method : "get",
				url : "apartments/name/" + apartmentName
			});
		},
		getApartment : function(aprtId){
			return $http({
				method : "get",
				url : "apartments/" + aprtId
			});
		}
	
	};
});

services.service('ongoingProjects', function($http){
	return{
		getAllOngoingProjects : function(){
			return $http({
				method : "get",
				url : "projects/ongoing"
			});
		},
		
		getOngoingProject : function(aprtId){
			return $http({
				method : "get",
				url : "projects/ongoing/" + apartId
			});
		}
	};
});

services.service('projects', function($http){
	return{
		getAllOngoingProjects : function(){
			return $http({
				method : "get",
				url : "projects/ongoing"
			});
		},
		
		getOngoingProject : function(project){
			return $http({
				method : "get",
				url : "projects/ongoing/" + project.replace(/\s+/g, '-')
			});
		},
		getAllProjects : function(){
			return $http({
				method : "get",
				url : "projects/completed"
			});
		},
		getImagesByAppartment : function(project){
			return $http({
				method : "get",
				url : "projects/completed/" + project.replace(/\s+/g, '-')
			});
		}
	};
});
