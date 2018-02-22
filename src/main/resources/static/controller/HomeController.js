app.controller('HomeController', function($scope, $http) {

    var userUrl = '/defects';

    $http.get(userUrl)
        .then(function successCallback(data) {
            console.log(data);
            $scope.defects = data.data;
            console .log();
        }), function errorCallback(data, status , header) {
        console.error(data, status, header);
    }


})