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




    $scope.MyListFunction=function() {

        if (accessToken !== "" && mediaType==="movie") {
            let movieTitle = document.getElementById('movie-title').innerHTML;
            let movieOverview = document.getElementById('movie-overview').innerHTML;
            let moviePoster = document.getElementById('movie-poster').src;

            let req = {
                method: 'POST',
                url: 'http://localhost:8090/movie/add',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': accessToken
                },
                data: {movieId: id, title: movieTitle, img: moviePoster, vote: null, description: movieOverview}
            };
            $http(req).then(function (data) {
                    console.log(data.data)
                    movieAdded(id);
                },
                function (error) {
                    console.log(error)
                });
        }else if(accessToken !== "" && mediaType==="tv") {

            let tvTitle = document.getElementById('tv-title').innerHTML;
            let tvOverview = document.getElementById('tv-overview').innerHTML;
            let tvPoster = document.getElementById('tv-poster').src;

            let req = {
                method: 'POST',
                url: 'http://localhost:8090/tv-series/add',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': accessToken
                },
                data: {tvId: id, title: tvTitle, img: tvPoster, vote: null, description: tvOverview}
            };
            $http(req).then(function (data) {
                    console.log(data.data)
                    movieAdded(id);
                },
                function (error) {
                    console.log(error)
                });

        }else{alert("You have to be logged in")}
    }

    });
});


function movieAdded(id){

    let button_id=document.getElementById('button-id');
    let btnObj=new Button(id);
            if(btnObj.clicked===false){
                button_id.innerText="Added to List";
                button_id.className='glyphicon glyphicon-pushpin btn input-block-level btn-success w-100';
                btnObj.clicked=true;
            }else{
                button_id.innerText="Add to List";
                button_id.className='glyphicon glyphicon-pushpin btn input-block-level btn-danger w-100';
                btnObj.clicked=false;
            }




}


let Button = function(id) {
    this.id = id;
    this.clicked=false;
};