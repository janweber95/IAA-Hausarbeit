app.controller('RegistrationController', function($scope, $http,$location) {

    var userDataUrl = '/users/login';

    $scope.checkUserData = function() {
        $http.post(userDataUrl, angular.toJson($scope.user))
            .then(function successCallback(response) {
                console.log(response);
                userStorage.setUser(response.data);
                this.switchToLogin();
            }, function errorCallback(data, status , header) {
            console.error(data, status, header);
            alert("Hoppla, bitte kontrollieren Sie Ihre Eingaben und versuchen Sie es erneut!")
        })
    };

    $scope.switchToLogin = function () {
        $location.path("/login");
    };

});