angular.module('decorpot').controller('LoginCtrl', function($scope, $auth, $http) {
    
    $scope.authenticate = function(provider) {
      $auth.authenticate(provider)
        .then(function(response) {
        	console.log({
            content: 'You have successfully logged in',
            animation: 'fadeZoomFadeDown',
            type: 'material',
            duration: 3
          }, response);
        	
        	$http.get('https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token='+ response.data.access_token).success(function(response){
        		console.log('userInfo => `', response, provider);
        	});
        	
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