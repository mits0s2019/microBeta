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


// if(accessToken!=="") {
//     let req = {
//         method: 'GET',
//         url: 'http://localhost:8090/user/me',
//         headers: {
//             'Content-Type': 'application/x-www-form-urlencoded',
//             'Authorization': accessToken
//         },
//         // data: { title: 'test',img:'',vote:'',description:'' }
//     };
//     $http(req).then(function (data) {
//             console.log(data.data)
//         },
//         function () {
//             console.log("Not Logged in user")
//         });
// }


        $scope.MyListFunction=function(index) {

            let title = document.getElementById('movieTitle' + index).innerHTML;
            let vote = document.getElementById('vote' + index).innerHTML;
            let movieOverview = document.getElementById('movieOverview' + index).innerHTML;
            let movieImg = document.getElementById('movieImg' + index).src;

            if (accessToken !== "") {
                let req = {
                    method: 'POST',
                    url: 'http://localhost:8090/movie/add',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': accessToken
                    },
                    data: {title: title, img: movieImg, vote: vote, description: movieOverview}
                };
                $http(req).then(function (data) {
                        console.log(data.data)
                    },
                    function () {
                        console.log("Not Logged in user")
                    });

            }
        }
    })

});

