function Workout_plan_dashboard(){
    let anchor_workout = document.getElementById("phy_mem_workout");
    let anchor_workout_i = document.getElementById("phy_mem_workout_i");
    let workout_text = document.getElementById("physical_member_workout_text");
    anchor_workout.style.backgroundColor = "white";
    anchor_workout_i.style.color = "black";
    workout_text.style.color = "black";
}
// alert("workout");

function virtual_workoutplan_open(){
    $('#virtual_workout_packages').show();
}

function close_virtual_workoutplan_Popup(){
    $('#virtual_workout_packages').hide();
}
function close_virtual_workoutplan_Popup1(){
    $('.virtual_workout_packages_popup_image_detial').remove();
    $('#virtual_workout_packages1').hide();
}
function physical_workoutplan_open(){
    // $('#physical_workout_packages1').show();
    //alert("Yohan");
    //check member has an instructor
    $.ajax({
        method:'POST',
        url:"memberInstructorDetail",
        dataType:'json',
        // contentType:"application/json",
    }).done(function(result){
        console.log(result);
        if(result.toString().trim() == "1"){
            //alert("instructorGetData");
            //no instructor belongs to member
            Swal.fire({
                title: 'Do you want to get an instructor?',
                // text: "Registration is not completed,You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#0E2C4B',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes!'
            }).then((result) => {
                if (result.isConfirmed) {
                    document.getElementById("phy_mem_instructors").click();
                }else if (result.isDenied){
                    // Swal.fire('Changes are not saved', '', 'info')
                    console.log("instructor buy cancel");
                }
            })

            //instructorGetData();
        }else{
            //he has an instructor
            //send notification to instructor
            Swal.fire({
                title: 'Do you want to send a request?',
                // text: "Registration is not completed,You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#0E2C4B',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes!'
            }).then((x) => {
                if (x.isConfirmed) {
                    const date = new Date();

                    let user_id = result["instructor_id"]; //instructorID
                    let notification_title = "Workout plan request";
                    let notification_time = ("0" + date.getHours()).slice(-2)+":"+("0" + date.getMinutes()).slice(-2)+":"+("0" + date.getSeconds()).slice(-2);
                    let notification_date = date.getFullYear()+"-"+("0" + (date.getMonth()+1)).slice(-2)+"-"+("0" + date.getDate()).slice(-2);
                    let notification_type = "immediate";
                    let notification_status = 0;

                    console.log("Instructor ID "+user_id);
                    let has_assign = 0;
                    let request_date = notification_date;

                    $.ajax({
                        method:"POST",
                        url:"requestWorkoutPlan",
                        data: {user_id:user_id,has_assign:has_assign,request_date:request_date},
                        // dataType:"json",
                        // contentType:"application/json",
                        success: function (result){
                            if(result.trim() == "1"){
                                console.log("requestWorkoutPlan is saved");

                                Swal.fire({
                                    icon: 'success',
                                    title: 'Request Send to the Instructor!',
                                    // text: 'Physical Member!',
                                    confirmButtonText:"Ok",
                                    confirmButtonColor: '#0E2C4B',
                                })

                                $.ajax({
                                    method:"POST",
                                    url:"saveNotification",
                                    data: {user_id:user_id,notification_title:notification_title,notification_time:notification_time,notification_date:notification_date,notification_type:notification_type,notification_status:notification_status},
                                    // dataType:"json",
                                    // contentType:"application/json",
                                    success: function (result){
                                        if(result.trim() == "1"){
                                            console.log("Notification is saved");
                                        }else if(result.trim() == "0"){
                                            console.log("Notification is not saved");
                                        }else {
                                            console.log("Notification is saved and error1");
                                        }
                                    },
                                    error: function(error){
                                        console.log(error);
                                        console.log("Notification is saved and error2");
                                    }
                                });

                            }else if(result.trim() == "0"){
                                Swal.fire({
                                    icon: 'error',
                                    title: 'Request Send Unsuccessfully!',
                                    //text: 'Payment cannot completed!',
                                    confirmButtonText:"Ok",
                                    confirmButtonColor: '#932828',
                                })
                            }else if(result.trim() == "2"){
                                Swal.fire({
                                    icon: 'error',
                                    title: 'You already sent a request!',
                                    //text: 'Payment cannot completed!',
                                    confirmButtonText:"Ok",
                                    confirmButtonColor: '#932828',
                                })
                            }else {
                                console.log("requestWorkoutPlan is saved and error1");
                                Swal.fire({
                                    icon: 'error',
                                    title: 'Request Send Unsuccessfully!',
                                    //text: 'Payment cannot completed!',
                                    confirmButtonText:"Ok",
                                    confirmButtonColor: '#932828',
                                })
                            }
                        },
                        error: function(error){
                            console.log(error);
                            console.log("requestWorkoutPlan error");
                        }
                    });

                }else if (result.isDenied){
                    // Swal.fire('Changes are not saved', '', 'info')
                    console.log("instructor buy cancel");
                }
            })
        }
        // alert(result);
    }).fail(function(a,b,err){
        console.log(a,b,err);
    });

}

