angular.module('myBenefit')
        .controller('loginCtrl', function ($scope, dataServices, $location) {
            var callback = function (risposta) {
                if (risposta.status === false   ){
                     toastr.error('Credenziali errate')
                    
                    $location.path('/login');
                }
                else{
                    // ToASTR 
                    toastr.success('Benvenuto', 'Beneficium')

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
        
   
   toastr.options = {
  "closeButton": false,
  "debug": false,
  "newestOnTop": false,
  "progressBar": false,
  "positionClass": "toast-top-right",
  "preventDuplicates": false,
  "onclick": null,
  "showDuration": "300",
  "hideDuration": "1000",
  "timeOut": "5000",
  "extendedTimeOut": "1000",
  "showEasing": "swing",
  "hideEasing": "linear",
  "showMethod": "fadeIn",
  "hideMethod": "fadeOut"
}