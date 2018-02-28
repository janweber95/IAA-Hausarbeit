app.controller('TicketController', function($scope, $http, $location, storage) {

    var defectsUrl = '/defects';
    var recentUser = storage.getuser();
    $scope.defect = {};

    $scope.defect.creator = recentUser;

    $scope.createDefect = function () {
        angular.toJson($scope.defect);
        console.log($scope.defect);
        $http.post(defectsUrl, $scope.defect)
            .then(function successCallback(response) {
              alert("Das Ticket wurde erfolgreich angelegt!")
            }, function errorCallback (data, status, header) {
                console.log(data, status, header);
            })
        $location.path("/home");
    }

})