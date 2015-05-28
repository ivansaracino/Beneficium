angular.module('myBenefit')
        .controller('logoutController', function ($scope, dataServices, $location) {
//            
//            var callback = function (risposta) {
//                if (risposta.status === true) {
//                    toastr.success('Logout eseguito');
//                    $location.path('/login');
//                }
//                else {
//                    // ToASTR 
//                    toastr.error('attenzione! La sessione non si è chiusa correttamente, riprovare')
//
//                    $location.path('/listadipendentijson');
//                }
//            };
//
//            $scope.logout = function () {
//                dataServices.login($scope.user, callback);
//
//            };


            $scope.logout = function () {
                dataServices.login($scope.user);
                $location.path('/login');
                toastr.success('Logout eseguito');

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


