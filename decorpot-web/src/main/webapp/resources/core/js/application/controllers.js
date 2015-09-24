/**
 * @author: vaseem.mohammed
 * @date : 12-07-2015
 */
var decorpotCtrls = angular.module('decorpot');

decorpotCtrls.controller('DecorpotCtrl', [ '$scope', '$stateParams', 'cart',
		'$auth', 'User', '$rootScope',
		function($scope, $stateParams, cart, $auth, User, $rootScope) {
			$scope.getCartCounter = cart.getCartCounter;

			$scope.isAuthenticated = $auth.isAuthenticated();

			$scope.name = "Decorpot";

			$scope.$watch(function() {
				return $auth.isAuthenticated();
			}, function(newValue, oldValue) {
				$scope.isAuthenticated = newValue;
				$scope.name = User.getUser().name || "Guest";
				console.log('User.getUser() => ', User.getUser());
			});
			$rootScope.$on('loggedIn', function() {
				//do stuff
			})

		} ]);

decorpotCtrls.controller('ImageListController', [
		'$scope',
		'$stateParams',
		'interiors',
		'$location',
		'cart',
		function($scope, $stateParams, interiors, $location, cart) {
			console.log('before location');
			console.log($location);
			$scope.from = 10000;
			$scope.to = 10000000;
			$scope.page = 1;
			$scope.imagePath = $location.$$path.split("/")[1];
			console.log($scope.imagePath);
			interiors.getImages($scope.imagePath, $stateParams.param,
					$scope.from, $scope.to, $scope.page).success(
					function(data) {
						console.log(data);
						$scope.imageList = data;
					});

		} ]);

decorpotCtrls.controller('ImageViewController', [
		'$scope',
		'$stateParams',
		'imageView',
		'$auth',
		'cart',
		function($scope, $stateParams, imageView, $auth, cart) {
			$scope.selection = {};
			$scope.groupId = $stateParams.groupid;
			imageView.getColors($stateParams.groupid).success(function(data) {

				$scope.colors = data;

			});

			if (typeof $scope.color == 'undefined')
				$scope.color = {};
			$scope.color.thumbnails = [];
			$scope.getViewsByColors = function(color) {
				imageView.getViewsByColors($stateParams.groupid, color.color)
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

decorpotCtrls.controller('CartController', [ '$scope', 'cart',
		function($scope, cart) {

		} ]);

decorpotCtrls.controller('ProjectsController', [ '$scope', 'cart', 'projects', '$rootScope',
		function($scope, cart, projects, $rootScope) {
			projects.getAllProjects().success(function(data) {
				for (var i = 0; i < data.length; i++) {
					data[i].APARTMENT = data[i].APARTMENT.replace(/\s+/g, '-');
				}
				$scope.projects = data;
			});
			$rootScope.$on('$stateChangeStart', function(event, toState,
					toParams, fromState, fromParams) {
				//event.preventDefault(); 
				// transitionTo() promise will be rejected with 
				// a 'transition prevented' error
				console.log(event, toState, toParams, fromParams, fromState);
			});
		} ]);

decorpotCtrls.controller('ProjectController', [
		'$scope',
		'cart',
		'projects',
		'$stateParams',
		'$rootScope',
		'$document',
		function($scope, cart, projects, $stateParams, $rootScope, $document) {
			var project = $stateParams.param;
			var images = [];
			var self = this;
			projects.getImagesByAppartment(project).success(function(data) {
				
				$scope.alphas = data;
				console.log($scope.images);
				for(var i=0; i< data.length; i++){
					var image = {};
					image.thumb = data[i].SMALL_PATH;
					image.img = data[i].HD_PATH;
					image.description = "";
					images.push(image);
				}
				$scope.images = images;
				console.log("images are", $scope.images);
			});

			$rootScope.$on('$stateChangeStart', function(event, toState,
					toParams, fromState, fromParams) {
				//event.preventDefault(); 
				// transitionTo() promise will be rejected with 
				// a 'transition prevented' error
				console.log(event, toState, toParams, fromParams, fromState);
			});
			/*$('#gallery').jGallery({
				backgroundColor : 'black',
				textColor : 'white'
			});*/

		} ]);

decorpotCtrls.controller('ContactsController', [ '$scope', 'cart',
		function($scope, cart) {
			$scope.phoneNumberPattern = (function() {
				var regexp = /^\(?(\d{3})\)?[ .-]?(\d{3})[ .-]?(\d{4})$/;
				return {
					test : function(value) {
						if ($scope.requireTel === false) {
							return true;
						}
						return regexp.test(value);
					}
				};
			})();
		} ]);

decorpotCtrls.controller('AboutController', [ '$scope', 'cart',
		function($scope, cart) {

		} ]);
