/**
 * create a service 'CPRWebApp.services' register a service within 'ergastAPIservice' and pass $http to the service
 * (our service depends on http)
 */

angular.module('CPRWebApp.services', []).
    factory('ergastAPIservice', function($http) {

      var ergastAPI = {};

      ergastAPI.getDrivers = function() {
        return $http({
          method: 'JSONP',
          url: 'http://ergast.com/api/f1/2013/driverStandings.json?callback=JSON_CALLBACK'
        });
      }

      ergastAPI.getDriverDetails = function(id) {
        return $http({
          method: 'JSONP',
          url: 'http://ergast.com/api/f1/2013/drivers/'+ id +'/driverStandings.json?callback=JSON_CALLBACK'
        });
      }

      ergastAPI.getDriverRaces = function(id) {
        return $http.get({
          method: 'JSONP',
          url: 'http://ergast.com/api/f1/2013/drivers/'+ id +'/results.json?callback=JSON_CALLBACK'
        });
      }
      return ergastAPI;
    }).

    factory('jSONTestAPIservice', function($http) {

      var jSONTestAPI = {};

      jSONTestAPI.getIPAddress = function() {
        return $http({
          method: 'JSONP',
          url: 'http://ip.jsontest.com?callback=JSON_CALLBACK'
        });
      }

      jSONTestAPI.getHeaders = function() {
        return $http({
          method: 'JSONP',
          url: 'http://headers.jsontest.com?callback=JSON_CALLBACK'
        });
      }

      jSONTestAPI.getDateAndTime = function() {
        return $http({
          method: 'JSONP',
          url: 'http://date.jsontest.com?callback=JSON_CALLBACK'
        });
      }
      return jSONTestAPI;
    }).
factory('irishRailAPIservice', function($http) {

  var irishRailAPI = {};

      irishRailAPI.getCurrentTrains= function() {
    return $http({
      method: 'JSONP',
      url: '/currentTrains.do?callback=JSON_CALLBACK'
    });



  }


  return irishRailAPI;
});



