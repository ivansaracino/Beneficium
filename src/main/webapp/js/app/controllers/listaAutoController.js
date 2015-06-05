angular.module('myBenefit')
        .controller('listaAutoController', function ($modal,$scope, dataServices, $routeParams, $location) {
            var callback = function (automobili) {
                $scope.automobili = automobili;

            };

            var error = function (risposta) {
                alert("errore lato server");
            };


            dataServices.ListaAuto($routeParams.codiceFiscale, callback);

            $scope.modificaAuto = function (automobili) {

                var modalInstance = $modal.open({
                    templateUrl: 'partials/modificaauto.html',
                    controller: 'dialogoNuovoContrattoAutoController',
                    resolve: {
                        data: function () {
                            return {
                                automobili: automobili,
                                titolo: 'Modifica automobile',
                                buttons: ['Salva', 'Annulla']
                            };
                        }
                    },
                    size: 'lg'
                });


                modalInstance.result.then(function (automobili) {
                    dataServices.salvaAuto(automobili, callback, error);

                }, function () {
                    console.log("modifica auto annullata");
                });

            };


            $scope.VisualizzaContrattiAuto = function (id) {
                $location.path('/listaContrattiAuto/' + id);
            };

        });