// function sendWorkoutRequest(user_id,notification_date,notification_title,notification_time,notification_type,notification_status){
//
//
// }

// function saveNotificationWorkoutRequest(user_id,notification_date,notification_title,notification_time,notification_type,notification_status){
//
// }

// function close_physical_workoutplan_Popup(){
//     $('#physical_workout_packages1').hide();
// }

let data_arr = [];
function open_virtual_workout_plan(value_attri,num_plan){
    $('#virtual_workout_packages').hide();
    // $('#physical_member_workout_plans').hide();

    $('#physical_member_workout_plans').load('http://localhost:8080/group39_fitbot_war_exploded/Physical%20Member/Workout_Plans/Virtual_Workout_Plans.html #workout_plan_virtual',function(responseTxt, statusTxt, xhr){

        if(statusTxt == "error") {
            alert("Error: " + xhr.status + ": " + xhr.statusText);
        }
        $('#virtual_workout_container').append(
            '<span>'+value_attri+'</span>'
        );
        getVirtualWorkoutData(num_plan);

    });
    console.log(value_attri);
    console.log(num_plan);

    data_arr[0] = value_attri;
    data_arr[1] = num_plan;
    // window.history.pushState("object or string", "virtual_workout_plan", "/group39_fitbot_war_exploded/physicalMember/virtualWorkoutPlan");

    // if(window.location.reload()){
    //     alert("Yohan");
    // }
}

function physical_workout_back(){
    // window.history.back();
    $('#physical_member_workout_plans').load('http://localhost:8080/group39_fitbot_war_exploded/Physical%20Member/Workout_Plans/Workout_Plan.html #workout_plan_physical',function(responseTxt, statusTxt, xhr){

        if(statusTxt == "error") {
            alert("Error: " + xhr.status + ": " + xhr.statusText);
        }
        checkWorkoutData();
        $('#workout_container_header_search_cant_find').hide();
    });
}

function getVirtualWorkoutData(num_plan){
    $.ajax({
        method:'POST',
        url:"physicalMember/virtualWorkoutPlan",
        data:{num_plan:num_plan},
        // dataType:'json',
        // contentType:"application/json",
    }).done(function(result){

        console.log(result);
        $.map(result,function(x){
            // $('#virtual_workout_container_table').append(
            $('#table').append(
                `<tr class="payment_history_container_row workout_physical_container_exercise_name" id="payment_history_container_row" onclick="load_virtual_detail_popup('${x.workout_description}','${x.workout_img_url}','${x.exercise}')">
                    <td>${x.exercise}</td>
                    <td>${x.workout_type}</td>
                    <td>${x.total_reps}</td>
                    <td>${x.duration}</td>
                    <td><input type="checkbox" id="virtualWorkoutCheckbox" class="payment_history_container_row_checkbox" onclick="checkBoxChecked()"></td>
                </tr>`
            );
        });
        getDragandDropFeature();
    }).fail(function(a,b,err){
        alert("Error");
        console.log(a,b,err);
    });
}

$(document).ready(function (){
    $('#virtual_workout_packages').hide();
});

function checkBoxChecked(){
    $('input[type="checkbox"]').click(function(){
        Swal.fire({
            title: 'Are you sure?',
            text: "Workout is not completed,You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#0E2C4B',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, go back!'
        }).then((result) => {
            if($('.payment_history_container_row_checkbox').prop("checked") == true) {
                alert("Checkbox is checked.");
                console.log("virtualWorkoutCheckbox is checked");
                // $('#edit_profile_error_dob').html("**Your age should be 14 to 80");
                $('#payment_history_container_row').css("background-color", "#0E2C4B");
                // $('#payment_history_container_row').css("box-shadow", "0 10px 10px rgba(0, 0, 0, 0.25)");
                // $("#payment_history_container_row").attr("disabled", true);
            }
        })
    });
}

