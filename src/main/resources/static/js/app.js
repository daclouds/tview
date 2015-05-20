'use strict';

var app = angular.module('seriesApp', ['ngRoute', 'controllers', 'services', 'ngMaterial', 'ngAnimate']);

app.config(function($routeProvider) {
	$routeProvider
	.when('/', {
		templateUrl: 'page-series.html',
		controller: 'SeriesCtrl'
	})
	.when('/episodes/:seriesId', {
		templateUrl: 'page-episodes.html',
		controller: 'EpisodesCtrl'
	});
});

