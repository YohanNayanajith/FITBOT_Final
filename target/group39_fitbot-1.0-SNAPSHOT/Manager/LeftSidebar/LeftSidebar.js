let sidebar = document.querySelector(".sidebar");
let closeBtn = document.querySelector("#btn");
let searchBtn = document.querySelector(".bx-search");

closeBtn.addEventListener("click", ()=>{
  sidebar.classList.toggle("open");
  menuBtnChange();//calling the function(optional)
});

searchBtn.addEventListener("click", ()=>{ // Sidebar open when you click on the search iocn
  sidebar.classList.toggle("open");
  menuBtnChange(); //calling the function(optional)
});

// following are the code to change sidebar button(optional)
function menuBtnChange() {
  if(sidebar.classList.contains("open")){
    closeBtn.classList.replace("bx-menu", "bx-menu-alt-right");//replacing the iocns class
  }else {
    closeBtn.classList.replace("bx-menu-alt-right","bx-menu");//replacing the iocns class
  }
}

function visibleSocialMedia(){
  var social_media = document.querySelector(".social_media_icons_side_bar");
  var social_media_active = document.querySelector(".social_media_icons_side_bar_active");
  var width_social_media = document.querySelector(".social_media_icons_width_menu");
  var width_social_media_active = document.querySelector(".social_media_icons_width_menu_active");
  if (sidebar.classList.contains("open")) {
    social_media_active.classList.replace("social_media_icons_side_bar_active","social_media_icons_side_bar");
    width_social_media_active.classList.replace("social_media_icons_width_menu_active","social_media_icons_width_menu");
  } else {
    social_media.className += "_active";
    width_social_media.classList.replace("social_media_icons_width_menu", "social_media_icons_width_menu_active");
    
  }
}


// $(document).ready(function(){
//   $('#click_me').click(function () {
//     $('#right_side_bar_view').load('http://localhost:8080/group39_fitbot_war_exploded/Manager/RightSidebar/RightSidebar.html #right_side_nav',function(responseTxt, statusTxt, xhr){
//       if(statusTxt == "error")
//         alert("Error: " + xhr.status + ": " + xhr.statusText);
//       });
//   });
//
//
// });

var sideBar_links_variable = "#manager_dashboard_page";

function page_select(sideBar_links_variable){
  if(sideBar_links_variable == "#manager_dashboard_page"){
    $('#manager_dashboard_page').hide();
    clear_dashboard_functions("man_dashboard","man_dashboard_i","manager_dashboard_page_text");
    console.log("dashboard");

  }else if(sideBar_links_variable == "#manager_member_page"){
    $('#manager_member_page').hide();
    clear_dashboard_functions("man_member","man_member_i","manager_member_page_text");

  }else if(sideBar_links_variable == "#manager_inquiry_page"){
    $('#manager_inquiry_page').hide();
    clear_dashboard_functions("man_inquiry","man_inquiry_i","manager_inquiry_page_text");

  }else if(sideBar_links_variable == "#manager_notices_page"){
    $('#manager_notices_page').hide();
    clear_dashboard_functions("man_notice","man_notice_i","manager_notices_page_text");

  }else if(sideBar_links_variable == "#manager_equipment_page"){
    $('#manager_equipment_page').hide();
    clear_dashboard_functions("man_equipment","man_equipment_i","manager_equipment_page_text");

  }else if(sideBar_links_variable == "#manager_equipment_form_page"){
    $('#manager_equipment_form_page').hide();
    clear_dashboard_functions("man_equipment","man_equipment_i","manager_equipment_page_text");

  }else if(sideBar_links_variable == "#manager_maintainer_request_page"){
    $('#manager_maintainer_request_page').hide();
    clear_dashboard_functions("man_request","man_request_i","manager_maintainer_request_page_text");

  }else if(sideBar_links_variable == "#manager_instructor_page"){
    $('#manager_instructor_page').hide();
    clear_dashboard_functions("man_instructor","man_instructor_i","manager_instructor_page_text");
    console.log("payments");

  }else if(sideBar_links_variable == "#manager_report_page"){
    $('#manager_report_page').hide();
    clear_dashboard_functions("man_report","man_report_i","manager_report_page_text");
  }
  // else if(sideBar_links_variable === "#physical_member_branch_messages"){
  //   $('#physical_member_branch_messages').hide();
  // }else if(sideBar_links_variable == "#physical_member_appoinments"){
  //   $('#physical_member_appoinments').hide();
  //   clear_dashboard_functions("phy_mem_appointments","phy_mem_appointments_i","physical_member_appointments_text");
  //   console.log("appointments");

  // }
  else if(sideBar_links_variable == "#physical_member_settings"){
    $('#physical_member_settings').hide();
  }else if(sideBar_links_variable == "#physical_member_conditions"){
    $('#physical_member_conditions').hide();
  }
}
function clear_dashboard_functions(full_background,dashboard_icon,dashboard_text) {
  // let payments_physical = document.querySelector(".payments_physical");
  let full_background_ID = document.getElementById(full_background);
  let dashboard_icon_ID = document.getElementById(dashboard_icon);
  let dashboard_text_ID = document.getElementById(dashboard_text);
  console.log("dashboard link closed");
  // payments_physical.className += "_active";
  full_background_ID.style.backgroundColor = "#0E2C4B";
  dashboard_icon_ID.style.color = "white";
  dashboard_text_ID.style.color = "white";
}

