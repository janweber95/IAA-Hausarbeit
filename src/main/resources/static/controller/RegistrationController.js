
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
                switchToLogin();
            }, function errorCallback(data, status , header) {
            console.error(data, status, header);
            alert("Hoppla, bitte kontrollieren Sie Ihre Eingaben und versuchen Sie es erneut!")
        })
    };

    var switchToLogin = function () {
        $location.path("/login");
    };
});