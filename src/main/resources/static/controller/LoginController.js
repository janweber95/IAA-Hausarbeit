app.controller('LoginController', function($scope, $http,$location, storage) {

    var userDataUrl = '/users/login';
    var user = {};

    $scope.checkUserDetails = function() {
            user = {
                "username": $scope.username,
                "password": $scope.password
            }
        checkUser();
    };

    var checkUser = function() {
        $http.post(userDataUrl, user)
            .then(function successCallback(response) {
                console.log(response);
                storage.setUser(response.data);
                switchToHome();
            }), function errorCallback(data, status , header) {
            console.error(data, status, header);
            alert("Benutzername oder Passwort wurde falsch eingegeben. Bitte versuchen Sie es erneut!")
        }
    }

    var switchToHome = function () {
            $location.path( '/home' );
        };
});