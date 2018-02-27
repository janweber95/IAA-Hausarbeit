angular.module('service.storage', [])
    .factory('storage', function () {
        var recentUser = {};

        var get = function () {
            return recentUser;
        };

        var set = function (user) {
            recentUser = user;
            console.log(user);
        };

        var remove = function () {
            recentUser = {};
        };

        // Reveal public API.
        return {
            getuser: get,
            setUser: set,
            removeUser: remove
        };
    });