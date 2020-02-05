const clientURL = window.location.protocol + "//" + window.location.host + "/MyMovies/";6
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
                $('#search-input-id').val(ui.item.id);
                $('#search-input-media-type').val(ui.item.media_type);
                let url=clientURL+"search?id="+id+"&media_type="+ui.item.media_type;
                if(id!==null && id!==undefined && ui.item.media_type!==null && ui.item.media_type!==undefined) {
                    window.location.href = url;
                }else{
                    alert("Something gone wrong");
                }


                return false;
            }
        }).autocomplete("instance")._renderItem = function(ul, item) {

            if(item.title!=undefined && item.title!=null && item.poster_path!=undefined && item.poster_path!=null) {
                var row = $('<div class="image p-1"><img class="auto-movie-pic" src="' + "https://image.tmdb.org/t/p/w500" + item.poster_path + '">' +
                    '<span>  ' + item.title + ' </span>'+'<span style="    color: rgba(0,0,0,0.4)">' + item.media_type + '</span></div>')
                return $("<li>").append(row).appendTo(ul);
            }
            else if(item.name!=undefined && item.name!=null && item.poster_path!=undefined && item.poster_path!=null) {
                var row = $('<div class="image p-1"><img class="auto-movie-pic" src="' + "https://image.tmdb.org/t/p/w500" + item.poster_path + '">' +
                    '<span>  ' + item.name + ' </span>'+'<span style="    color: rgba(0,0,0,0.4)">' + item.media_type + '</span></div>')
                return $("<li>").append(row).appendTo(ul);
            }
            else{
                return $("<li>");
            }
        };

        });







});