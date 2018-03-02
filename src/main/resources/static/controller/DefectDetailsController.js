
/**
 * Defect Details Controller.
 *
 * @author Jan-Philipp Weber
 */
app.controller('DefectDetailsController', function($scope, $http, $location, defectService) {

    var defectstatusUrl = '/defectstatus'
    $scope.defect = defectService.getDefect();

    var getData = function () {
        $http.get(defectstatusUrl)
            .then(function successCallback(response) {
                $scope.defectstatus = response.data;
            }), function errorCallback(data, status, header) {
            console.error(data, status, header);
        };
    };
    getData();

    $scope.switchToHome = function () {
        $location.path("/home");
    }
});