app.controller('LoginController', function($scope, $http) {

    var userDataUrl = 'http://localhost:8080/users';
    var data = {};

    $scope.checkUserDetails = function() {
        data = {
            name: $scope.username,
            password: $scope.password
        }
        console.log(data)
        checkUser();
    }

    var checkUser = function() {
        $http.post(userDataUrl, data)
            .then(function successCallback(data) {
                console.log(data);
            }), function errorCallback(data, status , header) {
            console.error(data, status, header);
        }
    }

})