
const App = angular.module("App", []);
const API_KEY = "374ee52243b4e80f43c32e0d6a417678";

let buttons =[];
App.controller("MainCtrl", function ($scope, $http) {
    angular.element(document).ready(async function () {
        let page=document.getElementById('page').innerText;
        const username=document.getElementById('username');
        let accessToken=localStorage.getItem("accessToken");
        $scope.page=page;
        let tvURL="https://api.themoviedb.org/3/discover/tv?api_key="+API_KEY+
            "&language=en-US&sort_by=popularity.desc&page="+page+"&timezone=America%2FNew_York&include_null_first_air_dates=false";

        $http.get(tvURL)
            .then((response) => {
                console.log(response.data);
                $scope.tv = response.data;
                for (let i = 0; i < response.data.results.length; i++) {
                    let  button={};
                    button[i] = new Button(response.data.results[i].id);
                    buttons.push(button[i]);
                }
            })
            .catch((error) => {
                console.log(error);
            });

    });

});



let Button = function(id) {
    this.id = id;
    this.clicked=false;
};