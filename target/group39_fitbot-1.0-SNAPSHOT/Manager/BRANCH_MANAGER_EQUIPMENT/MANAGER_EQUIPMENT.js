function manager_equipment_page() {
    let anchor_equipment = document.getElementById("man_equipment");
    let anchor_equipment_i = document.getElementById("man_equipment_i");
    let equipment_text = document.getElementById("manager_equipment_page_text");
    console.log("mokada meee dashboard");
    anchor_equipment.style.backgroundColor = "white";
    anchor_equipment_i.style.color = "black";
    equipment_text.style.color = "black";
  }

function manager_equipment_form_page() {
    let anchor_equipment = document.getElementById("man_equipment");
    let anchor_equipment_i = document.getElementById("man_equipment_i");
    let equipment_text = document.getElementById("manager_equipment_page_text");
    console.log("mokada meee dashboard");
    anchor_equipment.style.backgroundColor = "white";
    anchor_equipment_i.style.color = "black";
    equipment_text.style.color = "black";
}



function submitaddequip(){

    alert("shalani");
    let equipment_id = $('#equipment_id').val();
    let description = $('#description').val();
    let category = $('#category').val();
    let purchase_date = $('#purchase_date').val();
    let last_modified_date = $('#last_modified_date').val();
    let next_maintenance_date = $('#next_maintenance_date').val();
    //
    // if (notice_no == "") {
    //     window.alert("Please enter notice number.");
    //     notice_no.focus();
    //     return false;
    // }
    //
    // if (title == "") {
    //     window.alert("Please enter notice title.");
    //     title.focus();
    //     return false;
    // }
    //
    // if (dates == "") {
    //     window.alert("Please enter the date.");
    //     dates.focus();
    //     return false;
    // }
    //
    // if (description == "") {
    //     window.alert("Please enter notice description.");
    //     description.focus();
    //     return false;
    // }
    //
    // console.log(notice_no);
    // console.log(title);
    // console.log(dates);
    // console.log(description);

    $.ajax({
        method: 'POST',
        url: "addequipment",
        data: {equipment_id:equipment_id,description:description, category:category, purchase_date:purchase_date, last_modified_date:last_modified_date, next_maintenance_date:next_maintenance_date},

        success:function (result){
            // event.preventDefault();
            alert("Done");
        },

        fail:function (error){
            alert(error);
        }

    })

    $('#equipment_form input[type="text"],input[type="date"], textarea').val('');
    // $('#add_notice_container').hide();

    setTimeout(function(){
        updateequipmenttable()
    }, 1000)

    setTimeout(function(){
        updateUpcomingMaintainance()
    }, 1000)

}


function updateequipmenttable() {
    $.ajax({
        method: 'POST',
        url: "equipment",
        dataType: 'json',
    }).done(function (result) {
        console.log(result);
        // $("#manager_equipment_table_tbody").html(' ')
        let chunk = 5;
        nextbuttons(result,chunk);
        initiateEquipmentNextButtons(result,chunk)
        $.map(result.slice(0,chunk), function (x) {
            $('#manager_equipment_table_tbody').append(
                '<tr class="manager_equipment_row">' +
                '<td>' + x.equipment_id + '</td>' +
                '<td>' + x.category + '</td>' +
                '<td>' + x.purchase_date + '</td>' +
                '<td>' + x.last_modified_date + '</td>' +
                '<td>' + x.next_maintenance_date + '</td>' +
                '<td>' + '<div class="button_row"><div class="add_btn_class"><input type="button" class="btn_add" value="Update" onclick=""></div> <div class="reject_btn_class"><input type="button" class="btn_reject" value="Disable" onClick=""></div></div>' + '</td>' +
                '</tr>'
            );
        });

    }).fail(function (a, b, err) {
        alert("Error");
        console.log(a, b, err);
    });

}


function updateUpcomingMaintainance(){
    $.ajax({
        method:'POST',
        url:"equipUpcomingMaintain",
        dataType:'json',
    }).done(function(result){
        console.log(result);
        $("#upcoming_maintainance_table_tbody").html(' ')
        $.map(result,function(x){
            $('#upcoming_maintainance_table_tbody').append(

                '<tr class="upcoming_maintainance_header">'+
                '<td>'+ x.equipment_id + '</td>'+
                '<td>'+ x.category + '</td>'+
                '<td>'+ x.next_maintenance_date + '</td>'+
                '</tr>'
            );
        });

    }).fail(function(a,b,err){
        alert("Error");
        console.log(a,b,err);
    });

}





function searchEquipment(){
    $('#manager_equipment_search').keyup(function(){
        // alert("yohan2");
        let value = $(this).val().toLowerCase();
        $('.manager_equipment_row').filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
}





function initiateEquipmentNextButtons(result,chunk) {
    //initiate the buttons
    $(`[id^=next-button]*`).each(function () {
        console.log(this)
        $(this).on("click", function () {
            // console.log($(this).html())
            let pageno = parseInt($(this).html());
            $("#manager_equipment_table_tbody").html(' ')
            $.map(result.slice(pageno * chunk - chunk, pageno * chunk), function(x) {
                $('#manager_equipment_table_tbody').append(
                    '<tr class="manager_equipment_row">' +
                    '<td>' + x.equipment_id + '</td>' +
                    '<td>' + x.category + '</td>' +
                    '<td>' + x.purchase_date + '</td>' +
                    '<td>' + x.last_modified_date + '</td>' +
                    '<td>' + x.next_maintenance_date + '</td>' +
                    '<td>' + '<div class="button_row"><div class="add_btn_class"><input type="button" class="btn_add" value="Update" onclick=""></div> <div class="reject_btn_class"><input type="button" class="btn_reject" value="Disable" onClick=""></div></div>' + '</td>' +
                    '</tr>'
                );


            })
        })
    })
}



