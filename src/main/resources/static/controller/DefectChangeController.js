
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
    $scope.defectChange.editor = userService.getuser();
    $scope.defectChange.previousStatus = $scope.defect.status;

    $scope.switchToDetail = function () {
        $location.path("/defectdetails");
    };
    
    $scope.changeDefect = function (status) {
        $scope.defectChange.newStatus = status;
        $http.post(defectChangeUrl+$scope.defect.id, angular.toJson($scope.defectChange))
            .then(function successCallback(response) {
                alert("Ticket erfolgreich bearbeitet");
                switchToHome();
            }, function errorCallback(data, status , header) {
                console.error(data, status, header);
                alert("Hoppla, bitte kontrollieren Sie Ihre Eingaben und versuchen Sie es erneut!");
            })
    };

    var switchToHome = function () {
        $location.path("/home");
    };
});