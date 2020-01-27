const App = angular.module("App", []);
const API_KEY = "374ee52243b4e80f43c32e0d6a417678";
let getMoviesURL = "https://api.themoviedb.org/3/discover/movie?api_key=" + API_KEY + "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1";
// var loginURL="";


App.controller("MainCtrl", function ($scope, $http) {
    angular.element(document).ready(async function () {
let accessToken=document.getElementById('accessToken').innerText;
console.log(accessToken);
        $http.get(getMoviesURL)
            .then((response) => {
                console.log(response.data);
                $scope.movies = response.data;
            })
            .catch((error) => {
                console.log(error);
            });

        // async function init() {
        //     const japanResponse = await fetch(  );
        // console.log(japanResponse);
        //     const japan = await japanResponse.json();
        //     return japan[0];
        // }
        //
        // init().then((res) => console.log(res));

        let req = {
            method: 'GET',
            url: 'http://localhost:8090/user/me',
            headers: {
                 'Content-Type': 'application/x-www-form-urlencoded',
                'Authorization':accessToken
            },

            // data: { title: 'test',img:'',vote:'',description:'' }
        };
        $http(req).then(function(data){console.log(data)}, function(){console.log("error")});



        $scope.MyListFunction=function(index){
            console.log(index);
        }

    })
});

