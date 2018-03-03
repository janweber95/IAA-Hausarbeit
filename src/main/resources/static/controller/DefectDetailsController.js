
/**
 * Defect Details Controller.
 *
 * @author Jan-Philipp Weber
 */
app.controller('DefectDetailsController', function($scope, $http, $location, defectService,userService, defectStatusService) {

    $scope.defect = defectService.getDefect();
    $scope.previousChanges = $scope.defect.changes;
    $scope.closeDefect = false;
    $scope.openDefect = false;
    $scope.reopenDefect = false;
    var recentUser = userService.getuser();

    var checkDataForActions = function () {
        if($scope.defect.status === "CREATED" || $scope.defect.status === "REOPENED") {
            $scope.openDefect = true;
        }
        if (recentUser === $scope.previousChanges.editor && $scope.previousChanges.status === "IN_PROCESS") {
            $scope.closeDefect = true;
        }
        if (($scope.defect.status === "RESOLVED" ||$scope.defect.status === "REJECTED") && JSON.stringify($scope.defect.creator) === JSON.stringify(recentUser)){
            $scope.reopenDefect = true;
        }
    };
    checkDataForActions();

    $scope.editDefect = function (changestatus) {
        defectStatusService.setDefectStatus(changestatus);
        $location.path("/defectchange");
    };

    var setBooleans = function () {
        $scope.openDefect = false;
        $scope.closeDefect = false;
        $scope.reopenDefect = false;
    };

    $scope.switchToHome = function () {
        $location.path("/home");
        defectService.removeDefect();
        setBooleans();
    };
});