angular.module('myBenefit')
        .controller('listaContrattiCellulareController', function ($modal,$scope, dataServices, $routeParams) {
            var callback = function (risposta) {
                if (risposta.status)
                    $scope.contratticellulare = risposta.oggetto;
                else
                    toastr.error(risposta.messaggio);

            };

            var error = function (risposta) {
                toastr.error("Non verrò mai eseguito!");
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
                    alert(contrattocellulare.cellulare.dipendente.codiceFiscale);
                    dataServices.aggiungiContrattoTelefonico(contrattocellulare, callback, error);

                }, function () {
                    console.log("modifica contratto annullata");
                });

            };
        });