//dashboard
$(document).ready(function(){
  $('#manager_dashboard_page').load('http://localhost:8080/group39_fitbot_war_exploded/Manager/BRANCH_MANAGER_DASHBOARD/MANAGER_DASHBOARD.html #home_content_dashboard',function(responseTxt, statusTxt, xhr){
  if(statusTxt == "error") {
    alert("Error: " + xhr.status + ": " + xhr.statusText);
  }
    branchidsession();
    dashboardattendence();
    managerdashboard();
    // dashboardappoinment();
    manager_branch_revenue();
  });
});

function branchidsession(){
  //to get branchid to the session
  $.ajax({
    method: 'POST',
    url: "manager",
    dataType: 'json',
  }).done(function (result) {
    alert("done");
    console.log(result);

  }).fail(function (a, b, err) {
    alert("faalil baary");
    console.log(a, b, err);
  });
}

function dashboardattendence(){
  const date = new Date();
  let fullDate = date.getFullYear()+"-"+("0" + (date.getMonth() + 1)).slice(-2)+"-"+("0" + date.getDate()).slice(-2);
  console.log(fullDate);

  let firstdate = date.getFullYear()+"-"+("0" + (date.getMonth() + 1)).slice(-2)+"-"+("01");
  console.log(firstdate);

  let month = (date.getMonth()+1);
  console.log(month);

  var lastday = function(y,m){
    return  new Date(y, m, 0).getDate();
  }

  console.log(lastday(date.getFullYear(),month));

  let lastdate = date.getFullYear()+"-"+("0" + (date.getMonth() + 1)).slice(-2)+"-"+(lastday(date.getFullYear(),month));
  console.log(lastdate);

  $.ajax({
    method: 'POST',
    url: "mandashboardattendence",
    dataType: 'json',
    data:{fullDate:fullDate,firstdate:firstdate,lastdate:lastdate},

  }).done(function (result) {
    console.log(result);

    $('#revenue_number').append(
        '<p>'+ 'Rs: ' + result[0].branch_revenue  + '</p>'
    );

    $('#mem_att_no').append(
        '<p>'+  result[0].member_attendence_count  + '</p>'
    );

    $('#ins_att_no').append(
        '<p>'+ result[0].instructor_attendence_count  + '</p>'
    );

    $('#appoinment_count').append(
        '<p>'+ result[0].appoinment_count  + '</p>'
    );

    $('#new_member_number').append(
        '<p>'+ result[0].new_member_count  + '</p>'
    );

  }).fail(function (a, b, err) {
    alert("Error");
    console.log(a, b, err);
  });
}

