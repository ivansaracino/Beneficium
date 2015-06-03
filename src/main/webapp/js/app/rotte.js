angular.module('myBenefit').config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
                .when('/login', {
                    templateUrl: 'partials/login.html',
                    controller: 'loginCtrl'
                }).
                when('/listadipendentijson', {
                    templateUrl: 'partials/listadipendenti.html',
                    controller: 'dipCtrl'
                }).
               when('/logout', {
                    templateUrl: 'partials/login.html',
                    controller: 'logoutController'
                }).
                otherwise({
                    redirectTo: '/login'
                });
    }


]);

