function physical_member_messages(){
    let message_physical = document.getElementById("phy_mem_messages");
    let message_physical_i = document.getElementById("phy_mem_messages_i");
    let message_physical_text = document.getElementById("physical_member_messages_text");
    message_physical.style.backgroundColor = "white";
    message_physical_i.style.color = "black";
    message_physical_text.style.color = "black";
}

function searchInstructor(){
    $('#messages_physical_container_left_search_text_input').keyup(function(){
        // alert("yohan2");
        let value = $(this).val().toLowerCase();
        $('.messages_physical_container_left_my_chats').filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });

    // $("button").click(function() {
    $(document).scrollTop($(document).height());
    // });
}
let count_msg = 0;
function selected_instructor_physical(number){
    if(count_msg == number){
        return;
    }
    console.log(number);


    if( count_msg == 0 ){
        // $('#messages_physical_container_right_header').show();
        // $('#messages_of_physical_member').hide();

        $('#messages_physical_container_right_typing_area').show();
        $('#messages_of_physical_member').show();

    }else {
        // $('.message'+count_msg).hide();
        $('.receive_messages_of_physical_member_chat1').hide();
        $('.receive_messages_of_physical_member_chat2').hide();
    }

    let instructor_id = "Ins_"+number;

    $('#send_messages_of_physical_member').show();
    $('#receive_messages_of_physical_member').show();

    $.ajax({
        method: "POST",
        url: "physicalMember/Message",
        data:{instructor_id:instructor_id},
        dataType: "json",
        // contentType:"application/json",
        success: function (result) {
            // alert(result);
            console.log(result);
            $.map(result,function(x){
                $.map(x,function(y){
                    if(y["message_status"].toString().trim() == "1"){
                        $('#send_messages_of_physical_member').append(
                            '<div class="receive_messages_of_physical_member_chat1 message+'+number+'+">'+
                            '<div>'+y["message_description"]+'</div>'+
                            '</div>'
                        );
                    }else {
                        $('#receive_messages_of_physical_member').append(
                            '<div class="receive_messages_of_physical_member_chat2">'+
                            '<div>'+y["message_description"]+'</div>'+
                            '</div>'
                        );
                    }

                });
            });
        },
        error: function (error) {
            console.log(error + "edit profile");
        }
    });

    // $('#messages_of_physical_member').show();
    // $('#send_messages_of_physical_member').show();


    count_msg = number;
}

