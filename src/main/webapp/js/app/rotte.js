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


                when('/inseriscidipendentejson', {
                    templateUrl: 'partials/nuovo-dipendente.html',
                    controller: 'dipCtrl'
                }).
               

               when('/inseriscicontrattojson', {
                    templateUrl: 'partials/listadipendenti.html',
                    controller: 'dialogoNuovoContrattoTelefonicoController'
                }).
                
                when('/salvacontratto', {
                    templateUrl: 'partials/nuovoContrattoAuto.html',
                    controller: 'dialogoNuovoContrattoAutoController'
                }).
                     
               
                when('/listaauto/:codiceFiscale', {
                    templateUrl: 'partials/listaAuto.html',
                    controller: 'listaAutoController'
                }).
                        
                otherwise({
                    redirectTo: '/login'
                });
    }


]);

