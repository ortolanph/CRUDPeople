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
        <h1>Alterar Pessoa</h1>
        <fieldset>
            <legend>Dados da Pessoa</legend>
            <p ng-if="resultadoBusca.result.message">[{{resultadoBusca.result.status}}]: {{resultadoBusca.result.message}}</p>
            <form ng-submit="update()">
                <input type="text" ng-model="resultadoBusca.pessoa.id" />
                <table>
                    <tr>
                        <td><strong>Nome</strong></td>
                        <td><input type="text" ng-model="resultadoBusca.pessoa.nome" size="50" /></td>
                    </tr>
                    <tr>
                        <td><strong>Endereco</strong></td>
                        <td><input type="text" ng-model="resultadoBusca.pessoa.endereco" size="50" /></td>
                    </tr>
                    <tr>
                        <td><strong>Telefone</strong></td>
                        <td><input type="tel" ng-model="resultadoBusca.pessoa.telefone" 
                                   pattern="[\(]\d{2}[\)]\d{5}[\-]\d{4}" 
                                   title="Telefone (Formato: (99)99999-9999)"
                                   size="14"/></td>
                    </tr>
                </table>
                <p><input type="submit" value="Alterar" /></p>
            </form>
        </fieldset>
        <p><a href="${pageContext.request.contextPath}/pessoas/pessoas.jsp">Voltar</a></p>
    </body>
</html>
