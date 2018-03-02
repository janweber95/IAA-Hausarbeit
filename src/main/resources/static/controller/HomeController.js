app.controller('HomeController', function($scope, $http, $location, defectService) {

    var defectsUrl = '/defects';
    $scope.excludeClosed = false;

    var getData = function (excludeClosed) {
        $http.get(defectsUrl,{params:{excludeclosed: excludeClosed}})
            .then(function successCallback(response) {
                console.log(response);
                $scope.defects = response.data;
            }), function errorCallback(data, status, header) {
            console.error(data, status, header);
        };
    };
    getData($scope.excludeClosed);

    $scope.createDefect = function () {
        $location.path( '/defect' );
    };

    $scope.hideClosedDefects = function () {
        $scope.excludeClosed = true;
        getData(true);
    };

    $scope.showClosedDefects = function () {
        $scope.excludeClosed = false
        getData(false);
    };

    $scope.switchToDetails = function (defect) {
        defectService.setDefect(defect);
        $location.path('/defectdetails')
    };


})