
$(document).ready(function () {
    $(".autocomplete").keyup(function () {
        const movie = $(this).val().trim();
        let url="https://api.themoviedb.org/3/search/multi?api_key=374ee52243b4e80f43c32e0d6a417678&language=en-US&query="+movie+"&page=1&include_adult=false";

        $(this).autocomplete({
            source: function (request, response) {
                $.ajax({
                    url: url,
                    data: {query: request.term},
                    success: function (data) {
                       response(data.results);
                    }
                });
            }
            ,
            autoFocus: true,
            minLength: 2,
            select: function(event, ui) {
                $("#search-input").val(ui.item.title);
                let id=ui.item.id;
                let url="http://localhost:8080/MyMovies/movie?id="+id;

                

                return false;
            }
        }).autocomplete("instance")._renderItem = function(ul, item) {
            if(item.title!=undefined && item.title!=null && item.poster_path!=undefined && item.poster_path!=null) {
                var row = $('<div class="image"><img class="auto-movie-pic" src="' + "https://image.tmdb.org/t/p/w500" + item.poster_path + '"><span>  ' + item.title + ' </span></div>')
                return $("<li>").append(row).appendTo(ul);
            }else{
                return $("<li>");
            }
        };

        });







});