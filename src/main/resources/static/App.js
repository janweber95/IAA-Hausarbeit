
    var app = angular.module("myApp", ["ngRoute", "datatables"]);
    app.config(function($routeProvider) {
        $routeProvider
            .when("/", {
                templateUrl : "View/login.html",
                controller : "LoginController"
            })
            .when("/home", {
                templateUrl : "View/home.html",
                controller : "HomeController"
            })
            .when("/ticket", {
                templateUrl : "View/ticket.html",
                controller : "TicketController"
            }).otherwise({
            redirectTo: "/"
        });
    });