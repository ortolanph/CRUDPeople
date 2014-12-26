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
            console.log('Calling URL: ' + $scope.defaultUrl + 'echo/' + $scope.echoMessage);
            $http.get($scope.defaultUrl + 'echo/' + $scope.echoMessage)
                .success(function(data, status) {
                    console.log('[OK]');
                    $scope.echoReturn = {'message': data.result, 'status': status };
                })
                .error(function(data, status) {
                    console.log('[FAIL]');
                    $scope.echoReturn = {'message': data, 'status': status };
                });
        };
        
        $scope.api = function() {
            console.log('Calling URL: ' + $scope.defaultUrl + 'api');
            $http.get($scope.defaultUrl + 'api/')
                .success(function(data, status) {
                    console.log('[OK]');
                    $scope.apiReturn = {'urls': data.result, 'status': status };
                })
                .error(function(data, status) {
                    console.log('[FAIL]');
                    $scope.apiReturn = {'url': data, 'status': status };
                });
        };
        
}]);