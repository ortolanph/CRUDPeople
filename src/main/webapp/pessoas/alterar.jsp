<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="pessoaApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/script/pessoas.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style/crudpeople.css" />
        <title>Alterar Pessoa</title>
    </head>
    <body ng-controller="PessoaController" ng-init="findById('${param['id']}')">
        <div id="wrap">
            <h1>Alterar Pessoa</h1>

            <fieldset>
                <legend>Dados da Pessoa</legend>

                <form ng-submit="update()">
                    <input type="hidden" ng-model="resultadoBusca.pessoa.id" />
                    <p><span>Nome:</span>
                    <input type="text" ng-model="resultadoBusca.pessoa.nome" size="50" /></p>
                    <p><span>Endereco:</span>
                    <input type="text" ng-model="resultadoBusca.pessoa.endereco" size="50" /></p>
                    <p><span>Telefone:</span>
                    <input  ng-model="resultadoBusca.pessoa.telefone" pattern="[\(]\d{2}[\)]\d{5}[\-]\d{4}" placeholder="(99)99999-9999" title="Telefone (Formato: (99)99999-9999)" size="14" type="tel"></p>
                    <p><input type="submit" value="Alterar"></p>
                </form>

                <p ng-if="resultadoBusca.result.message" ng-class="{{resultadoBusca.result.status}}">{{resultadoBusca.result.message}}</p>
            </fieldset>

            <p><a href="${pageContext.request.contextPath}/pessoas/pessoas.jsp">Voltar</a></p>
        </div>
    </body>
</html>
