/**
 * @author: vaseem.mohammed
 * @date : 12-07-2015
 */
var decorpotCtrls = angular.module('decorpot');

decorpotCtrls.controller('DecorpotCtrl', [ '$scope', '$routeParams', function($scope, $routeParams) {

		} ]);

decorpotCtrls.controller('ImageListController', [ '$scope', '$routeParams', 'interiors', '$location', function($scope, $routeParams, interiors, $location ) {
	console.log($location);
	$scope.from = 100000;
	$scope.to = 300000;
	$scope.page = 1;
	interiors.getImages($routeParams.param, $scope.from, $scope.to, $scope.page).success(function(data) {
		$scope.imageList = data;
	});
	
} ]);

decorpotCtrls.controller('ImageViewController', [ '$scope', '$routeParams',function($scope, $routeParams) {
	
} ]);