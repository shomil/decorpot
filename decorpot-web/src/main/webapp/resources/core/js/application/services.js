var services = angular.module('decorpot');

services.service('interiors', function($http){
	this.getImages = function(callback){
		var testPromise = $http.get("/test");
		testPromise.success(callback);
		testPromise.error(function(data, status, headers, config) {
	        alert("AJAX failed!");
	    });
	}
});