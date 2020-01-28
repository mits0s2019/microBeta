const App = angular.module("App", []);


App.controller("MainCtrl", function ($scope, $http) {
    angular.element(document).ready(async function () {


let accessToken=document.getElementById('accessToken').innerText;
localStorage.setItem("accessToken", accessToken);



});

});