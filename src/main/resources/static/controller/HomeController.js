app.controller('HomeController', function($scope, $http, $location) {

    var defectsUrl = '/defects';
    var advancedDefectsUrl = '';

    $http.get(defectsUrl)
        .then(function successCallback(data) {
            console.log(data);
            $scope.defects = data.data;
            console .log();
        }), function errorCallback(data, status , header) {
        console.error(data, status, header);
    }

    $scope.createDefect = function () {
        $location.path( '/ticket' );
    }

    $scope.hideClosedDefects = function () {

    }


})