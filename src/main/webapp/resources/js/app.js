/**
 * include 'CPRWebApp' module in the app
 */
var cprWebApp = angular.module('CPRWebApp', [
  'ngRoute',
  'CPRWebApp.filters',
  'CPRWebApp.services',
  'CPRWebApp.directives',
  'CPRWebApp.controllers'

]);


cprWebApp.config(['$routeProvider', function($routeProvider) {
      $routeProvider.
          when("/drivers", {templateUrl: "jsp/drivers.html", controller: "driversController"}).
          when("/drivers/:id", {templateUrl: "jsp/driver.html", controller: "driverController"}).
          otherwise({redirectTo: '/drivers'});
    }]);

cprWebApp.config(['$routeProvider', function($routeProvider) {
      $routeProvider.
          when("/currentTrains", {templateUrl: "jsp/currentTrains.html", controller: "trainsController"});
    }]);

cprWebApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
      when("/ipAddress", {templateUrl: "jsp/ipAddress.html", controller: "ipAddressController"});
}]);

cprWebApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
      when("/headers", {templateUrl: "jsp/headers.html", controller: "headersController"});
}]);

cprWebApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
      when("/dateAndTime", {templateUrl: "jsp/dateAndTime.html", controller: "dateAndTimeController"});
}]);

cprWebApp.config(['$httpProvider', function($httpProvider) {
  $httpProvider.defaults.useXDomain = true;
  delete $httpProvider.defaults.headers.common['X-Requested-With'];
}
]);