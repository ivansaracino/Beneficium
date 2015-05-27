angular.module('myBenefit')
        .controller('dialogoNuovoDipendenteController',function($modalInstance,$scope,data){
            $scope.data = data;
    
            $scope.save = function() {

                $modalInstance.close($scope.dipendente);
               

            };
            
            $scope.cancel = function() {
              $modalInstance.dismiss();  
            };
           
           

        });


