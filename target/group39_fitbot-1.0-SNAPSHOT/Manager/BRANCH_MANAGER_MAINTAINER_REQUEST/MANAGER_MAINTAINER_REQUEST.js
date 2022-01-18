function manager_maintainer_request_page() {
    let anchor_maintainerrequest = document.getElementById("man_request");
    let anchor_maintainerrequest_i = document.getElementById("man_request_i");
    let maintainerrequest_text = document.getElementById("manager_maintainer_request_page_text");
    console.log("mokada meee dashboard");
    anchor_maintainerrequest.style.backgroundColor = "white";
    anchor_maintainerrequest_i.style.color = "black";
    maintainerrequest_text.style.color = "black";
  }

function add_request_popup(){
    $('#add_request_container').show();
}

function close_add_request_Popup(){
    $('#add_request_container').hide();
    $('#maintainer_request_form input[type="text"],input[type="date"], input[type="time"],textarea,select').val('');
}

function submit_requestmaintain_form(){
    // e.preventDefault();
    // alert("shalani");
    let equipment_id = $('#equipment_id').val();
    let category = $('#category').val();
    let description = $('#description').val();
    let re_date = $('#re_date').val();
    let re_time = $('#re_time').val();

    let equipment_id_error =false;
    let category_error =false;
    let description_error =false;
    let re_date_error =false;
    let re_time_error =false;

    //EQUIPMENT ID validation
    if(equipment_id.length == ""){
        equipment_id_text = equipment_id.toString();

        $("#validation_equipmentrequest_id").show();
        equipment_id_error=true;}

    // else if (equipment_id_text[0] != "E" )
    // {
    //     $('#validation_equipmentrequest_id').html("**ID should be start from 'E'");
    //     $('#validation_equipmentrequest_id').css("color", "red");
    //     $("#validation_equipmentrequest_id").show();
    //     equipment_id_error=true;}
    else {
        $("#validation_equipmentrequest_id").hide();
    }

    //category validation
    // if (category.length == ""){
    //     $("#validation_equipmentrequest_type").show();
    //     category_error = true;
    // }
    // else {
    //     $("#validation_equipmentrequest_type").hide();
    // }

    //description validation
    if (description.length == ""){
        $("#validation_equipmentrequest_description").show();
        description_error = true;
    }
    else {
        $("#validation_equipmentrequest_description").hide();
    }

    //date validation
    if (re_date.length == ""){
        $("#validation_equipmentrequest_date").show();
        re_date_error = true;
    }
    else {
        $("#validation_equipmentrequest_date").hide();
    }

    //time validation
    if (re_time.length == ""){
        $("#validation_equipmentrequest_time").show();
        re_time_error = true;
    }
    else {
        $("#validation_equipmentrequest_time").hide();
    }

    //Full validation
    if(equipment_id_error==true || category_error==true || description_error==true || re_date_error==true || re_time_error==true )
    {
        return false;
    }

    console.log(equipment_id);
    console.log(category);
    console.log(description);
    console.log(re_date);
    console.log(re_time);

    $.ajax({
        method: 'POST',
        url: "manageraddrequest",
        data: {equipment_id:equipment_id, category:category, description:description, re_date:re_date, re_time:re_time},

        success:function (result){
            // event.preventDefault();
            alert("Done");
        },

        fail:function (error){
            alert(error);
        }

    })

    $('#maintainer_request_form input[type="text"],input[type="date"], input[type="time"],textarea,select').val('');
    $('#add_request_container').hide();

    setTimeout(function(){
        updaterequest_table()
    }, 1000)
}



function updaterequest_table() {
    $.ajax({
        method: 'POST',
        url: "managerrequest",
        dataType: 'json',
    }).done(function (result) {
        console.log(result);
        let chunk = 5;
        nextbuttons(result,chunk);
        initiateRequestNextButtons(result,chunk)
        $("#manager_request_table_tbody").html(' ')
        $.map(result.slice(0,chunk), function (x) {
            $('#manager_request_table_tbody').append(
                '<tr class="manager_request_row">' +
                '<td>' + x.equipment_id + '</td>' +
                '<td>' + x.category + '</td>' +
                '<td>' + x.status + '</td>' +
                '<td>' + x.next_maintenance_date + '</td>' +
                '</tr>'
            );
        });

    }).fail(function (a, b, err) {
        alert("Error");
        console.log(a, b, err);
    });

}




function initiateRequestNextButtons(result,chunk) {
    //initiate the buttons
    $(`[id^=next-button]*`).each(function () {
        console.log(this)
        $(this).on("click", function () {
            // console.log($(this).html())
            let pageno = parseInt($(this).html());
            $("#manager_request_table_tbody").html(' ')
            $.map(result.slice(pageno * chunk - chunk, pageno * chunk), function (x) {
                $('#manager_request_table_tbody').append(
                    '<tr class="manager_request_row">' +
                    '<td>' + x.equipment_id + '</td>' +
                    '<td>' + x.category + '</td>' +
                    '<td>' + x.status + '</td>' +
                    '<td>' + x.next_maintenance_date + '</td>' +
                    '</tr>'
                );
            })
        })
    })
}

