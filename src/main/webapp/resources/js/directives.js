'use strict';

/* Directives */


angular.module('CPRWebApp.directives', []).
    directive('appVersion', ['version', function(version) {
      return function(scope, elm, attrs) {
        elm.text(version);
      };
    }]);