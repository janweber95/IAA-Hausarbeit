
    var app = angular.module("myApp", ["ngRoute", "datatables", "service.user", "service.defect", "service.defectStatus"]);
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
            }).when("/defectchange", {
            templateUrl : "View/defectchange.html",
            controller : "DefectChangeController"
            }).otherwise({
            redirectTo: "/"
        });
    });