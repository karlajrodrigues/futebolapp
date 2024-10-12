<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<html lang="en" ng-app="futebolApp">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastrar Time </title>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/app/time.js"></script>
    </head>
    <body  ng-controller="TimeController as ctrlTime">
        <div>
            <h2>Cadastrar Time</h2>

            <form ng-submit="ctrlTime.cadastrarTime()">
                <label for="nome">Nome do time: </label>
                <input type="text" id="nome" ng-model="ctrlTime.time.nome" required> <br><br>
                <label for="nome">Estádio: </label>
                <input type="text" id="estadio" ng-model="ctrlTime.time.estadio" required> <br><br>
                
                <input type="submit" value="Cadastrar Time">
            </form>
        </div>
        <div ng-if="ctrlTime.sucessMessage" style="color: green;">
            {{ctrlTime.sucessMessage}}
        </div>
        <div ng-if="ctrlTime.errorMessage" style="color: red;">
            {{ctrlTime.errorMessage}}
        </div>
    </body>
</html>
