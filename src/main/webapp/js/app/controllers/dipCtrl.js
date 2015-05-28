angular.module('myBenefit')
        .controller('dipCtrl', function ($modal, $scope, dataServices, dialogServices, $location) {
            var callback = function (dipendenti) {
                $scope.dipendenti = dipendenti;
            };

             var error = function (risposta) {
                alert("errore lato server");
            };
            

            dataServices.listadipendentijson(callback);
            

            $scope.AgggiungiContrattoTelefonico = function (codiceFiscale) {
                var modalInstance = $modal.open({
                    templateUrl: 'partials/nuovoContrattoTelefonico.html',
                    controller: 'dialogoNuovoContrattoTelefonicoController',
                    resolve: {
                        data: function () {
                            return {
                                titolo: 'Nuovo Contratto',
                                buttons: ['Salva', 'Annulla']
                            };
                        }
                    },
                    size: 'lg'
                });

                modalInstance.result.then(function (contratto) {
                    alert(codiceFiscale);
                    // salvataggio del contratto telefonico
                    dataServices.aggiungiContrattoTelefonico(contratto, codiceFiscale);

                }, function () {
                    alert('Inserimento annullato');
                });
            };


            $scope.AgggiungiContrattoAuto = function () {
                var modalInstance = $modal.open({
                    templateUrl: 'partials/nuovoContrattoAuto.html',
                    controller: 'dialogoNuovoContrattoAutoController',
                    resolve: {
                        data: function () {
                            return {
                                titolo: 'Nuovo Contratto',
                            };
                        }
                    },
                    size: 'sm'
                });

                modalInstance.result.then(function (dipendente) {
                    $location.path('/salvacontratto');
                }, function () {
                    alert('Inserimento annullato');
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

            