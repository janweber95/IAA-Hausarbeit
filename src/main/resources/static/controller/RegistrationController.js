
/**
 * Registration Controller.
 *
 * @author Jan-Philipp Weber
 */
app.controller('RegistrationController', function($scope, $http,$location, userService) {

    var userDataUrl = '/users';

    $scope.createUser = function() {
        $http.post(userDataUrl, angular.toJson($scope.user))
            .then(function successCallback(response) {
                userService.setUser(response.data);
                $scope.switchToLogin();
                alert("Benutzer wurde erfolgreich angelegt");
            }, function errorCallback(data, status , header) {
            console.error(data, status, header);
            alert("Benutzername oder E-Mail existiert bereits!")
        })
    };

    $scope.switchToLogin = function () {
        $location.path("/login");
    };
});