function load_virtual_detail_popup(workout_description,workout_img_url,exercise_name){
    // alert("Yohan");
    // alert(workout_description);
    console.log(workout_img_url);
    console.log(workout_description);
    $('#virtual_workout_packages_popup_image').append(
        `<img src="${workout_img_url}" class="virtual_workout_packages_popup_image_detial" alt="workout-image">`
    );
    $('#virtual_workout_packages_header_h1').html(exercise_name);
    $('#virtual_workout_packages_popup_description').html(workout_description);
    $('#virtual_workout_packages1').show();
}

function close_virtual_workoutplan_Popup(){
    $('#virtual_workout_packages').hide();
}

function physical_customize_workoutplan(){
    alert("Customize workout plan");
    // $('#physical_member_workout_plans').hide();
    // $('#physical_member_workout_plans').hide();

    $('#physical_member_workout_plans').load('http://localhost:8080/group39_fitbot_war_exploded/Physical%20Member/Workout_Plans/Cutomize_workout_plan.html #customize_workout_plan_virtual',function(responseTxt, statusTxt, xhr){

        if(statusTxt == "error") {
            alert("Error: " + xhr.status + ": " + xhr.statusText);
        }
        $('#customize_virtual_workout_container').append(
            '<span>'+"Customize "+data_arr[0]+'</span>'
        );
        getCustomizeVirtualWorkoutData(data_arr[1]);
        console.log(data_arr[1]);
    });
}
function getCustomizeVirtualWorkoutData(num_plan){
    $.ajax({
        method:'POST',
        url:"physicalMember/virtualWorkoutPlan",
        data:{num_plan:num_plan},
        // dataType:'json',
        // contentType:"application/json",
    }).done(function(result){
        console.log(result);
        $.map(result,function(x){
            $('#table').append(
                `<tr class="payment_history_container_row workout_physical_container_exercise_name" id="payment_history_container_row" onclick="load_virtual_detail_popup('${x.workout_description}','${x.workout_img_url}','${x.exercise}')">
                    <td>${x.exercise}</td>
                    <td>${x.workout_type}</td>
                    <td>${x.total_reps}</td>
                    <td>${x.duration}</td>
                    <td><i class='bx bxs-edit-alt'></i></td>
                </tr>`
            );
        });
        getDragandDropFeature();
    }).fail(function(a,b,err){
        alert("Error");
        console.log(a,b,err);
    });
}

function customize_physical_workout_back(){
    $('#physical_member_workout_plans').load('http://localhost:8080/group39_fitbot_war_exploded/Physical%20Member/Workout_Plans/Virtual_Workout_Plans.html #workout_plan_virtual',function(responseTxt, statusTxt, xhr){

        if(statusTxt == "error") {
            alert("Error: " + xhr.status + ": " + xhr.statusText);
        }
        $('#virtual_workout_container').append(
            '<span>'+data_arr[0]+'</span>'
        );
        getVirtualWorkoutData(data_arr[1]);

    });
}
function physical_customize_save_workoutplan(){
    alert("Save");
}
function searchWorkout(){
    $('#workout_physical_container_left_search_text_input').keyup(function(){
        // alert("yohan2");
        let value = $(this).val().toLowerCase();
        $('.workout_physical_container_exercise_name').filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
}

function searchDefaultWorkout(){
    $('#workout_physical_container_left_search_text_input1').keyup(function(){
        let value = $(this).val().toLowerCase();
        $('.workout_physical_container_exercise_name').filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
}

// if (window.performance) {
//     console.info("window.performance works fine on this browser");
// }
// window.onunload = function(){
//     alert("unload event detected!");
// }

// $(document).onload(function(){
//     console.info(performance.navigation.type);
//     if (performance.navigation.type == performance.navigation.TYPE_RELOAD) {
//         console.info( "This page is reloaded" );
//         window.location.href = "http://localhost:8080/group39_fitbot_war_exploded/physicalMember";
//     } else {
//         console.info( "This page is not reloaded");
//     }
// });

