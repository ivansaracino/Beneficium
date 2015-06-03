angular.module('myBenefit')
        .controller('listaCellulariController', function ($scope, dataServices, $routeParams) {
                var callback = function (cellulari) {
                    $scope.cellulari = cellulari;
                 
                };

                var error = function (risposta) {
                    alert("errore lato server");
                };


                dataServices.ListaCellulari($routeParams.codiceFiscale,callback);

        }); 

