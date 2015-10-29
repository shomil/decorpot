var decortFilters = angular.module('decorpot');

decortFilters.filter('underscoreless', function () {
	  return function (input) {
	      return input.replace(/_/g, ' ');
	  };
	});