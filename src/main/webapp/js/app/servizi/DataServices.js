angular.module('myBenefit').factory('dataServices', function ($http) {
    var login = function (user, callback, error) {
        $http({data: user, method: 'POST', url: 'login.do'})
                .success(function (risposta, status, headers, config) {
                    callback(risposta)
                })
                .error(function (rispostastatus, headers, config) {
                    error(rispostastatus);
                });
    };
    var listadipendentijson = function (callback) {
        $http.get('listadipendentijson.do').success(function (dipendenti) {
            callback(dipendenti);
        });
    };
    
    var salva = function (dipendente, callback, error) {
        $http({data: dipendente, method: 'POST', url: 'inseriscidipendentejson.do'})
                .success(function (risposta, status, headers, config) {
                    callback(risposta)
                })
                .error(function (rispostastatus, headers, config) {
                    error(rispostastatus);
                });
    };
    
    
    return{
        login: login,
        listadipendentijson: listadipendentijson,
        salva: salva
    };
});

