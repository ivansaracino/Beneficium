angular.module('myBenefit')
        .controller('dipCtrl', function ($modal, $scope, dataServices, dialogServices, $location) {
            var callback = function (dipendenti) {
                $scope.dipendenti = dipendenti;
            };
             var error = function (risposta) {
                alert("errore lato server");
            };
            
            dataServices.listadipendentijson(callback);
            

            $scope.modificaDipendente = function (dipendente) {
                alert("modifica di " + dipendente.codiceFiscale);
            };

            $scope.eliminaDipendente = function (codiceFiscale) {
                dialogServices.attivaDialog("Sei sicuro di voler rimuover " + codiceFiscale,
                        "Rimozione dipendente",
                        ['Conferma', 'Annulla'])
                        .then(function () {
                            alert("Il dipendente con codice fiscale : " + codiceFiscale + " è stato rimosso");
                        });
            };
            
             
           

            $scope.aggiungiDipendente = function () {
                var modalInstance = $modal.open({
                    templateUrl: 'partials/nuovo-dipendente.html',

                    controller: 'dialogoNuovoDipendenteController',

                    resolve: {
                        data: function () {
                            return {
                                titolo: 'Nuovo Dipendente',
                                buttons: ['Salva', 'Annulla']
                            };
                        }
                    },

                    size: 'lg'
                });
                
                

                modalInstance.result.then(function (dipendente) {
                    dataServices.salva(dipendente, callback, error);
                    $location.path("/listadipendentijson");
                }, function () {
                    console.log("aggiunta dipendente annullata");
                });

              
            };
            
           
        });



