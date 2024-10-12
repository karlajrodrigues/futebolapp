(function(){
    var app = angular.module('futebolapp',[]);

    app.controller('TimeController', ['$http', function($http){
        var  self = this;
        self.time = {};
        self.sucessMessage = null;
        self.errorMessage = null;

        self.cadastrarTime = function(){
            $http.post('/api/times', self.time)
            .then(function(response){
                self.sucessMessage = "Time cadastrado com sucesso!"; 
                self.errorMessage = null;
                self.time = {}; // Limpar o formulario
            }, function(error){
                self.errorMessage = "Erro ao cadastrar time";
                self.sucessMessage = null;
            });
            }

    }])
})();