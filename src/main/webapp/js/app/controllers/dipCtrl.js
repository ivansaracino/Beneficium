angular.module('myBenefit')
        .controller('dipCtrl', function ($modal, $scope, dataServices, dialogServices, $location) {
            var callbacknuovodipendente = function (risposta) {
                //$scope.dipendenti = risposta.oggetto;
                toastr.success("Inserito " + risposta.oggetto.nome);
            };
            
            var callbacknuovocontatto = function(risposta) {
                toastr.success("Inserito " + risposta.oggetto.costoBimestrale);
            };

            var error = function (risposta) {
                // TOAST di errore
                // risposta.oggetto
                // risposta.messagio
                alert("errore lato server");
            };
            

            dataServices.listadipendentijson(callbacknuovodipendente);
            

            $scope.AggiungiContrattoTelefonico = function (codiceFiscale) {
                var modalInstance = $modal.open({
                    templateUrl: 'partials/nuovoContrattoTelefonico.html',
                    controller: 'dialogoNuovoContrattoTelefonicoController',
                    resolve: {
                        data: function () {
                            return {

                                codiceFiscale : codiceFiscale,
                                titolo: 'Nuovo contratto telefonico',
                                buttons: ['Salva', 'Annulla']
                            };
                        }
                    },
                    size: 'lg'
                });

                modalInstance.result.then(function (contratto) {
                    
                    // salvataggio del contratto telefonico
                    dataServices.aggiungiContrattoTelefonico(contratto, callbacknuovocontatto, error);
                   
                }, function () {
                    toastr.error('Annullato inserimento contratto telefonico', 'Beneficium');
                });
            };



            $scope.AggiungiContrattoAuto = function (codiceFiscale) {

                var modalInstance = $modal.open({
                    templateUrl: 'partials/nuovoContrattoAuto.html',
                    controller: 'dialogoNuovoContrattoAutoController',
                    resolve: {
                        data: function () {
                            return {
                                titolo: 'Nuovo contratto leasing',
                                buttons: ['Salva', 'Annulla']
                            };
                        }
                    },
                    size: 'lg'
                });

                modalInstance.result.then(function (contrattoAuto) {
                    
                     // salvataggio del contratto auto
                    dataServices.aggiungiContrattoAuto(contrattoAuto, codiceFiscale);
                    toastr.success('Contratto leasing inserito', 'Beneficium');
                }, function () {
                    toastr.error('Annullato inserimento contratto leasing', 'Beneficium');
                });
            };

            
             
           

            $scope.aggiungiDipendente = function () {
                var modalInstance = $modal.open({
                    templateUrl: 'partials/nuovo-dipendente.html',
                    controller: 'dialogoNuovoDipendenteController',
                    resolve: {
                        data: function () {
                            return {
                                titolo: 'Nuovo dipendente',
                                buttons: ['Salva', 'Annulla']
                            };
                        }
                    },
                    size: 'lg'
                });
                modalInstance.result.then(function (dipendente) {
                    dataServices.salva(dipendente, callbacknuovodipendente, error);
                    $location.path("/listadipendentijson");
                  
                }, function () {
                    toastr.error('Annullato inserimento dipendente ', 'Beneficium');
                });
            };

              $scope.modificaDipendente = function(dipendente) {
                 
                        var modalInstance = $modal.open({
                       
                        templateUrl: 'partials/modificadipendente.html',
                        controller: 'dialogoNuovoDipendenteController',
                        
                        resolve: {
                            data: function() {
                                return {
                                    dipendente:dipendente,
                                    titolo: 'Modifica dipendente',
                                    buttons: ['Salva', 'Annulla']
                                };
                            }
                        },
                        size: 'lg'
                        });
                        
                      
                        modalInstance.result.then(function (dipendente) {
                            dataServices.salva(dipendente, callback, error);
                            toastr.success('Dipendente modificato', 'Beneficium');
                    
                }, function () {
                    toastr.error('Annullata modifica dipendente', 'Beneficium');
                    console.log("Annullato modifica dipendente");
                });

                    };
            
           $scope.visualizzaAuto = function(codiceFiscale){
               $location.path('/listaauto/' + codiceFiscale);
           };
           
           $scope.VisualizzaCellulari = function(codiceFiscale){
               $location.path('/listacellulari/' + codiceFiscale);
           };
           
           
        });
