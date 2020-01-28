const App = angular.module("App", []);
const API_KEY = "374ee52243b4e80f43c32e0d6a417678";


let buttons =[];
App.controller("MainCtrl", function ($scope, $http) {
    angular.element(document).ready(async function () {
        let page=document.getElementById('page').innerText;
        let getMoviesURL = "https://api.themoviedb.org/3/discover/movie?api_key=" + API_KEY +
            "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page="+page;
        const username=document.getElementById('username');
        let accessToken=localStorage.getItem("accessToken");
        $scope.page=page;

        $http.get(getMoviesURL)
            .then((response) => {
                console.log(response.data);
                $scope.movies = response.data;
                $scope.page=response.data.page;
                for (let i = 0; i < response.data.results.length; i++) {
                    let  button={};
                    button[i] = new Button(response.data.results[i].id);
                    buttons.push(button[i]);
                }
            })
            .catch((error) => {
                console.log(error);
            });


        $scope.MyListFunction=function(id,index) {

            let title = document.getElementById('movieTitle' + index).innerHTML;
            let movieId = document.getElementById('movieId' + index).innerHTML;
            let vote = document.getElementById('vote' + index).innerHTML;
            let movieOverview = document.getElementById('movieOverview' + index).innerHTML;
            let movieImg = document.getElementById('movieImg' + index).src;

            if (accessToken !== "" && username!==null) {
                let req = {
                    method: 'POST',
                    url: 'http://localhost:8090/movie/add',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': accessToken
                    },
                    data: {movieId:movieId,title: title, img: movieImg, vote: vote, description: movieOverview}
                };
                $http(req).then(function (data) {
                        console.log(data.data)
                    movieAdded(id,index);
                    },
                    function (error) {
                        console.log(error)
                    });

            }else{alert("You have to be logged in")}
        }
    });


});

function movieAdded(id,index){

    let movieButton=document.getElementById('movieButton'+index);


    for(let button of buttons){
        if(button.id===id){
            if(button.clicked===false){
                movieButton.innerText="Added to List";
                movieButton.className='glyphicon glyphicon-pushpin btn input-block-level btn-success w-100';
                button.clicked=true;
            }else{
                movieButton.innerText="Add to List";
                movieButton.className='glyphicon glyphicon-pushpin btn input-block-level btn-danger w-100';
                button.clicked=false;
            }
        }
    }


}


let Button = function(id) {
    this.id = id;
    // this.innerText = innerText;
    // this.backgroundColor=backgroundColor;
    // this.border=border;
    this.clicked=false;
};