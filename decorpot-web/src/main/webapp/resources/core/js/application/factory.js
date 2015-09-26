var factories = angular.module('decorpot');

factories.factory('myHttpInterceptor', function ($q, $window) {
    
    return {
        // optional method
        'request': function(config) {
          // do something on success
        	$('#mydiv').hide();
          return config;
        },

        // optional method
       'requestError': function(rejection) {
          // do something on error
          if (canRecover(rejection)) {
        	  $('#mydiv').hide();
            return responseOrNewPromise
          }
          $('#mydiv').hide();
          return $q.reject(rejection);
        },



        // optional method
        'response': function(response) {
          // do something on success
        	$('#mydiv').hide();
          return response;
        },

        // optional method
       'responseError': function(rejection) {
          // do something on error
          if (canRecover(rejection)) {
        	  $('#mydiv').hide();
            return responseOrNewPromise
          }
          $('#mydiv').hide();
          return $q.reject(rejection);
        }
      };
});