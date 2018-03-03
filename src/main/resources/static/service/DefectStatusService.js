angular.module('service.defectStatus', [])
    .factory('defectStatusService', function () {
        var statusChange = '';

        var get = function () {
            return statusChange;
        };

        var set = function (status) {
            statusChange = status;
        };

        var remove = function () {
            statusChange = {};
        };

        // Reveal public API.
        return {
            getDefectStatus: get,
            setDefectStatus: set,
            removeDefectStatus: remove
        };
    });