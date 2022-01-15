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
function physical_workoutplan_open(){
    $('#physical_workout_packages').show();
}
function close_physical_workoutplan_Popup(){
    $('#physical_workout_packages').hide();
}

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
                    <td><input type="checkbox" id="virtualWorkoutCheckbox" onclick="checkBoxChecked()"></td>
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
        if($('#virtualWorkoutCheckbox').prop("checked") == true) {
            alert("Checkbox is checked.");
            console.log("virtualWorkoutCheckbox is checked");
            // $('#edit_profile_error_dob').html("**Your age should be 14 to 80");
            $('#payment_history_container_row').css("background-color", "#0E2C4B");
            // $('#payment_history_container_row').css("box-shadow", "0 10px 10px rgba(0, 0, 0, 0.25)");
            // $("#payment_history_container_row").attr("disabled", true);
        }
    });
}

function load_virtual_detail_popup(workout_description,workout_img_url,exercise_name){
    // alert("Yohan");
    // alert(workout_description);
    console.log(workout_img_url);
    console.log(workout_description);
    $('#virtual_workout_packages_header_h1').html(exercise_name);
    $('#virtual_workout_packages').show();
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

