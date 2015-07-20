/**
 * @author: vaseem.mohammed
 * @date  : 12-07-2015
 */
var decorpotCtrls = angular.module('decorpot');

decorpotCtrls.controller('DecorpotCtrl', ['$scope', '$routeParams', function($scope, $routeParams){
	
}]);

decorpotCtrls.controller('ImageListController', ['$scope', '$routeParams', '$http', function($scope, $routeParams, $http, $q){
	
	$scope.imageList = {};
	var responsePromise = $http.get("imageListSpace/living?from=300000&to=200000&page=1");
	responsePromise.success(function(data, status, headers, config) {
        $scope.imageList = data;
        console.log(data);
    });
    responsePromise.error(function(data, status, headers, config) {
        alert("AJAX failed!");
    });
}]);