var services = angular.module('decorpot');

services.service('interiors', function($http){
	
	return{
		getImages : function(params){
			return $http.get("imageListSpace/"+params+"?from=300000&to=200000&page=1");
		}
	}
	
});