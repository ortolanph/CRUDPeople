var pessoaApp = angular.module('pessoaApp', []);

pessoaApp.controller('PessoaController', ['$scope', '$http', function ($scope, $http) {

        $scope.defaultUrl = "http://localhost:8080/crudpeople/peopleservice/";

        $scope.createPessoa = function () {
            console.log('Calling URL: ' + $scope.defaultUrl + 'create');

            var data = {'nome': $scope.nome, 'endereco': $scope.endereco, 'telefone': $scope.telefone};
            console.log('Data: ' + data);

            $http.post($scope.defaultUrl + 'create', data)
                    .success(function (data) {
                        console.log('[OK]');
                        $scope.message = data;
                    })
                    .error(function (data, status) {
                        console.log('[FAIL]');
                        $scope.message = {'result' : data + status};
                    });
        };
        
        $scope.find = function() {
            var finder = 'find/';
            
            if($scope.nome === undefined) {
                finder = 'findAll';
            } else {
                finder += $scope.nome;
            }
            
            console.log('Calling URL: ' + $scope.defaultUrl + finder);
            
            $http.get($scope.defaultUrl + finder)
                    .success(function (data) {
                        console.log('[OK]');
                        $scope.resultadoPesquisa = data;
                    })
                    .error(function (data) {
                        console.log('[FAIL]');
                        $scope.resultadoPesquisa = {'result' : {'status': 'FAIL', 'message' : data }};
                    });
        };

        $scope.findById = function() {
            console.log('Calling URL: ' + $scope.defaultUrl + 'findById/' + $scope.id);
            
        }
        
        $scope.remove = function() {
            console.log('Calling URL: ' + $scope.defaultUrl + 'remove/' + $scope.id);
            
        }
        
        $scope.update = function() {
            console.log('Calling URL: ' + $scope.defaultUrl + 'update/' + $scope.id);
            
        }

    }]);