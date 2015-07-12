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
	
	$routeProvider.when('/home', {
		templateUrl: 'resources/partials/home.html',
		controller: 'DecorpotCtrl'
	}).otherwise({
		redirectTo: '/home'
	});
}]);