app.controller('LoginController', function($scope, $http,$location) {

    var userDataUrl = '/users';
    var data = {};

    $scope.checkUserDetails = function() {
        data = {
            "user" : {
                "name": $scope.username,
                "password": $scope.password
            }
        };
        console.log(data);
        checkUser();
    };

    var checkUser = function() {
        $http.post(userDataUrl, data)
            .then(function successCallback(data) {
                console.log(data);
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