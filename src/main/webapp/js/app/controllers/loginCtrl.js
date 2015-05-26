angular.module('myBenefit')
        .controller('loginCtrl', function ($scope, dataServices, $location) {
            var callback = function (risposta) {
                if (risposta.status === true)
                    $location.path('/listadipendentijson');
                else
                    // ToASTR 
                    $location.path('/login'); 
            };

            var error = function (risposta) {
                alert("errore lato server");
            };

            $scope.login = function () {
                dataServices.login($scope.user, callback, error);

            };
        });
        



