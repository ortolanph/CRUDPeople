var pessoaApp = angular.module('pessoaApp', []);

pessoaApp.controller('PessoaController', ['$scope', '$http', function ($scope, $http) {

        $scope.defaultUrl = "/crudpeople/peopleservice/";
        $scope.deleteMessage = '';

        $scope.createPessoa = function () {

            if(!$scope.isEmpty($scope.nome) && !$scope.isEmpty($scope.nome) && !$scope.isEmpty($scope.nome) ) {

                $scope.nome = $scope.nome.replace(/</g, '&lt;').replace(/>/g, '&gt;');

                var data = {'nome': $scope.nome, 'endereco': $scope.endereco, 'telefone': $scope.telefone};

                $http.post($scope.defaultUrl + 'create', data)
                        .success(function (data) {
                            $scope.message = data;
                        })
                        .error(function (data, status) {
                            $scope.message = {'result' : data + status};
                        });
            } else {
                $scope.message = {'result': 'Campos não preenchidos'}
            }
        };
        
        $scope.find = function() {
            var finder = '';
            
            if($scope.isEmpty($scope.nome)) {
                finder = 'findAll';
            } else {
                finder += 'find/' + $scope.nome;
            }
            
            $http.get($scope.defaultUrl + finder)
                    .success(function (data) {
                        $scope.resultadoPesquisa = data;
                        
                        if(!$scope.isEmpty($scope.deleteMessage)) {
                            $scope.resultadoPesquisa.result.message = $scope.deleteMessage;
                        }
                    })
                    .error(function (data) {
                        $scope.resultadoPesquisa = {'result' : {'status': 'FAIL', 'message' : data }};
                    });
        };

        $scope.findById = function(id) {
            console.log('Calling URL: ' + $scope.defaultUrl + 'findById/' + id);
            
            $http.get($scope.defaultUrl + 'findById/' + id)
                    .success(function (data) {
                        $scope.resultadoBusca = data;
                    })
                    .error(function (data) {
                        $scope.resultadoBusca = {'result' : {'status': 'FAIL', 'message' : data }};
                    });
        }
        
        $scope.update = function() {

            var data = {'id': $scope.resultadoBusca.pessoa.id, 
                        'nome': $scope.resultadoBusca.pessoa.nome, 
                        'endereco': $scope.resultadoBusca.pessoa.endereco, 
                        'telefone': $scope.resultadoBusca.pessoa.telefone};

            $http.post($scope.defaultUrl + 'update', data)
                    .success(function (data) {
                        $scope.resultadoBusca = data;
                    })
                    .error(function (data, status) {
                        $scope.resultadoBusca = {'result' : {'status': 'FAIL', 'message' : data }};
                    });
        }
        
        $scope.delete = function(id) {
            
            $http.get($scope.defaultUrl + 'delete/' + id)
                    .success(function (data) {
                        $scope.deleteMessage = data.result;
                        $scope.find();
                    })
                    .error(function (data) {
                        $scope.resultadoPesquisa = {'result' : {'status': 'FAIL', 'message' : data }};
                    });
            
        }
        
        $scope.isEmpty = function(value) {
            return (value === undefined || value == null || value.length <= 0) ? true : false;
        }

    }]);