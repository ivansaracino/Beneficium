angular.module('myBenefit')
        .controller('dipCtrl',function($scope,dataServices){
            var callback = function(dipendenti){
                        $scope.dipendenti = dipendenti;
                    };
                    dataServices.listadipendentijson(callback);
        });

