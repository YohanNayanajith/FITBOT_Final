function instructorRating(instructor_id){

    $.ajax({
        method:'POST',
        url:"instructorGetRating",
        data:{instructor_id:instructor_id},
        dataType:'json',
        // contentType:"application/json",
    }).done(function(result){
        console.log(result);
        if(result.toString().trim() == "1"){
            //null
            /* 1. Visualizing things on Hover - See next part for action on click */
            $('#stars li').on('mouseover', function(){
                var onStar = parseInt($(this).data('value'), 10); // The star currently mouse on

                // Now highlight all the stars that's not after the current hovered star
                $(this).parent().children('li.star').each(function(e){
                    if (e < onStar) {
                        $(this).addClass('hover');
                    }
                    else {
                        $(this).removeClass('hover');
                    }
                });

            }).on('mouseout', function(){
                $(this).parent().children('li.star').each(function(e){
                    $(this).removeClass('hover');
                });
            });


            /* 2. Action to perform on click */
            $('#stars li').on('click', function(){
                var onStar = parseInt($(this).data('value'), 10); // The star currently selected
                var stars = $(this).parent().children('li.star');

                for (i = 0; i < stars.length; i++) {
                    $(stars[i]).removeClass('selected');
                }

                for (i = 0; i < onStar; i++) {
                    $(stars[i]).addClass('selected');
                }

                // JUST RESPONSE (Not needed)
                var ratingValue = parseInt($('#stars li.selected').last().data('value'), 10);
                var msg = "";
                console.log(ratingValue);
                if (ratingValue > 1) {
                    msg = "Thanks! You rated this " + ratingValue + " stars.";
                }
                else {
                    msg = "We will improve ourselves. You rated this " + ratingValue + " stars.";
                }
                ratingInsert(instructor_id,ratingValue);
                responseMessage(msg);

            });

        }else{
            // $('#stars li').on('load', function(){
            //     alert("meka vadada");
                let onStar = parseInt(result["rating"]);
                // let onStar = parseInt($(this).data('value'), 10); // The star currently selected
                let stars = $('#stars li').parent().children('li.star');
                // let stars = $(this).parent().children('li.star');

                for (i = 0; i < stars.length; i++) {
                    $(stars[i]).removeClass('selected');
                }

                for (i = 0; i < onStar; i++) {
                    $(stars[i]).addClass('selected');
                }

                // JUST RESPONSE (Not needed)
                var ratingValue = parseInt($('#stars li.selected').last().data('value'), 10);
                var msg = "";
                console.log(ratingValue);
                if (ratingValue > 1) {
                    msg = "Thanks! You rated this " + ratingValue + " stars.";
                }
                else {
                    msg = "We will improve ourselves. You rated this " + ratingValue + " stars.";
                }
                responseMessage(msg);

            // });
        }

    }).fail(function(a,b,err){
        console.log(a,b,err);
    });

}

function responseMessage(msg) {
    $('.success-box').fadeIn(200);
    $('.success-box div.text-message').html("<span>" + msg + "</span>");
}

function ratingInsert(instructor_id,rating){
    $.ajax({
        method:'POST',
        url:"instructorRating",
        data:{instructor_id:instructor_id,rating:rating},
        // dataType:'json',
        // contentType:"application/json",
    }).done(function(result){
        console.log(result);
        if(result.toString().trim() == "1"){
            console.log("Rating is added");
        }else{
            console.log("Rating is not added");
        }
    }).fail(function(a,b,err){
        console.log(a,b,err);
    });
}
// function ratingGet(instructor_id){
//     $.ajax({
//         method:'POST',
//         url:"instructorGetRating",
//         data:{instructor_id:instructor_id},
//         dataType:'json',
//         // contentType:"application/json",
//     }).done(function(result){
//         console.log(result);
//
//     }).fail(function(a,b,err){
//         console.log(a,b,err);
//     });
// }