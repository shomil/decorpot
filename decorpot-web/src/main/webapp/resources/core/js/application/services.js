var services = angular.module('decorpot');

services.service('interiors', function($http){
	
	return{
		getImages : function(params,from,to,page){
			var url = "";
			url = "imageListSpace/"+params+"?from="+from+"&to="+to+"&page="+page;
			return $http.get(url);
		}
	};
	
});