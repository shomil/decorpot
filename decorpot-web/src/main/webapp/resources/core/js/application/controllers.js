/**
 * @author: vaseem.mohammed
 * @date : 12-07-2015
 */
var decorpotCtrls = angular.module('decorpot');

decorpotCtrls.controller('DecorpotCtrl', [ '$scope', '$routeParams', function($scope, $routeParams) {

		} ]);

/*decorpotCtrls.controller('ImageListController', [ '$scope', '$routeParams', 'interiors', function($scope, $routeParams, interiors) {
			

			interiors.getImages($routeParams.params).success(function(data) {
				$scope.imageList = data;
			});
		} ]);*/

decorpotCtrls.controller('ImageListController', [ '$scope', '$routeParams', 'interiors', function($scope, $routeParams, interiors ) {

	
	interiors.getImages($routeParams.param).success(function(data) {
		$scope.imageList = data;
	});
	
} ]);