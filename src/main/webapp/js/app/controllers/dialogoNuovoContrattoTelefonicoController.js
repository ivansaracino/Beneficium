angular.module('myBenefit')
        .controller('dialogoNuovoContrattoTelefonicoController', function ($modalInstance, $scope, dataServices, data) {
            $scope.data = data;
    

            $scope.cancel = function () {
                $modalInstance.dismiss();
            };
            

            $scope.aggiungiContratto = function () {
               $modalInstance.close($scope.nuovoContratto);

            };

        });



