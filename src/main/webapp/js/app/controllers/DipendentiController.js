/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('dipendentiController')
        .controller('dipCtrl',function($scope,$http){
            $http.get('listadipendentijson.do').success(function(dipendenti){
                $scope.dipendenti = dipendenti;
            });
        });
