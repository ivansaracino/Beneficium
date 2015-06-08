angular.module('myBenefit')
        .controller('dipCtrl', function ($modal, $scope, dataServices, dialogServices, $location) {
            var callback = function (dipendenti) {
                $scope.dipendenti = dipendenti;
            };

            var error = function (risposta) {
                alert("errore lato server");
            };


            dataServices.listadipendentijson(callback);


            $scope.AggiungiContrattoTelefonico = function (codiceFiscale) {
                var modalInstance = $modal.open({
                    templateUrl: 'partials/nuovoContrattoTelefonico.html',
                    controller: 'dialogoNuovoContrattoTelefonicoController',
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

                modalInstance.result.then(function (contratto) {

                    // salvataggio del contratto telefonico
                    dataServices.aggiungiContrattoTelefonico(contratto, codiceFiscale);
                    toastr.success('Contratto telefonico inserito', 'Beneficium');
                }, function () {
                    toastr.error('Inserimento contratto annullato, riprovare', 'Beneficium');
                });
            };



            $scope.AggiungiContrattoAuto = function (codiceFiscale) {

                var modalInstance = $modal.open({
                    templateUrl: 'partials/nuovoContrattoAuto.html',
                    controller: 'dialogoNuovoContrattoAutoController',
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

                modalInstance.result.then(function (contrattoAuto) {

                    // salvataggio del contratto auto
                    dataServices.aggiungiContrattoAuto(contrattoAuto, codiceFiscale);
                    toastr.success('Contratto auto inserito', 'Beneficium');
                }, function () {
                    toastr.error('Inserimento contratto annullato, riprovare', 'Beneficium');
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
                    dataServices.salva(dipendente, callback, error);
                    $location.path("/listadipendentijson");
                    toastr.success('Dipendente inserito', 'Beneficium');
                }, function () {
                    toastr.error('aggiunta dipendente annullata, riprovare', 'Beneficium');
                });
            };

            $scope.modificaDipendente = function (dipendente) {

                var modalInstance = $modal.open({
                    templateUrl: 'partials/modificadipendente.html',
                    controller: 'dialogoNuovoDipendenteController',
                    resolve: {
                        data: function () {
                            return {
                                dipendente: dipendente,
                                titolo: 'Modifica Dipendente',
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
                    toastr.error('modifica annullata, riprovare', 'Beneficium');
                });

            };


            $scope.visualizzaAuto = function (codiceFiscale) {
                $location.path('/listaauto/' + codiceFiscale);
            };

            $scope.VisualizzaCellulari = function (codiceFiscale) {
                $location.path('/listacellulari/' + codiceFiscale);
            };


        });
