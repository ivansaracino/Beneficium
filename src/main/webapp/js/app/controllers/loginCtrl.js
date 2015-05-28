angular.module('myBenefit')
        .controller('loginCtrl', function ($scope, dataServices, $location) {
            var callback = function (risposta) {
                if (risposta.status === false){
                    
                    toastr.error('Credenziali errate', 'Beneficium');
                    $location.path('/login');
                }
                else{
                    toastr.success('Benvenuto', 'Beneficium');
                    $location.path('/listadipendentijson'); 
                }
            };

            var error = function (risposta) {
                alert("errore lato server");
            };

            $scope.login = function () {
                dataServices.login($scope.user, callback, error);

            };
        });
        
   
   