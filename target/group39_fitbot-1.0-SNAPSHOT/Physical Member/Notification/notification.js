let flagValue = 0;
function getNotification(){
    if(flagValue  == 1){
        $('.notification_messages_box').remove();
    }
    $.ajax({
        method:"POST",
        url:"notification",
        dataType:"json",
        // contentType:"application/json",
        success: function (result){
            // alert(result);
            flagValue = 1;
            const date = new Date();
            console.log(date);
            $.map(result,function(x){
                let current_date = date.getDate() - x.notification_date['day'];
                if(current_date > 1){
                    $('#notification_messages_big_div').append(
                        `<div class="notification_messages_box" onclick="markNotification(${x.notification_id})">
                          <div class="notification_messages_box_icon">
                              <i class='bx bx-message-dots bx-tada notify_icon'></i>
                          </div>
                          <div class="notification_messages_box_messages">
                              <span class="notification_messages_box_messages_text1">${x.notification_title}</span><br>
                              <span class="notification_messages_box_messages_text2">${current_date} dates ago</span>
                          </div>
                        </div>`
                    );
                }else{
                    let current_time_hours = date.getHours() - x.notification_time['hour'];
                    let current_time_minutes = date.getMinutes() - x.notification_time['minute'];

                    if(current_time_hours > 1){
                        $('#notification_messages_big_div').append(
                            `<div class="notification_messages_box" onclick="markNotification(${x.notification_id})">
                          <div class="notification_messages_box_icon" >
                              <i class='bx bx-message-dots bx-tada notify_icon'></i>
                          </div>
                          <div class="notification_messages_box_messages">
                              <span class="notification_messages_box_messages_text1">${x.notification_title}</span><br>
                              <span class="notification_messages_box_messages_text2">${current_time_hours} hours ago</span>
                          </div>
                        </div>`
                        );
                    }else{
                        $('#notification_messages_big_div').append(
                            `<div class="notification_messages_box" onclick="markNotification(${x.notification_id})">
                          <div class="notification_messages_box_icon">
                              <i class='bx bx-message-dots bx-tada notify_icon'></i>
                          </div>
                          <div class="notification_messages_box_messages">
                              <span class="notification_messages_box_messages_text1">${x.notification_title}</span><br>
                              <span class="notification_messages_box_messages_text2">${current_time_minutes} minutes ago</span>
                          </div>
                        </div>`
                        );
                    }

                }

            });
            console.log(result);

        },
        error: function(error){
            console.log(error+"edit profile");
        }
    });
}

function markNotification(notification_id){
    //status update query
    $.ajax({
        method:"POST",
        url:"notificationUpdate",
        data: {notification_id:notification_id},
        // dataType:"json",
        // contentType:"application/json",
        success: function (result){
            if(result.trim() == "1"){
                console.log("Notification added");
            }else if(result.trim() == "0"){
                console.log("Notification not added");
            }else {
                console.log("Notification not added");
            }

        },
        error: function(error){
            console.log(error);
            console.log("Notification not added,system error");
        }
    });
}