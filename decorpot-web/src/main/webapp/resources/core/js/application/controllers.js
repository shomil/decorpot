/**
 * @author: vaseem.mohammed
 * @date  : 12-07-2015
 */
var decorpotCtrls = angular.module('decorpot');

decorpotCtrls.controller('DecorpotCtrl', ['$scope', '$routeParams', function($scope, $routeParams){
	
}]);

<<<<<<< HEAD
decorpotCtrls.controller('ImageListController', ['$scope', '$routeParams', 'interiors', function($scope, $routeParams, interiors){
=======
decorpotCtrls.controller('ImageListController', ['$scope', '$routeParams', '$http', function($scope, $routeParams, $http, $q){
>>>>>>> branch 'master' of https://github.com/shomil/decorpot.git
	
	$scope.imageList = {};
<<<<<<< HEAD
	/*var responsePromise = $http.get("/test");
=======
	var responsePromise = $http.get("imageListSpace/living?from=300000&to=200000&page=1");
>>>>>>> branch 'master' of https://github.com/shomil/decorpot.git
	responsePromise.success(function(data, status, headers, config) {
        $scope.imageList = data;
        console.log(data);
    });
    responsePromise.error(function(data, status, headers, config) {
        alert("AJAX failed!");
    });*/
    
    interiors.getImageList(function(data, status, headers, config){
    	$scope.imageList = data;
    });
}]);
