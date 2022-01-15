function Instructor_leave() {
    let anchor_dashboard = document.getElementById("ins_leave");
    let anchor_dashboard_i = document.getElementById("ins_leave_i");
    let dashboard_text = document.getElementById("Instructor_leave_text");
    console.log("mokada meee dashboard");
    anchor_dashboard.style.backgroundColor = "white";
    anchor_dashboard_i.style.color = "black";
    dashboard_text.style.color = "black";
}


$(document).ready(function () {
    $('#leave_form_side').hide();
})

function OpenInsLeaveForm(){
    alert("call js");
    $('#leave_form_side').show();

    const date = new Date();
    let currentDate = date.getFullYear()+"-"+("0" + (date.getMonth() + 1)).slice(-2)+"-"+("0" + date.getDate()).slice(-2);
    console.log(date);

    $.ajax({
        method:'POST',
        url:"instructorsLeaveFormOpen",
        // dataType: 'json',
        // contentType: "application/json",
    }).done(function (result) {
        console.log(result);

    }).fail(function (a, b, err) {
        alert("Data loading error ruwanthi");
        console.log(a, b, err);
    });


}



// $('#btn_leave_form_submit').click(function(){
//    alert("click submit");
// });

function clickSubmitBtnLeave(){
    alert("click submit");

    $('#form_container_for_Ins').submit(function (e) {
        e.preventDefault();

        let employeeName_first = $('#employeeName_first').val();
        let leave_date_second = $('#leave_date_second').val();
        let branch_name_third = $('#branch_name_third').val();

        // let leave_form_date = $('#comp_time').val();

        let employeeFrom_Date = $('#employeeFrom_Date').val();
        let employeeFrom_Time = $('#employeeFrom_Time').val();
        let employeeTo_Date = $('#employeeTo_Date').val();
        let employeeTo_Time = $('#employeeTo_Time').val();


        console.log("in function");

        console.log(employeeName_first);
        console.log(leave_date_second);
        console.log(branch_name_third);
        console.log(employeeFrom_Date);
        console.log(employeeFrom_Time);
        console.log(employeeTo_Date);
        console.log(employeeTo_Time);

        $.ajax({
            method:'POST',
            url:"instructorsLeaveFormSubmit",
            data: {employeeName_first:employeeName_first, leave_date_second: leave_date_second, branch_name_third: branch_name_third, employeeFrom_Date: employeeFrom_Date, employeeFrom_Time: employeeFrom_Time, employeeTo_Date: employeeTo_Date, employeeTo_Time: employeeTo_Time},

        }).done(function(result){
            console.log(result);


        }).fail(function(a,b,err) {
        alert("Error");
        console.log(a, b, err);

    });

    });
    close_leave_form();
}

function close_leave_form(){
    alert("call close");
    $('#leave_form_side').hide();
}

function oldLeaveRequestLoad(){
    alert("call load function");

    $.ajax({
        method:'POST',
        url:"instructorsOldLeave",
        dataType: 'json',
        contentType: "application/json",
    }).done(function (result) {
        console.log(result);
        $.map(result, function (x) {

            $('#Ins_leave_request_tab_body').append(
                '<tr class="Ins_leave_info">' +
                '<td>' + x.request_date + '</td>' +
                '<td>' + x.leave_reason + '</td>' +
                '<td>' + x.leave_form_date + '</td>' +
                '<td>' + x.leave_to_date + '</td>' +
                '</tr>'
            )
        });
        }).fail(function (a, b, err) {
            alert("Data loading error  Shalani");
            console.log(a, b, err);
        });
}

// function leaveFormSubmit(e){
//     alert("call submit");
//     e.preventDefault();
//     let employeeName=$('#employeeName_first').val();
//     let requestDate=$('#leave_date_second').val();
//     let branch=$('#branch_name_third').val();
//     let message=$('#message').val();
// }









