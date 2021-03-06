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
				// do stuff
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

decorpotCtrls
		.controller(
				'ImageViewController',
				[
						'$scope',
						'$stateParams',
						'imageView',
						'$auth',
						'cart',
						'$sce',
						function($scope, $stateParams, imageView, $auth, cart,
								$sce) {
							$scope.selection = {};
							$scope.groupId = $stateParams.groupid;
							$scope.contactUsModalShown = false;
							$scope.toggleContactUsModal = function() {
								$scope.contactUsModalShown = !$scope.contactUsModalShown;
							};
							/*
							 * imageView.getColors($stateParams.groupid).success(function(data) {
							 * 
							 * $scope.colors = data;
							 * 
							 * });
							 */

							imageView.getViewsByGroupId($stateParams.groupid)
									.success(function(data) {
										$scope.thumbnails = data;
										$scope.toggleObject = {
											item : 0
										};
										console.log($scope);
									});

							imageView
									.getGroupDetails($stateParams.groupid)
									.success(
											function(data) {
												$scope.title = data.imageTitle;
												$scope.basePrice = data.basePrice;
												$scope.description = $sce
														.trustAsHtml(data.imageDescription);
												$scope.basePriceDescription = data.basePriceDescription;
											});
							imageView
									.getGroupPrice($stateParams.groupid)
									.success(function(data) {
										$scope.groupPrice = data;
									})
									.success(
											function() {
												$scope.totalImagePrice = 0;
												for (var i = 0; i < $scope.groupPrice.length; i++) {
													$scope.totalImagePrice = $scope.totalImagePrice
															+ $scope.groupPrice[i]['price'];
												}
											});
							$scope.getHdImage = function(IMAGE_ID) {
								for (var i = 0; i < $scope.thumbnails.length; i++) {
									if ($scope.thumbnails[i]['IMAGE_ID'] == IMAGE_ID)
										$scope.IMAGE_PATH_HD = $scope.thumbnails[i]['IMAGE_PATH_MEDIUM'];
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

decorpotCtrls.controller('ProjectsController', [
		'$scope',
		'cart',
		'projects',
		'$rootScope',
		function($scope, cart, projects, $rootScope) {
			projects.getAllProjects().success(function(data) {
				for (var i = 0; i < data.length; i++) {
					data[i].APARTMENT = data[i].APARTMENT.replace(/\s+/g, '-');
				}
				$scope.projects = data;
			});
			$rootScope.$on('$stateChangeStart', function(event, toState,
					toParams, fromState, fromParams) {
				// event.preventDefault();
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
				for (var i = 0; i < data.length; i++) {
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
				// event.preventDefault();
				// transitionTo() promise will be rejected with
				// a 'transition prevented' error
				console.log(event, toState, toParams, fromParams, fromState);
			});
			/*
			 * $('#gallery').jGallery({ backgroundColor : 'black', textColor :
			 * 'white' });
			 */

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

decorpotCtrls.controller('ApartmentsController', [
		'$scope',
		'cart',
		'$stateParams',
		'apartments',
		function($scope, cart, $stateParams, apartments) {
			apartments.getAllApartments($stateParams.apartmentName).success(
					function(data) {

						$scope.apartments = data;
					})
		} ]);

decorpotCtrls
		.controller(
				'ApartmentController',
				[
						'$scope',
						'cart',
						'$stateParams',
						'apartments',
						'imageView',
						'$sce',
						function($scope, cart, $stateParams, apartments,
								imageView, $sce) {
							$scope.aprtId = $stateParams.aprtId;
							apartments
									.getApartment($stateParams.aprtId)
									.success(
											function(data) {
												$scope.toggleObject = {
													item : 0
												};
												$scope.groups = data.groups;
												$scope.apartmentName = data.apartmentName;
												$scope.bhk = data.bhk;
												$scope.totalPrice = data.totalPrice;

												console
														.log($scope.toggleObject);

											});
							$scope.getImageGroupData = function(group) {
								$scope.PATH_HD = "";
								$scope.spaceName = group.imageSpace;
								imageView
										.getViewsByGroupId(group.groupId)
										.success(
												function(data) {
													$scope.views = data;

													$scope.toggleObjectSpace = {
														item : 0
													};
													$scope.basePrice = $scope.groups[$scope.toggleObject.item].basePrice;
													$scope.description = $sce
															.trustAsHtml($scope.groups[$scope.toggleObject.item].imageDescription);
													$scope.aprtImageTitle = $scope.groups[$scope.toggleObject.item].imageTitle;
													$scope.aprtBasePriceDescription = $scope.groups[$scope.toggleObject.item].basePriceDescription;

												});
								imageView
										.getGroupPrice(group.groupId)
										.success(function(data) {
											$scope.groupPrice = data;
										})
										.success(
												function() {
													$scope.totalImagePrice = 0;
													for (var i = 0; i < $scope.groupPrice.length; i++) {
														$scope.totalImagePrice = $scope.totalImagePrice
																+ $scope.groupPrice[i]['price'];
													}
												});
							};
							$scope.setImage = function(PATH_HD) {
								$('#mydiv1').show();
								if ($scope.PATH_HD == PATH_HD) {
									$('#mydiv1').hide();
								}
								$scope.PATH_HD = PATH_HD;
							};
							$scope.getAprtId = function(aprtId) {
								console.log(aprtId);
								apartment = aprtId.replace(/\d+-/, "");
								console.log(apartment);
								return apartment;
							}
						} ]);

decorpotCtrls.controller('OngoingProjectsController', [
		'$scope',
		'cart',
		'ongoingProjects',
		function($scope, ongoing, ongoingProjects) {
			ongoingProjects.getAllOngoingProjects().success(function(data) {
				for (var i = 0; i < data.length; i++) {
					data[i].APARTMENT = data[i].APARTMENT.replace(/\s+/g, '-');
				}
				$scope.projects = data;
			});
		} ]);

decorpotCtrls.controller('OngoingProjectController', [
		'$scope',
		'cart',
		'ongoingProjects',
		'$stateParams',
		'$rootScope',
		function($scope, cart, projects, $stateParams) {
			var project = $stateParams.param;
			var images = [];
			var self = this;
			ongoingProjects.getImagesByAppartment(project).success(function(data) {

				$scope.alphas = data;
				console.log($scope.images);
				for (var i = 0; i < data.length; i++) {
					var image = {};
					image.thumb = data[i].SMALL_PATH;
					image.img = data[i].HD_PATH;
					image.description = "";
					images.push(image);
				}
				$scope.images = images;
			});

		} ]);