<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="serviceTestApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js"></script>
        <script src="resources/script/services.js"></script>
        <title>Test Service Test</title>
    </head>
    <body ng-controller="TesteController">
        <h1>Test Service Test</h1>

        <fieldset>
            <legend>The <code>test</code> service</legend>
            <form ng-submit="test()">
                <input type="submit" value="Call test service" />
            </form>
            <p><strong>Message: </strong>{{testReturn.message}}</p>
            <p><strong>Status: </strong>{{testReturn.status}}</p>
        </fieldset>
    </body>
</html>