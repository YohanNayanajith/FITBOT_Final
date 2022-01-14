function manager_inquiry_page() {
    let anchor_inquiry = document.getElementById("man_inquiry");
    let anchor_inquiry_i = document.getElementById("man_inquiry_i");
    let inquiry_text = document.getElementById("manager_inquiry_page_text");
    console.log("mokada meee dashboard");
    anchor_inquiry.style.backgroundColor = "white";
    anchor_inquiry_i.style.color = "black";
    inquiry_text.style.color = "black";
  }

function add_inquiry_popup(inquiry_id){
    console.log(inquiry_id);
    $('#add_inquiry_container').show();
    $.ajax({
      method:'POST',
      url:"detailinquiryview",
      dataType:'json',
      data:{inquiry_id:inquiry_id},
    }).done(function(result){
      console.log(result);
      console.log("sachi sithuuu");
      $("#inquiry_right_detail").html(' ')

        $('#inquiry_right_detail').append(
           `<div class="inquiry_right_detail" id="inquiry_right_detail">
            <p>  ${result[0].first_name}</p>
            <p>  ${result[0].inquiry_date} </p>
            <p> ${result[0].inquiry_time} </p>
            <p> ${result[0].status} </p>
            <p>  ${result[0].description} </p>
            </div>`
        );

    }).fail(function(a,b,err){
      alert("Error");
      console.log(a,b,err);
    });
}


function close_add_inquiry_Popup(){
    $('#add_inquiry_container').hide();
}


function searchInquiry(){
    $('#manager_inquiry_search').keyup(function(){
        // alert("yohan2");
        let value = $(this).val().toLowerCase();
        $('.see_inquiry_row').filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
}