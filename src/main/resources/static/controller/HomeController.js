app.controller('HomeController', function($scope, $http, $location) {

    var defectsUrl = '/defects';
    var excludeClosed = false;

    var getData = function (excludeClosed) {
        $http.get(defectsUrl,{params:{excludeclosed: excludeClosed}})
            .then(function successCallback(response) {
                console.log(response);
                $scope.defects = response.data;
            }), function errorCallback(data, status, header) {
            console.error(data, status, header);
        }
    }
    getData(excludeClosed);

    $scope.createDefect = function () {
        $location.path( '/ticket' );
    }

    $scope.hideClosedDefects = function () {
        getData(true);
    }


})