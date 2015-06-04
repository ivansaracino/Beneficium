angular.module('myBenefit')
        .controller('listaContrattiAutoController', function ($scope, dataServices, $routeParams) {
            var callback = function (contrattiauto) {
                $scope.contrattiauto = contrattiauto;

            };

            var error = function (risposta) {
                alert("errore lato server");
            };


            dataServices.ListaContrattiAuto($routeParams.id, callback);
            
           

        });

