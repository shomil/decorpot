angular.module('decorpot').controller('LoginCtrl', function($scope, $auth, $http, User) {
    
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
   
    
  });