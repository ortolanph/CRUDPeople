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
        <div id="wrap">
            <h1>Cadastro de pessoas</h1>

 			<fieldset ng-submit="find()">
				<legend>Pesquisa</legend>

                <form>
                    <p><span>Nome:</span>
                    <input size="50" type="text" ng-model="nome"></p>
                    <p><input type="submit" value="Pesquisar"></p>
                </form>

                <p ng-if="resultadoPesquisa.result.message" ng-class="{{resultadoPesquisa.result.status}}">{{resultadoPesquisa.result.message}}</p>
            </fieldset>

            <h2>Resultados</h2>
            <table>
  				<tr>
  					<th>Nome</th>
  					<th>Endereço</th>
  					<th>Telefone</th>
  					<th>&nbsp;</th>
  				</tr>
				<tr ng-repeat="pessoa in resultadoPesquisa.pessoas">
					<td>{{pessoa.nome}}</td>
					<td>{{pessoa.endereco}}</td>
					<td>{{pessoa.telefone}}</td>
					<td>
					    <a href="${pageContext.request.contextPath}/pessoas/alterar.jsp?id={{pessoa.id}}">Editar</a>
					    <a ng-click="delete(pessoa.id)">Excluir</a>
					</td>
				</tr>
            </table>

            <p><a href="${pageContext.request.contextPath}/pessoas/cadastrar.jsp">Cadastrar</a></p>
            <p><a href="${pageContext.request.contextPath}/index.jsp">Voltar</a></p>
        </div>
    </body>
</html>