// function dashboardappoinment(){
//   const date = new Date();
//   let today = date.getFullYear()+"-"+("0" + (date.getMonth() + 1)).slice(-2)+"-"+("0" + date.getDate()).slice(-2);
//   console.log(today);
//
//   $.ajax({
//     method: 'POST',
//     url: "mandashboardappoinment",
//     dataType: 'json',
//     data:{today:today},
//   }).done(function (result) {
//     console.log(result);
//
//     $.map(result, function (x) {
//       $('#app_name').append('<div class="app_name" id="app_name">' + x.mem_firstname +'</div>');
//       $('#app_no').append('<div class="app_no" id="app_no">' + x.appoin_starttime + '</div>');
//     });
//
//   }).fail(function (a, b, err) {
//     alert("Error");
//     console.log(a, b, err);
//   });
// }


function managerdashboard(){
  $.ajax({
    method: 'POST',
    url: "mandashboard",
    dataType: 'json',
  }).done(function (result) {
    console.log(result);

    $('#dashboard').append(
        `<div class="dashboard" id="dashboard">` + 'Hello' + " " + (result[0].manager_firstname + " " + result[0].manager_lastname) + ' !'+ `</div>`
        // '<p>'+ 'Hello' + " " + (result[0].manager_firstname + " " + result[0].manager_lastname) + ' !'+ '</p>'
    );

    $('#branchnumber').append(
        '<p>'+ result[0].branch_membercount  + '</p>'
    );

    $('#equipnumber').append(
        '<p>'+ result[0].branch_equipmentscount  + '</p>'
    );

    $('#instructornumber').append(
        '<p>'+ result[0].branch_instructorscount  + '</p>'
    );

  }).fail(function (a, b, err) {
    alert("Error");
    console.log(a, b, err);
  });
}

var load = [0,0,0,0,0,0,0,0,0,0,0];

