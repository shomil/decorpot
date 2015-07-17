/**
 * @author: vaseem.mohammed
 * @date  : 12-07-2015
 */
var decorpotCtrls = angular.module('decorpot');

decorpotCtrls.controller('DecorpotCtrl', ['$scope', '$routeParams', function($scope, $routeParams){
	
}]);

decorpotCtrls.controller('ImageListController', ['$scope', '$routeParams', function($scope, $routeParams){
	
	$scope.imageList = {};
	var responsePromise = $http.get("/test");
	responsePromise.success(function(data, status, headers, config) {
        $scope.imageList = data;
        console.log(data);
    });
    responsePromise.error(function(data, status, headers, config) {
        alert("AJAX failed!");
    });
}]);