
/**
 * Defect Change Controller.
 *
 * @author Jan-Philipp Weber
 */
app.controller('DefectChangeController', function($scope, $http, $location, defectService,userService, defectStatusService) {

    $scope.defectChanges = defectService.getDefect();
    $scope.changeStatus = defectStatusService.getDefectStatus();

    $scope.switchToDetail = function () {
        $location.path("/defectdetail");
    };
    
    $scope.changeDefect = function () {

    }
});