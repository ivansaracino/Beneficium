angular.module('myBenefit')
        .controller('dialogoNuovoContrattoAutoController', function ($modalInstance, $scope, dataServices, data) {
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
                $modalInstance.close($scope.contrattoAuto);

            };

        });



