function manager_notices_page() {
    let anchor_notice = document.getElementById("man_notice");
    let anchor_notice_i = document.getElementById("man_notice_i");
    let notice_text = document.getElementById("manager_notices_page_text");
    console.log("mokada meee dashboard");
    anchor_notice.style.backgroundColor = "white";
    anchor_notice_i.style.color = "black";
    notice_text.style.color = "black";
  }


function add_notice_popup(){
    $('#add_notice_container').show();
}

function close_add_notice_Popup(){
    $('#add_notice_container').hide();
    $('#maintainer_notice_form input[type="text"],input[type="date"], textarea').val('');
}



function submitNoticeForm(){

    let title = $('#title').val();
    let dates = $('#dates').val();
    let description = $('#description').val();

    let title_error = false;
    let dates_error = false;
    let description_error = false;

    //notice title
    if (title.length == ""){
        $("#validation_noticetitle_id").show();
        title_error = true;
    }
    else {
        $("#validation_noticetitle_id").hide();
    }

    //notice date
    if (dates.length == ""){
        $("#validation_noticedate_id").show();
        dates_error = true;
    }
    else {
        $("#validation_noticedate_id").hide();
    }

    //notice description
    if (description.length == ""){
        $("#validation_noticedescription_id").show();
        description_error = true;
    }
    else {
        $("#validation_noticedescription_id").hide();
    }


    //full validation
    if(title_error == true || dates_error == true || description_error == true){
        return false;
    }

    console.log(title);
    console.log(dates);
    console.log(description);

    $.ajax({
        method: 'POST',
        url: "notice",
        data: {title:title, dates:dates, description:description},

        success:function (result){
            // event.preventDefault();
            alert("Done");
        },

        fail:function (error){
            alert(error);
    }

    })

    $('#maintainer_notice_form input[type="text"],input[type="date"], textarea').val('');
    $('#add_notice_container').hide();

    setTimeout(function(){
        updateNoticeTable()
    }, 1000)

}



function updateNoticeTable(){
    $.ajax({
        method:'POST',
        url:"addnotice",
        dataType:'json',
    }).done(function(result){
        console.log(result);
        let chunk = 5;
        nextbuttons(result,chunk);
        initiateNextButtons(result,chunk)
        $("#manager_notice_table_tbody").html(' ')
        $.map(result.slice(0,chunk),function(x){
            $('#manager_notice_table_tbody').append(

                '<tr class="manager_notice_row">'+
                '<td>'+x.title+'</td>'+
                '<td>'+x.dates+'</td>'+
                '<td>'+x.description+'</td>'+
                '</tr>'
            );
        });

    }).fail(function(a,b,err){
        alert("Error");
        console.log(a,b,err);
    });
}




function initiateNextButtons(result,chunk) {
    //initiate the buttons
    $(`[id^=next-button]*`).each(function () {
        console.log(this)
        $(this).on("click", function () {
            // console.log($(this).html())
            let pageno = parseInt($(this).html());
            $("#manager_notice_table_tbody").html(' ')
            $.map(result.slice(pageno * chunk - chunk, pageno * chunk), function (x) {
                $('#manager_notice_table_tbody').append(
                    '<tr class="manager_notice_row">' +
                    '<td>' + x.title + '</td>' +
                    '<td>' + x.dates + '</td>' +
                    '<td>' + x.description + '</td>' +
                    '</tr>'
                );


            })
        })
    })
}


