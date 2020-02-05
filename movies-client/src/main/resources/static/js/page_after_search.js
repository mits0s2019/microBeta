const App = angular.module("App", []);
const API_KEY = "374ee52243b4e80f43c32e0d6a417678";


App.controller("MainCtrl", function ($scope, $http) {
    angular.element(document).ready(async function () {
        let accessToken=localStorage.getItem("accessToken");
        let id=document.getElementById('id').innerText.trim();
        let mediaType=document.getElementById('mediaType').innerText;
        let searchMovieURL="https://api.themoviedb.org/3/movie/"+id+"?api_key="+API_KEY+"&language=en-US";
        let searchTvURL="https://api.themoviedb.org/3/tv/"+id+"?api_key="+API_KEY+"&language=en-US";

        console.log(id+" "+mediaType);
    if(id!=="" && mediaType!=="") {
        if(mediaType==="movie"){

            $http.get(searchMovieURL)
                .then((response) => {
                    console.log(response.data);
                     $scope.movie = response.data;

                })
                .catch((error) => {
                    console.log(error);
                });

        }else if(mediaType==="tv"){
            $http.get(searchTvURL)
                .then((response) => {
                    console.log(response.data);
                    $scope.tv = response.data;

                })
                .catch((error) => {
                    console.log(error);
                });
        }
    }

    });
});