$(document).ready(function(){
  //dashboard
  $('#man_dashboard').click(function(){
    if(load[0] == 0){
      load[0] += 1;
      console.log(load);
    }else if(sideBar_links_variable == "#manager_dashboard_page"){
      return;
    }else {
      page_select(sideBar_links_variable);
      sideBar_links_variable = "#manager_dashboard_page";
      $('#manager_dashboard_page').show();
    }
  });

// members
$('#man_member').click(function(){
  page_select(sideBar_links_variable);
  sideBar_links_variable = "#manager_member_page";
  
  if(load[1] == 0){
    $(sideBar_links_variable).load('http://localhost:8080/group39_fitbot_war_exploded/Manager/BRANCH_MANAGER_MEMBER/MANAGER_MEMBER.html #home_manager_member',function(responseTxt, statusTxt, xhr){
    
    if(statusTxt == "error")
        alert("Error: " + xhr.status + ": " + xhr.statusText);

      member_view();
      managerpayment_view();
      managermember_attendence();

    });
    load[1] += 1;
  }else{
    $('#manager_member_page').show();
  }
});



//inquiry
$('#man_inquiry').click(function(){
  page_select(sideBar_links_variable);
  sideBar_links_variable = "#manager_inquiry_page";
  
  if(load[2] == 0){
    $(sideBar_links_variable).load('http://localhost:8080/group39_fitbot_war_exploded/Manager/BRANCH_MANAGER_INQURIES/MANAGER_INQUIRIES.html #manager_inquiry',function(responseTxt, statusTxt, xhr){
    
    if(statusTxt == "error")
        alert("Error: " + xhr.status + ": " + xhr.statusText);

      inquiry_view();

    });
    load[2] += 1;
  }else{
    $('#manager_inquiry_page').show();
  }
});



//notice
$('#man_notice').click(function(){
  page_select(sideBar_links_variable);
  sideBar_links_variable = "#manager_notices_page";
  
  if(load[3] == 0){
    $(sideBar_links_variable).load('http://localhost:8080/group39_fitbot_war_exploded/Manager/BRANCH_MANAGER_NOTICES/MANAGER_NOTICES.html #maintainer_notice_home',function(responseTxt, statusTxt, xhr){
    
    if(statusTxt == "error")
        alert("Error: " + xhr.status + ": " + xhr.statusText);

       updateNoticeTable();

    });
    load[3] += 1;
  }else{
    $('#manager_notices_page').show();
  }
});



// equipment
$('#man_equipment').click(function(){
  if(sideBar_links_variable ==="#manager_equipment_form_page") {
    sideBar_links_variable = "#manager_equipment_page";
    $('#manager_equipment_form_page').hide();
  }
  else if(sideBar_links_variable !=="#manager_equipment_page") {
    page_select(sideBar_links_variable);
    sideBar_links_variable = "#manager_equipment_page";
  }
  if(load[4] == 0){
    $(sideBar_links_variable).load('http://localhost:8080/group39_fitbot_war_exploded/Manager/BRANCH_MANAGER_EQUIPMENT/MANAGER_EQUIPMENT.html #manager_equipmentlist',function(responseTxt, statusTxt, xhr){
    
    if(statusTxt == "error")
        alert("Error: " + xhr.status + ": " + xhr.statusText);

      updateequipmenttable();
      updateUpcomingMaintainance();

    });
    load[4] += 1;
  }else{
    $('#manager_equipment_page').show();
  }
});


  //equipment form
  $(function () {
    $(document).on("click", '#add_new_equip_form', function() {
      $('#manager_equipment_page').hide();
      sideBar_links_variable = "#manager_equipment_form_page";

      if(load[8] == 0){

        $("#manager_equipment_form_page").load('http://localhost:8080/group39_fitbot_war_exploded/Manager/BRANCH_MANAGER_EQUIPMENT/MANAGER_ADD_NEW_EQUIPMENT.html #add_equipment_view',function(responseTxt, statusTxt, xhr){
          console.log("ammmmmmmmmaaaaaaaaa");
          if(statusTxt == "error")
            alert(`Error: ${xhr.status}: ${xhr.statusText}`);
        });
        load[8] += 1;
      }else{
        $('#manager_equipment_form_page').show();
      }
    });
  });



//request
$('#man_request').click(function(){
  page_select(sideBar_links_variable);
  sideBar_links_variable = "#manager_maintainer_request_page";
  
  if(load[5] == 0){
    $(sideBar_links_variable).load('http://localhost:8080/group39_fitbot_war_exploded/Manager/BRANCH_MANAGER_MAINTAINER_REQUEST/MANAGER_MAINTAINER_REQUEST.html #maintainer_request_home',function(responseTxt, statusTxt, xhr){
      $("#validation_equipmentrequest_id").hide();
      $("#validation_equipmentrequest_type").hide();
      $("#validation_equipmentrequest_description").hide();
      $("#validation_equipmentrequest_date").hide();
      $("#validation_equipmentrequest_time").hide();

    if(statusTxt == "error")
        alert("Error: " + xhr.status + ": " + xhr.statusText);

      updaterequest_table();
    });
    load[5] += 1;
  }else{
    $('#manager_maintainer_request_page').show();
  }
});



  //instructors
  $('#man_instructor').click(function(){
    page_select(sideBar_links_variable);
    sideBar_links_variable = "#manager_instructor_page";
    
    if(load[6] == 0){
      $(sideBar_links_variable).load('http://localhost:8080/group39_fitbot_war_exploded/Manager/BRANCH_MANAGER_INSTRUCTOR/MANAGER_INSTRUCTOR.html #instructor_manager_home',function(responseTxt, statusTxt, xhr){
      
      if(statusTxt == "error")
          alert("Error: " + xhr.status + ": " + xhr.statusText);

        managerins_view();
        managerins_view_count();

      });
      load[6] += 1;
    }else{
      $('#manager_instructor_page').show();
    }
  });


  //report
  $('#man_report').click(function(){
    page_select(sideBar_links_variable);
    sideBar_links_variable = "#manager_report_page";
    
    if(load[7] == 0){
      $(sideBar_links_variable).load('http://localhost:8080/group39_fitbot_war_exploded/Manager/BRANCH_MANAGER_REPORTS/MANAGER_REPORT.html #manager_report',function(responseTxt, statusTxt, xhr){
      if(statusTxt == "error")
          alert("Error: " + xhr.status + ": " + xhr.statusText);

        manager_branch_revenue_report();
        DuePaymentReport();
        MaintainenceReport();

      });
      load[7] += 1;
    }else{
      $('#manager_report_page').show();
    }
    //other links
  });
    
});

