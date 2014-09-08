var cprControllers = angular.module('CPRWebApp.controllers', []);

cprControllers.
    controller('driversController', function ($scope, ergastAPIservice) {
      $scope.nameFilter = null;
      $scope.driversList = [];
      $scope.searchFilter = function (driver) {
        var re = new RegExp($scope.nameFilter, 'i');
        return !$scope.nameFilter || re.test(driver.Driver.givenName) || re.test(driver.Driver.familyName);
      };

      ergastAPIservice.getDrivers().success(function (response) {
        //Digging into the response to get the relevant data
        $scope.driversList = response.MRData.StandingsTable.StandingsLists[0].DriverStandings;
      });
    });

/* Driver controller */
cprControllers.controller('driverController', function ($scope, $routeParams, ergastAPIservice) {
  $scope.id = $routeParams.id;
  $scope.races = [];
  $scope.driver = null;

  ergastAPIservice.getDriverDetails($scope.id).success(function (response) {
    $scope.driver = response.MRData.StandingsTable.StandingsLists[0].DriverStandings[0];
  });

  ergastAPIservice.getDriverRaces($scope.id).success(function (response) {
    $scope.races = response.MRData.RaceTable.Races;
  });
});

cprControllers.controller('ipAddressController', function ($scope, $routeParams, jSONTestAPIservice) {
  $scope.ipAddress = null;

  jSONTestAPIservice.getIPAddress().success(function (response) {
    $scope.ipAddress = response;
  });
});

cprControllers.controller('headersController', function ($scope, $routeParams, jSONTestAPIservice) {
  $scope.ipAddress = null;

  jSONTestAPIservice.getHeaders().success(function (response) {
    $scope.headers = response;
  });
});

cprControllers.controller('dateAndTimeController', function ($scope, $routeParams, jSONTestAPIservice) {
  jSONTestAPIservice.getDateAndTime().success(function (response) {
    $scope.dateAndTime = response;
  });
});

cprControllers.controller('trainsController', function($scope, irishRailAPIservice) {
            
  irishRailAPIservice.getCurrentTrains().success(function (response) {
      console.log("response : "  + response);
    $scope.currentTrains = response;
  });
});

/*cprControllers.controller('trainsControllerYQL', function($scope, irishRailAPIservice) {

  irishRailAPIservice.getCurrentTrainsYQL().success(function (response) {



    //Digging into the response to get the relevant data
    $scope.currentTrainsList = response;
  });
});
*/
