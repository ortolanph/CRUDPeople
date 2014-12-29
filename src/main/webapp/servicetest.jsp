<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="serviceTestApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js"></script>
        <script src="resources/script/services.js"></script>
        <link rel="stylesheet" href="resources/style/crudpeople.css" />
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

        <fieldset>
            <legend>The <code>echo</code> service</legend>
            <form ng-submit="echo()">
                Message to echo: <input ng-model="echoMessage" />
                <input type="submit" value="Call echo/{{echoMessage}} service" />
            </form>
            <p><strong>Message: </strong>{{echoReturn.message}}</p>
            <p><strong>Status: </strong>{{echoReturn.status}}</p>
        </fieldset>
        
        <fieldset>
            <legend>The <code>api</code> service</legend>
            <form ng-submit="api()">
                <input type="submit" value="Call api service" />
            </form>
            <p><strong>Message: </strong><ol><li ng-repeat="url in apiReturn.urls">{{url}}</li></ol></p>
            <p><strong>Status: </strong>{{apiReturn.status}}</p>
        </fieldset>
    </body>
</html>