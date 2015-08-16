angular.module('decorpot').controller('LoginCtrl', function($scope, $auth, $http, User) {
    
    $scope.authenticate = function(provider) {
      $auth.authenticate(provider)
        .then(function(response) {
        	console.log({
            content: 'You have successfully logged in',
            animation: 'fadeZoomFadeDown',
            type: 'material',
            duration: 3
          }, response, provider);
        	
        	if(provider == 'google'){
            	$http.get('https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token=' + response.data.access_token).success(function(response){
            		User.setUser(response.data);
            		console.log('userInfo => `', response, provider);
            	});        		
        	}else{
            	$http.get('https://graph.facebook.com/v2.3/me', {
            		params: {
            			access_token: response.data.access_token,
            			expires_in: response.data.expires_in,
            			token_type: response.data.token_type,
            			field: 'id,email,name'
            		}
            	}).success(function(response){
            		console.log(response, provider);
            	});        		
        	}      	
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