//close button - its called in rigtsidebar.html
function closeNav() {
  let right_sidebar = document.querySelector(".right_side_nav");
  console.log("mokada meee");
  if (right_sidebar.className === "right_side_nav") {
    right_sidebar.className += "_active";
    console.log("mokada meee1");
  } else {
    right_sidebar.classList.remove = "right_side_nav_active";
  }
}




// logout
function log_out_man_function(){
  $.ajax({
    method:"POST",
    url:"logout",
    data:"",
    success: function(result){
      if(result == "1"){
        Swal.fire({
          title: 'Do you want to log out?',
          // text: "Registration is not completed,You won't be able to revert this!",
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#0E2C4B',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Yes, log out!'
        }).then((result) => {
          if (result.isConfirmed) {
            window.location.href = "http://localhost:8080/group39_fitbot_war_exploded/login";
          }else if (result.isDenied){
            // Swal.fire('Changes are not saved', '', 'info')
            console.log("Log out cancel");
          }
        })
      }else {
        console.log("Something went wrong");
        setTimeout(function() {
          Swal.fire({
            icon: 'error',
            title: 'Try Again',
            text: 'Logout unsuccessfully!',
            confirmButtonText:"Ok",
            confirmButtonColor: '#932828',
          })
        }, 2000);
      }
    },
    error: function(error){
      console.log(error);
      Swal.fire({
        icon: 'error',
        title: 'Try Again',
        text: 'Logout unsuccessfully!',
        confirmButtonText:"Ok",
        confirmButtonColor: '#932828',
      })
    }
  });
}

function managerins_view(){
  const date = new Date();
  let currentDate = date.getFullYear()+"-"+("0" + (date.getMonth() + 1)).slice(-2)+"-"+("0" + date.getDate()).slice(-2);
  console.log(currentDate);

  $.ajax({
    method: 'POST',
    url: "managerinstructorview",
    data:{currentDate:currentDate},
    dataType: 'json',
  }).done(function (result) {
    console.log(result);
    $("#ins_manager_details_table_tbody").html(' ')
    let chunk = 5;
    nextbuttons(result,chunk);
    initiateInstructorNextButtons(result,chunk)
    $.map(result.slice(0,chunk), function (x) {
      $('#ins_manager_details_table_tbody').append(
          '<tr class="manager_instructor_row">' +
          '<td>' + (x.first_name + " " + x.last_name) + '</td>' +
          '<td>' + x.mem_count + '</td>' +
          '<td>' + x.appoinment_count + '</td>' +
          '<td>' + '<input type="checkbox" class="ins_atte"/>' +
          '</td>' +
          '</tr>'
      );
    });

  }).fail(function (a, b, err) {
    alert("Error");
    console.log(a, b, err);
  });
}



function managerins_view_count(){
  const date = new Date();
  let currentDate = date.getFullYear()+"-"+("0" + (date.getMonth() + 1)).slice(-2)+"-"+("0" + date.getDate()).slice(-2);
  console.log(currentDate);

  $.ajax({
    method: 'POST',
    url: "managerinstructorview_count",
    data:{currentDate:currentDate},
    dataType: 'json',
  }).done(function (result) {
    console.log(result);

    $('#presentnumber').append(
        '<p>'+ result[0].instructor_present_count + '</p>'
    );

    $('#total_number').append(
        '<p>'+ result[0].total_instructor_count + '</p>'
    );

    $('#absentnumber').append(
        '<p>'+ (result[0].total_instructor_count - result[0].instructor_present_count) + '</p>'
    );

  }).fail(function (a, b, err) {
    alert("Error");
    console.log(a, b, err);
  });
}



