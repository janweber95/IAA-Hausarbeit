angular.module('service.user', [])
    .factory('userService', function () {
        var recentUser = null;

        var get = function () {
            return recentUser;
        };

        var set = function (user) {
            recentUser = user;
        };

        var remove = function () {
            recentUser = null;
        };

        // Reveal public API.
        return {
            getuser: get,
            setUser: set,
            removeUser: remove
        };
    });