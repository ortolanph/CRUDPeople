<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="pessoaApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/script/pessoas.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style/crudpeople.css" />
        <title>Cadastro de pessoas</title>
    </head>
    <body ng-controller="PessoaController">
        <h1>Cadastro de pessoas</h1>

        <fieldset>
            <legend>Pesquisa</legend>
            <p ng-if="resultadoPesquisa.result.message">[{{resultadoPesquisa.result.status}}]: {{resultadoPesquisa.result.message}}</p>
            <form ng-submit="find()">
                <table>
                    <tr>
                        <td><strong>Nome: </strong></td>
                        <td><input type="text" ng-model="nome" size="50"/></td>
                    </tr>
                </table>
                <p style="text-align: right"><input type="submit" value="Pesquisar"/></p>
            </form>
        </fieldset>

        <p style="text-align: center">
            <strong>Resultados</strong>
        <table>
            <tr>
                <td style="color: white; background: black; text-align: center"><strong>Nome</strong></td>
                <td style="color: white; background: black; text-align: center"><strong>Endereço</strong></td>
                <td style="color: white; background: black; text-align: center"><strong>Telefone</strong></td>
                <td style="color: white; background: black; text-align: center"><strong></strong></td>
            </tr>
            <tr ng-repeat="pessoa in resultadoPesquisa.pessoas">
                <td><a href="${pageContext.request.contextPath}/pessoas/alterar.jsp?id={{pessoa.id}}">{{pessoa.nome}}</a></td>
                <td>{{pessoa.endereco}}</td>
                <td>{{pessoa.telefone}}</td>
                <td><a ng-click="delete(pessoa.id)">Excluir</a></td>
            </tr>
        </table>
    </p>

    <p><a href="${pageContext.request.contextPath}/pessoas/cadastrar.jsp">Cadastrar</a></p>
</body>
</html>
