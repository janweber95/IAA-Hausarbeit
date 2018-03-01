app.controller('LoginController', function($scope, $http,$location, userStorage) {

    var userDataUrl = '/users/login';

    var switchToHome = function () {
        $location.path( '/home' );
    };

    $scope.checkUserData = function() {
        $http.post(userDataUrl, angular.toJson($scope.user))
            .then(function successCallback(response) {
                console.log(response);
                userStorage.setUser(response.data);
                switchToHome();
            }, function errorCallback(data, status , header) {
            console.error(data, status, header);
            alert("Benutzername oder Passwort falsch. Bitte versuchen Sie es erneut!")
        })
    };

    $scope.createUser = function () {
        $location.path("/registration");
    };

});