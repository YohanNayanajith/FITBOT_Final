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


var sideBar_links_variable = "#maintainer_dashboard_implementation";

function page_select(sideBar_links_variable){
  if(sideBar_links_variable == "#maintainer_dashboard_implementation"){
    $('#maintainer_dashboard_implementation').hide();
    clear_dashboard_functions("maintainer_dashboard","maintainer_dashboard_i","maintainer_dashboard_text");
    console.log("dashboard");

    //Maintainer Requests
  }else if(sideBar_links_variable == "#maintain_requests"){
    $('#maintain_requests').hide();
    clear_dashboard_functions("maintainer_requests","maintainer_requests_i","maintainer_requests_text");
    console.log("requests");
  }

  //Equipments
  else if(sideBar_links_variable == "#maintain_equipments"){
    $('#maintain_equipments').hide();
    clear_dashboard_functions("maintainer_equipments","maintainer_equipments_i","maintainer_equipments_text");
    console.log("Equipments");
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

var load = [0,0,0,0,0,0,0,0,0,0,0];


//dashboard
$(document).ready(function(){
  $('#maintainer_dashboard_implementation').load('http://localhost:8080/group39_fitbot_war_exploded/Maintainer/Dashboard/dashboard.html #dashboard_maintainer', function (responseTxt, statusTxt, xhr) {

    if (statusTxt == "error") {
      alert("Error: " + xhr.status + ": " + xhr.statusText);
    }

    getCalender();
    load[0] += 1;
  });
});


//dashboard
$(document).ready(function (){
  $('#maintainer_dashboard').click(function (){
    if (load[0] == 0) {
      load[0] += 1;
      console.log(load);

    } else if (sideBar_links_variable == "#maintainer_dashboard_implementation") {
      return;
    } else {
      page_select(sideBar_links_variable);
      sideBar_links_variable = "#maintainer_dashboard_implementation";
      $('#maintainer_dashboard_implementation').show();
    }
  });


  // Maintainer Requests
  $('#maintainer_requests').click(function () {
    page_select(sideBar_links_variable);
    sideBar_links_variable = "#maintain_requests";

    if (load[1] == 0) {
      $(sideBar_links_variable).load('http://localhost:8080/group39_fitbot_war_exploded/Maintainer/Requests/requests.html #maintain_requests_view', function (responseTxt, statusTxt, xhr) {
        reloadRequestData();


        if (statusTxt == "error")
          alert("Error: " + xhr.status + ": " + xhr.statusText);
      });
      load[1] += 1;
    } else {
      $('#maintain_requests').show();
    }
  });


//Maintainer Equipments
  $('#maintainer_equipments').click(function () {
    page_select(sideBar_links_variable);
    sideBar_links_variable = "#maintain_equipments";



    if (load[2] == 0) {
      $(sideBar_links_variable).load('http://localhost:8080/group39_fitbot_war_exploded/Maintainer/Equipments/equipments.html #equipment_view_maintainer', function (responseTxt, statusTxt, xhr) {
        loadBranchName();
        let Equipments_id = $('#search_equipment_by_ID').val();
        let Branch_selecter = $('#select_Filter_List').val();
        let List_order = $('#select_Filter_List_order').val();
        console.log(Equipments_id);
        console.log(Branch_selecter);
        console.log(List_order);
        reloadEquipmentsData(Equipments_id,Branch_selecter,List_order);
        if (statusTxt == "error") {
          alert("Error: " + xhr.status + ": " + xhr.statusText);
        }
      });
      load[2] += 1;
    } else {
      $('#maintain_equipments').show();
    }
  });
});



// $('#button1').on('click', ()=>{
//
//   ChangeStatus();
//
// })

// function ChangeStatus(){
//   alert("Shalani aaaaaaaaaa");
//
//     // alert("check allll");
//     // let form_id = $('#login_username').val()
//
//     $.ajax({
//       method:'POST',
//       url:"maintainerStatus",
//       // dataType:'json',
//       data: {form_id:1},
//       // data(form_id="form_id");
//
//     }).done(function(result){
//       // const data_object = JSON.parse(data);
//       alert(result);
//       if(result==true){
//
//       }else{
//
//       }
//     }).fail(function(a,b,err){
//       alert("Error");
//       console.log(a,b,err)
//     });
//
//     // $('#phy_mem_diet_plan').click(function(){
//
//     // });
//
// }
//



function reloadRequestData(){
  alert("call load function");
  var newCount =0;
  var progressCount =0;
  var completCount =0;

  $('#maintain_requ_tab_body').html(' ');
  $('#new_req_value').html(' ');
  $('#prog_req_value').html(' ');
  $('#compt_req_value').html(' ');
  $.ajax({
    method:'POST',
    url:"maintainerRequest",
    dataType: 'json',
    contentType: "application/json",
  }).done(function (result){
    console.log(result);
    result.forEach(element =>{
      // console.log(id);
      if(element.status == 'New'){
        newCount++;
        $('#maintain_requ_tab_body').append(`
            <tr class="request_details_row" id="request_details_row">
            <td> ${element.branch_id} </td>
            <td> ${element.equipment_type} </td>
            <td> ${element.re_date} </td>
            <td> ${element.comp_date} </td>
            <td> ${element.status} </td>
            <td> <div class="button"> <input type="button" id="button1" onclick="ChangeStatus(${element.form_id})"> <input type="button" id="button2"></div></td> 
            <td> <a value="View more" class="viewBtn"  id= "viewBtn" onclick="PopupForm(${element.form_id})">View more</a> </td>
            </tr>`
        );
      }
      else if (element.status == 'Progress'){
          progressCount++;
          $('#maintain_requ_tab_body').append(`
            <tr class="request_details_row" id="request_details_row">
            <td> ${element.branch_id} </td>
            <td> ${element.equipment_type} </td>
            <td> ${element.re_date} </td>
            <td> ${element.comp_date} </td>
            <td> ${element.status} </td>
            <td> <p></p></td> 
            <td> <a value="View more" class="viewBtn"  id= "viewBtn" onclick="PopupForm(${element.form_id})">View more</a> </td>
            </tr>`
          );
        }
      else if(element.status == 'Completed'){
          completCount++;
          $('#maintain_requ_tab_body').append(`
            <tr class="request_details_row" id="request_details_row">
            <td> ${element.branch_id} </td>
            <td> ${element.equipment_type} </td>
            <td> ${element.re_date} </td>
            <td> ${element.comp_date} </td>
            <td> ${element.status} </td>
            <td> <p></p></td> 
            <td> <a value="View more" class="viewBtn"  id= "viewBtn" onclick="PopupCompletForm(${element.form_id})">View more</a> </td>
            </tr>`
          );
        }
    })

    $('#new_req_value').append(
        '<h1>'+ newCount +'</h1>'
    );

    $('#prog_req_value').append(
        '<h1>'+ progressCount +'</h1>'
    );

    $('#compt_req_value').append(
        '<h1>'+ completCount +'</h1>'
    );


  }).fail(function (a,b,err) {
    alert("Data loading error  Shalani");
    console.log(a,b,err);
  });
}

// let id;
function ChangeStatus(fid){
  // console.log(fid);

  $.ajax({
    method:'POST',
    url:"maintainerStatus",
    data: {fid:fid}
    // dataType: 'json',
    // contentType: "application/json",
  }).done(function (result){
    // alert("Data is loading now"+result);
    // if (result.trim() == '1') {
    //
    //   alert("Data is loading now"+result);
    //   reloadRequestData();
    // }
    reloadRequestData();

  }).fail(function (a,b,err) {
    alert("Data loading error  Shalani");
    console.log(a,b,err);

  });
}

function log_out_function_maintainer(){
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

        // setTimeout(function() {
        //   Swal.fire({
        //     icon: 'success',
        //     title: 'Successfully Logout',
        //     // text: 'Password is successfully updated!',
        //     confirmButtonText:"Ok",
        //     confirmButtonColor: '#0E2C4B',
        //   })
        // }, 2000);
        // console.log("logout is correct");
        // window.location.href = "http://localhost:8080/group39_fitbot_war_exploded";
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


function getCalender(){
  // alert("Calender");
  // document.addEventListener('DOMContentLoaded', function() {
  let calendarEl = document.getElementById("calendar_maintainer");
  let calendar = new FullCalendar.Calendar(calendarEl, {
    initialView: 'dayGridMonth',
    headerToolbar: { center: 'dayGridMonth,timeGridWeek' }, // buttons for switching between views

    views: {
      dayGridMonth: { // name of view
        titleFormat: { year: 'numeric', month: '2-digit', day: '2-digit' }
        // other view-specific options here
      },
      timeGridWeek: { // name of view
        titleFormat: { year: 'numeric', month: '2-digit', day: '2-digit' }
        // other view-specific options here
      }
    }
  });
  calendar.batchRendering(function() {
    calendar.changeView('dayGridMonth');
    calendar.addEvent({ title: 'new event', start: '2021-12-08' });
  });
  calendar.render();
  // });
}


