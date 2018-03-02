
    var app = angular.module("myApp", ["ngRoute", "datatables", "service.user", "service.defect", "service.defect"]);
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
            .when("/defect", {
                templateUrl : "View/defect.html",
                controller : "DefectController"
            }).when("/defectdetails", {
            templateUrl : "View/defectdetails.html",
            controller : "DefectDetailsController"
            }).when("/registration", {
            templateUrl : "View/registration.html",
            controller : "RegistrationController"
            }).otherwise({
            redirectTo: "/"
        });
    });