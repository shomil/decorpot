angular.module('decorpot').controller('LoginCtrl', ['$scope', '$auth', '$http', 'User','cart', '$rootScope', function($scope, $auth, $http, User, cart, $rootScope) {
    
    $scope.authenticate = function(provider) {
      $auth.authenticate(provider)
        .then(function(response) {
        	User.setUser(response.data.user);
        	console.log({
            content: 'You have successfully logged in',
            animation: 'fadeZoomFadeDown',
            type: 'material',
            duration: 3
          }, response, provider);
        	console.log(User.getUser());
        	$('.modal_close').trigger('click');//temporary need to change
        	$rootScope.$broadcast('loggedIn');
        })
        .catch(function(response) {
        	console.log({
            content: response,
            animation: 'fadeZoomFadeDown',
            type: 'material',
            duration: 3
          });
        });
    };
   
    
  }]);