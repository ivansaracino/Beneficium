angular.module('myBenefit')
        .controller('listaAutoController', function ($scope, dataServices, $routeParams,$location) {
            var callback = function (automobili) {
                $scope.automobili = automobili;

            };

            var error = function (risposta) {
                alert("errore lato server");
            };


            dataServices.ListaAuto($routeParams.codiceFiscale, callback);
            
            $scope.VisualizzaContrattiAuto = function (id) {
                $location.path('/listaContrattiAuto/' + id);
            };

        });

