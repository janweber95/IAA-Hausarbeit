app.controller('DefectDetailsController', function($scope, $http, $location, defectService) {

    var defectstatusUrl = '/defectstatus'
    $scope.defect = defectService.getDefect();

    var getData = function () {
        $http.get(defectstatusUrl)
            .then(function successCallback(response) {
                console.log(response);
                $scope.defectstatus = response.data;
            }), function errorCallback(data, status, header) {
            console.error(data, status, header);
        };
    };
    getData();


})