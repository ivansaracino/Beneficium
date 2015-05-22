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
    return{
        login: login,
        listadipendentijson: listadipendentijson
    };
});