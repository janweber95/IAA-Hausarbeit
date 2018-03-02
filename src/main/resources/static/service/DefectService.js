angular.module('service.defect', [])
    .factory('defectService', function () {
        var recentDefect = {};

        var get = function () {
            return recentDefect;
        };

        var set = function (defect) {
            recentDefect = defect;
            console.log(defect);
        };

        var remove = function () {
            recentDefect = null;
        };

        // Reveal public API.
        return {
            getDefect: get,
            setDefect: set,
            removeDefect: remove
        };
    });