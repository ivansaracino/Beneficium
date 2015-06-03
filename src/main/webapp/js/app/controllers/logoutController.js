angular.module('myBenefit')
        .controller('logoutController', function ($scope, dataServices, $location) {
            var callback = function (diplogout) {
               {
                     toastr.success('Sei disconnesso')
                    
                    $location.path('/login');
                }
               
            };

            var error = function (risposta) {
                alert("errore lato server");
            };

            $scope.logout = function () {
                dataServices.logout(callback);

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


