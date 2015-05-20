'use strict';

var controllers = angular.module('controllers', []);

controllers.controller('SeriesCtrl', [ '$scope', 'Series', function($scope, Series) {

	$scope.episodes = function(seriesId) {
		location.href = "#episodes/" + seriesId; 
	};
	
	var seriesList = Series.query(function(data) {
		$scope.seriesList = data;
	}, function(error) {
		console.log(error.data.error);
	});

}]);

controllers.controller('EpisodesCtrl', [ '$scope', '$routeParams', function($scope, $routeParams) {
	console.log($routeParams.seriesId);
}]);