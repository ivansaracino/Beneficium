angular.module('myBenefit')
        .controller('listaCellulariController', function ($scope, dataServices, $routeParams,$location) {
            var callback = function (cellulari) {
                $scope.cellulari = cellulari;

            };

            var error = function (risposta) {
                alert("errore lato server");
            };


            dataServices.ListaCellulari($routeParams.codiceFiscale, callback);

            $scope.VisualizzaContrattiCellulare = function (id) {
                $location.path('/listaContrattiCellulare/' + id);
            };

        });

