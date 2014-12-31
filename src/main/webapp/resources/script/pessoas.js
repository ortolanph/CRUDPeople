var pessoaApp = angular.module('pessoaApp', []);

pessoaApp.controller('PessoaController', ['$scope', '$http', function ($scope, $http) {

        $scope.defaultUrl = "http://localhost:8080/crudpeople/peopleservice/";
        $scope.deleteMessage = '';

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
            var finder = '';
            
            if($scope.isEmpty($scope.nome)) {
                finder = 'findAll';
            } else {
                finder += 'find/' + $scope.nome;
            }
            
            console.log('Calling URL: ' + $scope.defaultUrl + finder);
            
            $http.get($scope.defaultUrl + finder)
                    .success(function (data) {
                        console.log('[OK]');
                        $scope.resultadoPesquisa = data;
                        
                        if(!$scope.isEmpty($scope.deleteMessage)) {
                            $scope.resultadoPesquisa.result.message = $scope.deleteMessage;
                        }
                    })
                    .error(function (data) {
                        console.log('[FAIL]');
                        $scope.resultadoPesquisa = {'result' : {'status': 'FAIL', 'message' : data }};
                    });
        };

        $scope.findById = function(id) {
            console.log('Calling URL: ' + $scope.defaultUrl + 'findById/' + id);
            
            $http.get($scope.defaultUrl + 'findById/' + id)
                    .success(function (data) {
                        console.log('[OK]');
                        $scope.resultadoBusca = data;
                    })
                    .error(function (data) {
                        console.log('[FAIL]');
                        $scope.resultadoBusca = {'result' : {'status': 'FAIL', 'message' : data }};
                    });
        }
        
        $scope.update = function() {
            console.log('Calling URL: ' + $scope.defaultUrl + 'update');

            var data = {'id': $scope.resultadoBusca.pessoa.id, 
                        'nome': $scope.resultadoBusca.pessoa.nome, 
                        'endereco': $scope.resultadoBusca.pessoa.endereco, 
                        'telefone': $scope.resultadoBusca.pessoa.telefone};

            $http.post($scope.defaultUrl + 'update', data)
                    .success(function (data) {
                        console.log('[OK]');
                        $scope.resultadoBusca = data;
                    })
                    .error(function (data, status) {
                        console.log('[FAIL]');
                        $scope.resultadoBusca = {'result' : {'status': 'FAIL', 'message' : data }};
                    });
        }
        
        $scope.delete = function(id) {
            console.log('Calling URL: ' + $scope.defaultUrl + 'delete/' + id);
            
            $http.get($scope.defaultUrl + 'delete/' + id)
                    .success(function (data) {
                        console.log('[OK]');
                        $scope.deleteMessage = data.result;
                        $scope.find();
                    })
                    .error(function (data) {
                        console.log('[FAIL]');
                        $scope.resultadoPesquisa = {'result' : {'status': 'FAIL', 'message' : data }};
                    });
            
        }
        
        $scope.isEmpty = function(value) {
            console.log('Verifying id value isEmpty = ' + value);
            return (value === undefined || value == null || value.length <= 0) ? true : false;
        }

    }]);