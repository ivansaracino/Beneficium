angular.module('myBenefit')
        .controller('listaContrattiCellulareController', function ($modal,$scope, dataServices, $routeParams) {
            var callback = function (contratticellulare) {
                $scope.contratticellulare = contratticellulare;

            };

            var error = function (risposta) {
                alert("errore lato server");
            };


            dataServices.ListaContrattiCellulare($routeParams.id, callback);
            
           
           $scope.modificaContrattoCellulare = function (contrattocellulare) {

                var modalInstance = $modal.open({
                    templateUrl: 'partials/modificacontrattocellulare.html',
                    controller: 'dialogoNuovoContrattoTelefonicoController',
                    resolve: {
                        data: function () {
                            return {
                                contrattocellulare: contrattocellulare,
                                titolo: 'Modifica contratto cellulare',
                                buttons: ['Salva', 'Annulla']
                            };
                        }
                    },
                    size: 'lg'
                });


                modalInstance.result.then(function (contrattocellulare) {
                    dataServices.aggiungiContrattoTelefonico(contrattocellulare, callback, error);

                }, function () {
                    console.log("modifica contratto annullata");
                });

            };
        });

