<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="pessoaApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js"></script>
        <script src="../resources/script/pessoas.js"></script>
        <link rel="stylesheet" href="../resources/style/crudpeople.css" />
        <title>Cadastrar Pessoa</title>
    </head>
    <body ng-controller="PessoaController">
        <h1>Cadastrar Pessoa</h1>
        <fieldset>
            <legend>Dados da Pessoa</legend>
            <p>{{message.result}}</p>
            <form ng-submit="createPessoa()">
                <table>
                    <tr>
                        <td><strong>Nome</strong></td>
                        <td><input type="text" ng-model="nome" size="50" /></td>
                    </tr>
                    <tr>
                        <td><strong>Endereco</strong></td>
                        <td><input type="text" ng-model="endereco" size="50" /></td>
                    </tr>
                    <tr>
                        <td><strong>Nome</strong></td>
                        <td><input type="tel" ng-model="telefone" 
                                   pattern="[\(]\d{2}[\)]\d{5}[\-]\d{4}" 
                                   title="Telefone (Formato: (99)99999-9999)"
                                   size="14"/></td>
                    </tr>
                </table>
                <p><input type="submit" value="Cadastrar" /></p>
            </form>
        </fieldset>
    </body>
</html>
