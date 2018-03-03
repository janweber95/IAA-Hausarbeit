
/**
 * Defect Change Controller.
 *
 * @author Jan-Philipp Weber
 */
app.controller('DefectChangeController', function($scope, $http, $location, defectService,userService, defectStatusService) {
    var defectChangeUrl = '/defects/';
    $scope.defect = defectService.getDefect();
    $scope.defectChange = {};
    $scope.changeStatus = defectStatusService.getDefectStatus();
    $scope.defectChange.user = userService.getuser();
    $scope.defectChange.previousStatus = $scope.defect.status;
    +new Date;

    $scope.switchToDetail = function () {
        $location.path("/defectdetail");
    };
    
    $scope.changeDefect = function (status) {
        $scope.defectChange.newStatus = status;
        $scope.defectChange.changeTime = Date.now();
        $http.post(defectChangeUrl+$scope.defect.id, angular.toJson($scope.defectChange))
            .then(function successCallback(response) {
                alert("Die Änderung wurde erfolgreich durchgeführt")
                switchToDetail();
            }, function errorCallback(data, status , header) {
                console.error(data, status, header);
                alert("Hoppla, bitte kontrollieren Sie Ihre Eingaben und versuchen Sie es erneut!")
            })
    };
});