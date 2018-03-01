app.controller('DefectController', function($scope, $http, $location, userStorage) {

    var defectsUrl = '/defects';
    var recentUser = userStorage.getuser();
    $scope.defect = {};

    $scope.defect.creator = recentUser;

    $scope.createDefect = function () {
        angular.toJson($scope.defect);
        console.log($scope.defect);
        $http.post(defectsUrl, $scope.defect)
            .then(function successCallback(response) {
              alert("Das Ticket wurde erfolgreich angelegt!");
              switchToHome();
            }, function errorCallback (data, status, header) {
                console.log(data, status, header);
                alert("Das Ticket konnte nicht angelegt werden. Bitte kontrollieren Sie ihre Eingaben!")
            })
    };

    $scope.switchToHome = function () {
        $location.path("/home")
    };

})