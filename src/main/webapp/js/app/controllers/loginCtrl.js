angular.module('myBenefit')
        .controller('loginCtrl', function ($scope, dataServices, $location) {
            var callback = function (risposta) {
                $location.path('/listadipendentijson');
            };

            var error = function (risposta) {
                alert("errore lato server");
            };

            $scope.login = function () {
                dataServices.login($scope.user, callback, error);

            };
        });
        



