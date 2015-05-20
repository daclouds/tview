'use strict';

var services = angular.module('services', ['ngResource']);

services.factory('Series', ['$resource',
  function($resource){
    return $resource('series', {}, {query: {method:'GET'}, isArray:false});
  }]);