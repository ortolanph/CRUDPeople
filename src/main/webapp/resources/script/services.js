var serviceTestApp = angular.module('serviceTestApp', []);

serviceTestApp.controller('TesteController', ['$scope','$http', function($scope, $http) {
        
        $scope.defaultUrl = "http://localhost:8080/crudpeople/testservice/";
        
        $scope.test = function() {
            console.log('Calling URL: ' + $scope.defaultUrl + 'test');
            $http.get($scope.defaultUrl + 'test')
                .success(function(data, status) {
                    console.log('[OK]');
                    $scope.testReturn = {'message' : data.result, 'status': status };
                })
                .error(function(data, status) {
                    console.log('[FAIL]');
                    $scope.testReturn = {'message' : data, 'status': status };
                });
        };
        
        $scope.echo = function() {
            $http.get($scope.defaultUrl + 'echo/' + $scope.echo)
                .success(function(data, status) {
                    $scope.echoReturn = {'message': data, 'status': status };
                })
                .error(function(data, status) {
                    $scope.echoReturn = {'message': data, 'status': status };
                });
        };
        
        $scope.api = function() {
            $http.get($scope.defaultUrl + 'api/')
                .success(function(data, status) {
                    $scope.apiReturn = {'urls': data, 'status': status };
                })
                .error(function(data, status) {
                    $scope.apiReturn = {'url': data, 'status': status };
                });
        };
        
}]);