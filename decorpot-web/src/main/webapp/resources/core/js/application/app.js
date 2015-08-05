/**
 * @author: vaseem.mohammed
 * @date  : 12-07-2015
 */
var decorpot = angular.module('decorpot', ['ngRoute', 'satellizer']);

//
decorpot.config(['$routeProvider', '$provide', '$authProvider', function($routeProvider, $provide, $authProvider){
	
	$provide.decorator('ngViewDirective', function($delegate) {
        var directive = $delegate[0];
        directive.replace = true;

        return $delegate;
    });
	
	$routeProvider.when('/', {
		templateUrl: 'resources/partials/home.html',
		controller: 'DecorpotCtrl'
	}).when('/imageListSpace/:param', {
		templateUrl: 'resources/partials/imageList.html',
		controller: 'ImageListController'
	})
	.otherwise({
		redirectTo: '/'
	});
	
	$authProvider.google({
		clientId: '605704716648-1da3ccngddsc51nb6bacevoom9g3hotq.apps.googleusercontent.com'
	});
	
	$authProvider.facebook({
		clientId: '676572255812456'
	});
	
	
}]);