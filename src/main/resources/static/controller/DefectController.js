/**
 * Defect Controller.
 *
 * @author Jan-Philipp Weber
 */
app.controller('DefectController', function($scope, $http, $location, userService) {

    var defectsUrl = '/defects';
    $scope.defect = {};
    $scope.defect.creator = userService.getuser();

    $scope.createDefect = function () {
        angular.toJson($scope.defect);
        $http.post(defectsUrl, $scope.defect)
            .then(function successCallback(response) {
              alert("Das Ticket wurde erfolgreich angelegt!");
              $scope.switchToHome();
            }, function errorCallback (data, status, header) {
                console.log(data, status, header);
                alert("Das Ticket konnte nicht angelegt werden. Bitte kontrollieren Sie ihre Eingaben!")
            })
    };

    $scope.switchToHome = function () {
        $location.path("/home");
    };
});