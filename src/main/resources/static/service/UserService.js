angular.module('service.storage', [])
    .factory('userStorage', function () {
        var recentUser = null;

        var get = function () {
            return recentUser;
        };

        var set = function (user) {
            recentUser = user;
            console.log(user);
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