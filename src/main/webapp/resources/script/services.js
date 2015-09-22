var serviceTestApp = angular.module('serviceTestApp', []);

serviceTestApp.controller('TesteController', ['$scope','$http', function($scope, $http) {
        
        $scope.defaultUrl = "/crudpeople/testservice/";
        
        $scope.test = function() {
            $http.get($scope.defaultUrl + 'test')
                .success(function(data, status) {
                    $scope.testReturn = {'message' : data.result, 'status': status };
                })
                .error(function(data, status) {
                    $scope.testReturn = {'message' : data, 'status': status };
                });
        };
        
        $scope.echo = function() {
            $http.get($scope.defaultUrl + 'echo/' + $scope.echoMessage)
                .success(function(data, status) {
                    $scope.echoReturn = {'message': data.result, 'status': status };
                })
                .error(function(data, status) {
                    $scope.echoReturn = {'message': data, 'status': status };
                });
        };
        
        $scope.api = function() {
            $http.get($scope.defaultUrl + 'api/')
                .success(function(data, status) {
                    $scope.apiReturn = {'urls': data.result, 'status': status };
                })
                .error(function(data, status) {
                    $scope.apiReturn = {'url': data, 'status': status };
                });
        };
        
}]);