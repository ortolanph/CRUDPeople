<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="pessoaApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/script/pessoas.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style/crudpeople.css" />
        <title>Cadastrar Pessoa</title>
    </head>
    <body ng-controller="PessoaController">
		<div id="wrap">
			<h1>Cadastrar Pessoa</h1>

			<fieldset>
				<legend>Dados da Pessoa</legend>

				<form ng-submit="createPessoa()">
					<p><span>* Nome:</span>
					<input size="50" type="text" ng-model="nome"></p>
					<p><span>* Endereco:</span>
					<input size="50" type="text" ng-model="endereco"></p>
					<p><span>* Telefone:</span>
					<input pattern="[\(]\d{2}[\)]\d{5}[\-]\d{4}" placeholder="(99)99999-9999" title="Telefone (Formato: (99)99999-9999)" size="14" type="tel" ng-model="telefone"></p>
					<p><input type="submit" value="Cadastrar"></p>
				</form>

				<p ng-if="message.result">{{message.result}}</p>
			</fieldset>

			<p><a href="${pageContext.request.contextPath}/pessoas/pessoas.jsp">Voltar</a></p>
		<div>
    </body>
</html>