function member_view(){
  $.ajax({
    method: 'POST',
    url: "managermember",
    dataType: 'json',
  }).done(function (result) {
    console.log(result);
    $("#ins_manager_mem_details_table_tbody").html(' ')
    let chunk = 5;
    nextbuttons(result,chunk);
    initiateMembeNextButtons(result,chunk)
    $.map(result.slice(0,chunk), function (x) {
      $('#ins_manager_mem_details_table_tbody').append(
          `<tr class="manager_member_row"> 
          <td> ${x.firstname + " " + x.lastname} </td>
          <td> ${x.membertype.replace("_", " ")} </td>
          <td> ${x.intructorname} </td>
          <td> <input type="checkbox" class="atte" onclick="manager_member_attendence(${x.member_id})" value="Select" /> </td> 
          </tr>`
      );
    });

  }).fail(function (a, b, err) {
    alert("Error");
    console.log(a, b, err);
  });
}


function managerpayment_view(){
  $.ajax({
    method: 'POST',
    url: "managerpayment",
    dataType: 'json',
  }).done(function (result) {
    console.log(result);
    $("#payment_request_table_tbody").html(' ')
    $.map(result, function (x) {
      $('#payment_request_table_tbody').append(
          '<tr class="payment_request_row">' +
          '<td>' + (x.firstname + " " + x.lastname ) + '</td>' +
          '<td>' + x.payment + '</td>' +
          '<td>' + ((x.membership_category).replace("_", " ")) + '</td>' +
          '<td>' + '<div class="button_row">\n' +
          '<div class="add_btn_class"><input type="button" class="btn_add" value="Accept" onclick=""></div>\n' +
          '<div class="reject_btn_class"><input type="button" class="btn_reject" value="Reject" onclick=""></div>\n' +
          '</div>' +
          '</td>' +
          '</tr>'
      );
    });

  }).fail(function (a, b, err) {
    alert("Error");
    console.log(a, b, err);
  });
}

console.log(member_id);
function manager_member_attendence(member_id){
  console.log(member_id);
  const date = new Date();
  let currentDate = date.getFullYear()+"-"+("0" + (date.getMonth() + 1)).slice(-2)+"-"+("0" + date.getDate()).slice(-2);
  console.log(currentDate);

  var today = new Date();
  var currentTime = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
  console.log(currentTime);

  $.ajax({
    method: 'POST',
    url: "mark_attendence_checkbox",
    data:{currentDate:currentDate,currentTime:currentTime},
    dataType: 'json',
  }).done(function (result) {
    // console.log(result);
    console.log("pansiluu");
  }).fail(function (a, b, err) {
    alert("Error");
    console.log(a, b, err);
  });
}

function inquiry_view() {
  $.ajax({
    method: 'POST',
    url: "inquiryview",
    dataType: 'json',
  }).done(function (result) {
    console.log(result);
    console.log("sachi sithuuu");
    $("#see_inquiry_table1_tbody").html(' ')
    let chunk = 5;
    nextbuttons(result,chunk);
    initiateInquiryNextButtons(result,chunk)
    $.map(result.slice(0,chunk), function (x) {
      $('#see_inquiry_table1_tbody').append(
          `<tr class="see_inquiry_row">
              <td> ${x.first_name} </td>
              <td> ${x.inquiry_date} </td>
              <td> ${x.inquiry_time} </td>
              <td> ${x.status} </td>
<!--               '<td>'+ x.inquiry_title + '</td>'+-->
              <td><div id="inquiry_title_btn_a" onclick="add_inquiry_popup(${x.inquiry_id})"><i class=\'bx bxs-show bx-tada bx-flip-horizontal view_popup\'></i></div></td>
              </tr>`
      );
    });
  }).fail(function (a, b, err) {
    alert("Error");
    console.log(a, b, err);
  });
}


