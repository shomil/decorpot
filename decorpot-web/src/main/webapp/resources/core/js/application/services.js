var services = angular.module('decorpot');

services.service('interiors', function($http){
	
	return{
		getImages : function(){
			return $http.get("imageListSpace/living?from=300000&to=200000&page=1");
		}
	}
	
});




/*this.getImages = function(callback){
	var testPromise = $http.get("imageListSpace/living?from=300000&to=200000&page=1");
	testPromise.success(callback());
	testPromise.error(function(data, status, headers, config) {
        alert("AJAX failed!");
    });
}*/