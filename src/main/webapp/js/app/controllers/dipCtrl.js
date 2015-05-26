angular.module('myBenefit')
        .controller('dipCtrl', function ($modal, $scope, dataServices, dialogServices) {
            var callback = function (dipendenti) {
                $scope.dipendenti = dipendenti;
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
            
            $scope.aggiungiContrattoTelefonico = function () {
                alert("aggiungo contratto telefonico ");
            };
            
             $scope.aggiungiContrattoAutomobile = function () {
                alert("aggiungo contratto automobile ");
            };
            
           
            
            

//            $scope.aggiungiProdotto = function () {
//                var modalInstance = $modal.open({
//                    templateUrl: 'partials/nuovo-prodotto.html',
//                    controller: 'dialogoNuovoProdottoController',
//                    resolve: {
//                        data: function () {
//                            return {
//                                titolo: 'Nuovo Prodotto',
//                                buttons: ['Salva', 'Annulla']
//                            };
//                        }
//                    },
//                    size: 'sm'
//                });
//
//                modalInstance.result.then(function (prodotto) {
//                    alert("Salvo " + prodotto.prezzo + "-" + prodotto.nome);
//                }, function () {
//                    alert('Inserimento annullato');
//                });
//            };
        });



