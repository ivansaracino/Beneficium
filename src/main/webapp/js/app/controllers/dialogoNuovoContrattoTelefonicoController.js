angular.module('myBenefit')
        .controller('dialogoNuovoContrattoTelefonicoController', function ($modalInstance, $scope, dataServices, data) {

            var callback = function (contratticellulare) {
                $scope.contratticellulare = contratticellulare;
            };

            var error = function (risposta) {
                alert("errore lato server");
            };


            $scope.data = data;

            $scope.opened = false;

            $scope.open = function ($event) {
                $event.preventDefault();
                $event.stopPropagation();
                $scope.opened = true;
            };


            $scope.opened2 = false;

            $scope.open2 = function ($event) {
                $event.preventDefault();
                $event.stopPropagation();
                $scope.opened2 = true;
            };

            $scope.cancel = function () {
                $modalInstance.dismiss();
            };


            $scope.aggiungiContratto = function () {
                $modalInstance.close($scope.nuovoContratto);

            };
            $scope.modificaDatiCellulare = function () {

                $modalInstance.close($scope.data.cellulare);

            };

            $scope.modificaDatiCellulare = function () {

                $modalInstance.close($scope.data.cellulare);

            };
            
            
            $scope.modificaContrattoTelefonico = function () {

                $modalInstance.close($scope.data.contrattocellulare);

            };
            
        });



