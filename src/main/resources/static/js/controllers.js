'use strict';

var controllers = angular.module('controllers', []);

controllers.controller('SeriesCtrl', ['$scope', 'Series', function($scope, Series) {
  var seriesList = Series.query(function(data) {
	  console.log(data.toJSON());
	  $scope.seriesList = data;  
  }, function(error) {
	  console.log(error.data.error);
  });
   
}]);