<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="testApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js"></script>
        <script src="resources/script/test.js"></script>
        <title>Test Service Test</title>
    </head>
    <body ng-controler="TestController">
        <h1>Test Service Test</h1>
        
        <h2>test service</h2>
        <form ng-submit="callTest()">
            <input type="submit" value="Call test service" />
        </form>
        <p><strong>Message:</strong>{{testReturn.message}}</p>
        <p><strong>Status</strong>{{testReturn.status}}</p>
    </body>
</html>
