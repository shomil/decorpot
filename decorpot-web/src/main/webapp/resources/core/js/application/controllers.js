/**
 * @author: vaseem.mohammed
 * @date : 12-07-2015
 */
var decorpotCtrls = angular.module('decorpot');

decorpotCtrls.controller('DecorpotCtrl', [ '$scope', '$routeParams', function($scope, $routeParams) {

		} ]);

decorpotCtrls.controller('ImageListController', [ '$scope', '$routeParams', 'interiors', function($scope, $routeParams, interiors) {
			$scope.imageList = [
{
	"groupid": 2,
	"spaces": "living",
	"themes": "comtemprory",
	"description_short": "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
	"color": "black",
	"imageid": 3,
	"viewid": 2,
	"path_small": "https://s3-ap-southeast-1.amazonaws.com/decorpot/low_image/home-decor4.jpg",
	"path_hd": "home-decor4.jpg",
	"price": 200000
	},
	{
	"groupid": 3,
	"spaces": "living",
	"themes": "comtemprory",
	"description_short": "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
	"color": "grey",
	"imageid": 6,
	"viewid": 1,
	"path_small": "https://s3-ap-southeast-1.amazonaws.com/decorpot/low_image/img2.jpg",
	"path_hd": "img2.jpg",
	"price": 200000
	},
	{
	"groupid": 3,
	"spaces": "living",
	"themes": "comtemprory",
	"description_short": "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
	"color": "grey",
	"imageid": 6,
	"viewid": 2,
	"path_small": "https://s3-ap-southeast-1.amazonaws.com/decorpot/low_image/img3.jpg",
	"path_hd": "img3.jpg",
	"price": 200000
	},
	{
	"groupid": 2,
	"spaces": "living",
	"themes": "comtemprory",
	"description_short": "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
	"color": "red",
	"imageid": 4,
	"viewid": 1,
	"path_small": "https://s3-ap-southeast-1.amazonaws.com/decorpot/low_image/home-decor5.jpg",
	"path_hd": "home-decor5.jpg",
	"price": 200000
	},
	{
	"groupid": 2,
	"spaces": "living",
	"themes": "comtemprory",
	"description_short": "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
	"color": "red",
	"imageid": 4,
	"viewid": 2,
	"path_small": "https://s3-ap-southeast-1.amazonaws.com/decorpot/low_image/home-decor6.jpg",
	"path_hd": "home-decor6.jpg",
	"price": 200000
	},
	{
	"groupid": 3,
	"spaces": "living",
	"themes": "comtemprory",
	"description_short": "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
	"color": "red",
	"imageid": 5,
	"viewid": 1,
	"path_small": "https://s3-ap-southeast-1.amazonaws.com/decorpot/low_image/home1.jpg",
	"path_hd": "home1.jpg",
	"price": 200000
	},
	{
	"groupid": 3,
	"spaces": "living",
	"themes": "comtemprory",
	"description_short": "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
	"color": "red",
	"imageid": 5,
	"viewid": 2,
	"path_small": "https://s3-ap-southeast-1.amazonaws.com/decorpot/low_image/img1.jpg",
	"path_hd": "img1.jpg",
	"price": 200000
	}
	];

			//interiors.getImageList().success(function(data) {
			//	$scope.imageList = data;
			//});
		} ]);
