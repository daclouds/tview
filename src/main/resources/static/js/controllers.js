'use strict';

var controllers = angular.module('controllers', []);

controllers.controller('SeriesCtrl', [ '$scope', 'Series', function($scope, Series) {

	$scope.episodes = function(seriesId) {
		location.href = "#episodes/" + seriesId; 
	};
	
	$scope.myPagingFunction = function() {
	};
	
	Series.query(function(data) {
		$scope.seriesList = data;
	}, function(error) {
		console.log(error.data.error);
	});
	
}]);

controllers.controller('EpisodesCtrl', [ '$scope', '$routeParams', function($scope, $routeParams) {
	console.log($routeParams.seriesId);
}]);