angular.module('myBenefit')
        .controller('listaContrattiCellulareController', function ($scope, dataServices, $routeParams) {
            var callback = function (contratticellulare) {
                $scope.contratticellulare = contratticellulare;

            };

            var error = function (risposta) {
                alert("errore lato server");
            };


            dataServices.ListaContrattiCellulare($routeParams.id, callback);
            
           

        });