function updateNoticeTable(){
  $.ajax({
    method:'POST',
    url:"addnotice",
    dataType:'json',
  }).done(function(result){
    console.log(result);
    $("#manager_notice_table_tbody").html(' ')
    $.map(result,function(x){
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



function updateequipmenttable() {
  $.ajax({
    method: 'POST',
    url: "equipment",
    dataType: 'json',
  }).done(function (result) {
    console.log(result);
    $("#manager_equipment_table_tbody").html(' ')
    $.map(result, function (x) {
      $('#manager_equipment_table_tbody').append(
          '<tr class="manager_equipment_row">' +
          '<td>' + x.equipment_id + '</td>' +
          '<td>' + x.category + '</td>' +
          '<td>' + x.purchase_date + '</td>' +
          '<td>' + x.last_modified_date + '</td>' +
          '<td>' + x.next_maintenance_date + '</td>' +
          '<td>' + '<div class="button_row"><div class="add_btn_class"><input type="button" class="btn_add" value="Update" onClick=""></div> <div class="reject_btn_class"><input type="button" class="btn_reject" value="Delete" onClick=""></div></div>' + '</td>' +
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



function updaterequest_table(){
  $.ajax({
    method: 'POST',
    url: "managerrequest",
    dataType: 'json',
  }).done(function (result) {
    console.log(result);
    $("#manager_request_table_tbody").html(' ')
    $.map(result, function (x) {
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




//pagination function

let chunk,array;
function nextbuttons(array_get,chunk_get) {
  array = array_get;
  chunk = chunk_get;
  let x = array_get.length;
  $("#next_buttons").html('');
  if (x > chunk) {
    var n = 0;
    while (n < x) {
      n += chunk;
      let buttondiv = $("#next_buttons"),
          button = $(document.createElement('button')).attr("class", "m_Next").html(n / chunk).attr("id", "next-button")
      buttondiv.append(button);

    }
  }
}


function manager_branch_revenue(){
  let xValues = ['January','February','March','April','May','june','July','August','September','October','November','December'];

  new Chart("revenue_manager", {
    type: "line",
    data: {
      labels: xValues,
      datasets: [{
        data: [860, 1140, 1060, 1060, 1070, 1110, 1330, 2210, 7830, 2478],
        borderColor: "red",
        fill: false
      }]
    },
    options: {
      legend: {display: false}
    }
  });
}


function manager_branch_revenue_report(){
  let xValues = ['January','February','March','April','May','june','July','August','September','October','November','December'];

  new Chart("revenue_manager_report", {
    type: "line",
    data: {
      labels: xValues,
      datasets: [{
        data: [860, 1140, 1060, 1060, 1070, 1110, 1330, 2210, 7830, 2478],
        borderColor: "red",
        fill: false
      }]
    },
    options: {
      legend: {display: false}
    }
  });
}




function DuePaymentReport(){
  let xValues = [100,200,300,400,500,600,700,800,900,1000];

  new Chart("man_chart2", {
    type: "line",
    data: {
      labels: xValues,
      datasets: [{
        data: [860, 1140, 1060, 1060, 1070, 1110, 1330, 2210, 7830, 2478],
        borderColor: "red",
        fill: false
      }, {
        data: [1600, 1700, 1700, 1900, 2000, 2700, 4000, 5000, 6000, 7000],
        borderColor: "green",
        fill: false
      }, {
        data: [300, 700, 2000, 5000, 6000, 4000, 2000, 1000, 200, 100],
        borderColor: "blue",
        fill: false
      }]
    },
    options: {
      legend: {display: false}
    }
  });
}

function MaintainenceReport(){
  let xValues = [100,200,300,400,500,600,700,800,900,1000];

  new Chart("man_chart3", {
    type: "line",
    data: {
      labels: xValues,
      datasets: [{
        data: [860, 1140, 1060, 1060, 1070, 1110, 1330, 2210, 7830, 2478],
        borderColor: "red",
        fill: false
      }, {
        data: [1600, 1700, 1700, 1900, 2000, 2700, 4000, 5000, 6000, 7000],
        borderColor: "green",
        fill: false
      }, {
        data: [300, 700, 2000, 5000, 6000, 4000, 2000, 1000, 200, 100],
        borderColor: "blue",
        fill: false
      }]
    },
    options: {
      legend: {display: false}
    }
  });
}