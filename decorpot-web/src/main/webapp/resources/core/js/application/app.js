/**
 * @author: vaseem.mohammed
 * @date  : 12-07-2015
 */
var decorpot = angular.module('decorpot', ['ui.router', 'satellizer', 'ngMessages', 'jkuri.gallery','wt.responsive', 'ncy-angular-breadcrumb']);

//
decorpot.config(['$authProvider', '$stateProvider', '$urlRouterProvider','$httpProvider', function( $authProvider, $stateProvider, $urlRouterProvider, $httpProvider){
	

	$httpProvider.interceptors.push('myHttpInterceptor');
    var spinnerFunction = function (data, headersGetter) {
        // todo start the spinner here
        //alert('start spinner');
        $('#mydiv').show();
        return data;
    };
    $httpProvider.defaults.transformRequest.push(spinnerFunction);
    
	$urlRouterProvider.otherwise('/');
	
	$stateProvider
    .state('home', {
        url: '/',
        templateUrl: 'resources/partials/home.html',
		controller: 'DecorpotCtrl'
    }).state('imageList', {
        url: '/imageListSpace/:param',
        templateUrl: 'resources/partials/imageList.html',
		controller: 'ImageListController'
    }).state('imageView', {
        url: '/imageView/:groupid',
        templateUrl: 'resources/partials/imageView.html',
		controller: 'ImageViewController'
    }).state('imageListTheme', {
        url: '/imageListTheme/:param',
        templateUrl : 'resources/partials/cart.html',
		controller : 'CartController'
    }).state('checkout', {
        url: '/checkout',
        templateUrl: 'resources/partials/home.html',
		controller: 'DecorpotCtrl'
    }).state('projects', {
        url: '/projects',
        templateUrl : 'resources/partials/projectsNew.html',
		controller : 'ProjectsController'
    }).state('projects.project', {
        url: '/project/:param',
        templateUrl : 'resources/partials/projectImages.html',
		controller : 'ProjectController as ctrl'
    }).state('contacts', {
        url: '/contacts',
        templateUrl: 'resources/partials/contacts.html',
        controller : 'ContactsController'
    }).state('about', {
        url: '/about',
        templateUrl: 'resources/partials/about.html',
        controller : 'AboutController'
    }).state('apartments', {
        url: '/apartments',
        templateUrl: 'resources/partials/apartments.html',
        controller : 'ApartmentsController'
    }).state('apartments.apartment', {
        url: '/apartment/:aprtId',
        templateUrl: 'resources/partials/apartment.html',
        controller : 'ApartmentController',
        ncyBreadcrumb: {
            label: '{{aprtId}}'
          }
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
