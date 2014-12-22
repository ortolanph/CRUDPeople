angular.module('testApp', []);

defaultUrl = "http://localhost:8080/crudpeople/testservice/";

testApp.controller('TestController', ['$scope', '$http',
    function($scope, $http) {
        
        $scope.callTest = function() {
            $http.get(defaultUrl + 'test')
                .succes(function(data, status) {
                    $scope.testReturn = {'message' : data, 'status': status };
                })
                .error(function(data, status) {
                    $scope.testReturn = {'message' : data, 'status': status };
                });
        }
        
        $scope.echo = function() {
            
        }
        
        $scope.api = function() {
            
        }
        
}]);