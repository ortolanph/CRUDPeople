var testApp = angular.module('testApp', []);

defaultUrl = "http://localhost:8080/crudpeople/testservice/";

testApp.controller('TestController', ['$scope', '$http',
    function($scope, $http) {
        
        $scope.callTest = function() {
            console.log('Calling URL: ' + defaultUrl + 'test');
            $http.get(defaultUrl + 'test')
                .succes(function(data, status) {
                    console.log("[OK]");
                    $scope.testReturn = {'message' : data, 'status': status };
                })
                .error(function(data, status) {
                    console.log("[FAIL]");
                    $scope.testReturn = {'message' : data, 'status': status };
                });
        }
        
        $scope.echo = function() {
            $http.get(defaultUrl + 'echo/' + $scope.echo)
                .success(function(data, status) {
                    $scope.echoReturn = {'message': data, 'status': status };
                })
                .error(function(data, status) {
                    $scope.echoReturn = {'message': data, 'status': status };
                });
        }
        
        $scope.api = function() {
            $http.get(defaultUrl + 'api')
                .success(function(data, status) {
                    $scope.apiReturn = {'urls': data, 'status': status };
                })
                .error(function(data, status) {
                    $scope.apiReturn = {'url': data, 'status': status };
                });
        }
        
}]);
