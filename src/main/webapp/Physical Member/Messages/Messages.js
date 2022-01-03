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
let globalInstructorID = '';
function selected_instructor_physical(number) {
    if (count_msg == number) {
        return;
    }
    console.log(number);

    if (count_msg == 0) {
        $('#messages_physical_container_right_typing_area').show();
        $('#messages_of_physical_member').show();

        $('.message_number' + number).css("background-color","#7CD0FF");
        $('.message_number' + number).css("color","white");
    } else {
        // $('.message'+count_msg).hide();
        $('.receive_messages_of_physical_member_chat1').hide();
        $('.receive_messages_of_physical_member_chat2').hide();

        let str_ins_id = globalInstructorID.slice(4).toString();
        let number_previous = parseInt(str_ins_id);

        $('.message_number' + number_previous).css("background-color","white");
        $('.message_number' + number_previous).css("color","black");

        $('.message_number' + number).css("background-color","#7CD0FF");
        $('.message_number' + number).css("color","white");
    }

    let instructor_id = "Ins_" + number;
    globalInstructorID = instructor_id;

    $('#send_messages_of_physical_member').show();
    $('#receive_messages_of_physical_member').show();

    messageReadAJAX(instructor_id,number);

    // $('#messages_of_physical_member').show();
    // $('#send_messages_of_physical_member').show();

    count_msg = number;

}

function messageReadAJAX(instructor_id,number){
    $.ajax({
        method: "POST",
        url: "physicalMember/Message",
        data: {instructor_id: instructor_id},
        dataType: "json",
        // contentType:"application/json",
        success: function (result) {
            // alert(result);
            console.log(result);
            // result[].sort();
            data = [];

            $.map(result, function (x) {

                $.map(x, function (y) {
                    data_list = {}
                    if (y["message_date"]) {
                        data_list["message_date"] = y["message_date"];
                    }
                    if (y["message_description"]) {
                        data_list["message_description"] = y["message_description"];
                    }
                    if (y["message_status"].toString().trim() == "1" || y["message_status"].toString().trim() == "0") {
                        data_list["message_status"] = y["message_status"];
                    }
                    if (y["message_time"]) {
                        data_list["message_time"] = y["message_time"];
                    }
                    data.push(data_list);
                });

            });

            let result_data = data.sort((b, a) => {
                if (!(b.message_date.year == a.message_date.year)) {
                    return b.message_date.year - a.message_date.year;
                } else if (!(b.message_date.month == a.message_date.month)) {
                    return b.message_date.month - a.message_date.month;
                } else if (!(b.message_date.day == a.message_date.day)) {
                    return b.message_date.day - a.message_date.day;
                } else if (!(b.message_time.hour == a.message_time.hour)) {
                    return b.message_time.hour - a.message_time.hour;
                } else if (!(b.message_time.minute == a.message_time.minute)) {
                    return b.message_time.minute - a.message_time.minute;
                } else if (!(b.message_time.second == a.message_time.second)) {
                    return b.message_time.second - a.message_time.second;
                }
            });
            console.log(result_data);

            // $.map(data,function(x){
            $.map(result_data, function (y) {
                // alert("Value of Y: "+y["message_description"]);
                if (y["message_status"].toString().trim() == "1") {
                    $('#send_messages_of_physical_member').append(
                        '<div class="receive_messages_of_physical_member_chat1 message+' + number + '+">' +
                        '<div>' + y["message_description"] + '</div>' +
                        '</div>'
                    );
                    $('.receive_messages_of_physical_member_chat1 div').css('background-color', 'white');
                    $('.receive_messages_of_physical_member_chat1 div').css('float', 'left');

                } else if (y["message_status"].toString().trim() == "0") {
                    $('#send_messages_of_physical_member').append(
                        '<div class="receive_messages_of_physical_member_chat2 message+' + number + '">' +
                        // '<div class="receive_messages_of_physical_member_chat2">'+
                        '<div>' + y["message_description"] + '</div>' +
                        '</div>'
                    );
                    $('.receive_messages_of_physical_member_chat2 div').css('background-color', '#e1ffc7');
                    $('.receive_messages_of_physical_member_chat2 div').css('float', 'right');
                }

            });
            // });
        },
        error: function (error) {
            console.log(error + "edit profile");
        }
    });
}

function messageSend() {
    $('#messages_physical_container_right_typing_area_input_1').keypress(function (event) {
        if(event.which == 13){
            let messageValue = $('#messages_physical_container_right_typing_area_input_1').val();
            if(messageValue.length <= 0 ){
                document.getElementById("messages_physical_container_right_typing_area_input_1").value = '';
                return;
            }
            // alert(messageValue + globalInstructorID);

            const date = new Date();
            let fullDate = date.getFullYear()+"-"+("0" + (date.getMonth() + 1)).slice(-2)+"-"+("0" + date.getDate()).slice(-2);

            let fullTime = ("0" + date.getHours()).slice(-2)+":"+("0" + date.getMinutes()).slice(-2)+":"+("0" + date.getSeconds()).slice(-2)+"."+("0" + date.getMilliseconds()).slice(-2);

            let messageStatus = 0;

            $.ajax({
                method: "POST",
                url: "physicalMember/InsertMessage",
                data: {globalInstructorID:globalInstructorID, messageValue:messageValue, fullDate:fullDate, fullTime:fullTime, messageStatus:messageStatus},
                // dataType: "json",
                // contentType:"application/json",
                success: function (result) {
                    console.log(result);
                    if(result.trim().toString() == "1"){
                        console.log("message added");
                    }else {
                        console.log("message not added");
                    }
                },
                error: function (error) {
                    console.log(error + "edit profile");
                }
            });
            document.getElementById("messages_physical_container_right_typing_area_input_1").value = '';
            // messageReadAJAX(globalInstructorID,count_msg);
            // count_msg = 0;
            // selected_instructor_physical();
            $('.receive_messages_of_physical_member_chat1').hide();
            $('.receive_messages_of_physical_member_chat2').hide();
            setInterval(function () {
                messageReadAJAX(globalInstructorID,count_msg);
            }, 1000);
        }
    });
}
