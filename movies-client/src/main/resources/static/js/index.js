const App = angular.module("App", []);
const API_KEY = "374ee52243b4e80f43c32e0d6a417678";
let getMoviesURL = "https://api.themoviedb.org/3/discover/movie?api_key=" + API_KEY + "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1";
App.controller("MainCtrl", function ($scope, $http) {
    angular.element(document).ready(async function () {

        $http.get(getMoviesURL)
            .then((response) => {
                console.log(response.data);
                $scope.movies = response.data;
            })
            .catch((error) => {
                console.log(error);
            });


        // var req = {
        //     method: 'POST',
        //     url: 'http://localhost:8090/movies-service/movie',
        //     headers: {
        //         'Content-Type': "application/json"
        //     },
        //     data: { title: 'test',img:'',vote:'',description:'' }
        // };
        // $http(req).then(function(data){console.log(data)}, function(){console.log("error")});
        //




    })
});