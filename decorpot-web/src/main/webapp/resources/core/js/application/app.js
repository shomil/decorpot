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
	}).when('/imageView/:groupid', {
		templateUrl: 'resources/partials/imageView.html',
		controller: 'ImageViewController'
	}).when('/imageListTheme/:param',{
		templateUrl: 'resources/partials/imageList.html',
		controller: 'ImageListController'
	}).when('/checkout',{
		templateUrl : 'resources/partials/cart.html',
		controller : 'CartController'
	}).when('/projects',{
		templateUrl : 'resources/partials/projects.html',
		controller : 'ProjectsController'
	}).when('/contacts',{
		templateUrl : 'resources/partials/contacts.html',
		controller : 'ContactsController'
	})
	.otherwise({
		redirectTo: '/'
	});
	
	$authProvider.google({
		clientId: '333854512360-bsm18ai5gc6keg3teh8u6vsj9v1aobbo.apps.googleusercontent.com'
	});
	
	$authProvider.facebook({
		clientId: '1644581525812851'
	});
	
	$authProvider.facebook({
	  url: '/decorpot/auth/facebook',
	  authorizationEndpoint: 'https://www.facebook.com/v2.3/dialog/oauth',
	  redirectUri: window.location.protocol + '//' + window.location.host + '/decorpot',
	  scope: 'email',
	  scopeDelimiter: ',',
	  requiredUrlParams: ['display', 'scope'],
	  display: 'popup',
	  type: '2.0',
	  popupOptions: { width: 481, height: 269 }
	});

	// Google
	$authProvider.google({
	  url: '/decorpot/auth/google',
	  authorizationEndpoint: 'https://accounts.google.com/o/oauth2/auth',
	  redirectUri: window.location.protocol + '//' + window.location.host + '/decorpot',
	  scope: ['profile', 'email'],
	  scopePrefix: 'openid',
	  scopeDelimiter: ' ',
	  requiredUrlParams: ['scope'],
	  optionalUrlParams: ['display'],
	  display: 'popup',
	  type: '2.0',
	  popupOptions: { width: 580, height: 400 }
	});
	
}]);
