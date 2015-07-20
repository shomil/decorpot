/**
 * @author: vaseem.mohammed
 * @date  : 12-07-2015
 */
var decorpot = angular.module('decorpot', ['ngRoute']);

//
decorpot.config(['$routeProvider', '$provide', function($routeProvider, $provide){
	
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
}]);