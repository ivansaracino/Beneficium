angular.module('myBenefit')
        .controller('listaAutoController', function ($scope, dataServices, $routeParams) {
                var callback = function (automobili) {
                    $scope.automobili = automobili;
                 
                };

                var error = function (risposta) {
                    alert("errore lato server");
                };


                dataServices.ListaAuto($routeParams.codiceFiscale,callback);

        }); 

