/**
 * @author: vaseem.mohammed
 * @date : 12-07-2015
 */
var decorpotCtrls = angular.module('decorpot');

decorpotCtrls.controller('DecorpotCtrl', [ '$scope', '$routeParams', 'cart', '$auth', 'User', '$rootScope',
		function($scope, $routeParams, cart, $auth, User, $rootScope) {
			$scope.getCartCounter = cart.getCartCounter;
			
			$scope.isAuthenticated = $auth.isAuthenticated();
			
			$scope.name = "Decorpot";
			
			$scope.$watch(function(){
				return $auth.isAuthenticated();
			}, function(newValue, oldValue){
				$scope.isAuthenticated = newValue;
				$scope.name = User.getUser().name || "Guest";
				console.log('User.getUser() => ', User.getUser());
			});
			$rootScope.$on('loggedIn', function () {
	             //do stuff
	        })
			
		} ]);

decorpotCtrls.controller('ImageListController', [
		'$scope',
		'$routeParams',
		'interiors',
		'$location',
		'cart',
		function($scope, $routeParams, interiors, $location, cart) {
			console.log('before location');
			console.log($location);
			$scope.from = 100000;
			$scope.to = 300000;
			$scope.page = 1;
			$scope.imagePath = $location.$$path.split("/")[1];
			console.log($scope.imagePath);
			interiors.getImages($scope.imagePath, $routeParams.param,
					$scope.from, $scope.to, $scope.page).success(
					function(data) {
						console.log(data);
						$scope.imageList = data;
					});
			

		} ]);

decorpotCtrls.controller('ImageViewController', [
		'$scope',
		'$routeParams',
		'imageView',
		'$auth',
		'cart',
		function($scope, $routeParams, imageView, $auth, cart) {
			$scope.selection = {};
			$scope.groupId = $routeParams.groupid;
			imageView.getColors($routeParams.groupid).success(function(data) {

				$scope.colors = data;

			});

			if (typeof $scope.color == 'undefined')
				$scope.color = {};
			$scope.color.thumbnails = [];
			$scope.getViewsByColors = function(color) {
				imageView.getViewsByColors($routeParams.groupid, color.color)
						.success(function(data) {
							$scope.color.thumbnails = data;
							console.log($scope);
						});
			};

			$scope.getHdImage = function(imageSlId) {
				for (var i = 0; i < $scope.color.thumbnails.length; i++) {
					if ($scope.color.thumbnails[i]['imageSlId'] == imageSlId)
						$scope.path_hd = $scope.color.thumbnails[i]['path_hd'];
				}
			};

			

			$scope.addToCart = function(groupid) {
				var CartImagesDetails = {};
				CartImagesDetails.groupId = $scope.groupId;
				CartImagesDetails.buyType = $scope.content;
				CartImagesDetails.custText = $scope.custText;
				CartImagesDetails.isCustomized = $scope.customization;
				return cart.addToCart(CartImagesDetails);

			};
		} ]);

decorpotCtrls.controller('CartController', [ '$scope', 'cart', function($scope, cart){
	
}])
