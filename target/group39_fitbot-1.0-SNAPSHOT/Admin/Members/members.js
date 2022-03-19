function adm_members() {
  let anchor_members = document.getElementById("admin_members");
  let anchor_members_i = document.getElementById("admin_members_i");
  let anchor_members_text = document.getElementById("admin_members_text");
  // console.log("mokada meee dashboard");
  anchor_members.style.backgroundColor = "white";
  anchor_members_i.style.color = "black";
  anchor_members_text.style.color = "black";
}

function banning(){
  $("#banning_reason").show();
  $("#ban_buttons_visibile").hide();
}

//Popup of eachmemberview
function memberview_popup(memberid,status,type){
  alert(memberid);
  $.ajax({
    method:'POST',
    url:"adminmemberview",
    dataType:'json',
    data : {
      member_id : memberid,
      banned_status : status,
      member_type: type
    },
    // contentType:"application/json",
  }).done(function(result){
    $('#member_title_values').html('');
    $('#member_name_head').html('');
    $('#ban_button').html('');
    $("#ban_buttons_visibile").show();
    $('#banned_values').html('');
    $('#buttonsforbanning').html('');
        $('#member_name_head').append(
            `<h1>${result.first_name + ' ' + result.last_name}</h1>`
        );
    if (status =="banned")
    {
      $('#banned_values').append(
          `<li>Banned For</li><li>Banned on</li>`
      );
      $('#member_title_values').append(
          `<ul><li>${result.first_name + ' ' + result.last_name}</li><li>${result.gender}</li><li>${result.contact_no}</li><li>${result.email}</li><li>${result.branch_name}</li><li>${result.type}</li><li>${result.membership}</li><li>${result.due_date["day"] + '/' + result.due_date["month"] + '/' + result.due_date["year"]}</li><li>${result.banned_reason}</li><li>${result.banned_date["day"] + '/' + result.banned_date["month"] + '/' + result.banned_date["year"]}</li></ul>`
      );
      $('#ban_button').append(
          ` <input type="button" class =" banned_button" value="UnBan" onclick="banning()">`
      );
    }
    else {
      $('#member_title_values').append(
          `<ul><li>${result.first_name + ' ' + result.last_name}</li><li>${result.gender}</li><li>${result.contact_no}</li><li>${result.email}</li><li>${result.branch_name}</li><li>${result.type}</li><li>${result.membership}</li><li>${result.due_date["day"] + '/' + result.due_date["month"] + '/' + result.due_date["year"]}</li></ul>`
      );
      $('#ban_button').append(
          ` <input type="button" class =" banned_button" value="Ban" onclick="banning()">`
      );

      $('#buttonsforbanning').append(
      `<input type="button" class=" banned_button" value="Submit" onclick="ban_member('${result.member_id}')">
        <input type="button" class=" banned_button" value="Cancel" onclick="">`
    );
    }

  }).fail(function(a,b,err){
    alert("Error");
    console.log(a,b,err);
  });


  $('#member_view').show();
}

//Clsoing of Employeevie
function close_memberview_Popup() {
  $('#member_view').hide();
  $("#banning_reason").hide();
}

//Function to print the memberstable
function printmember(){
  $.ajax({
    method:'POST',
    url:"adminmember",
    dataType:'json',
    data: {
      type: "All"
    },
    // contentType:"application/json",
  }).done(function(result){
    $('#member_list_table_body').html('');
    document.getElementById("member_title_table").innerHTML = "All Members";;
    console.log(result);
    $.map(result,function(x){
        $('#member_list_table_body').append(
            `<tr class="member_info"><td>${x.member_id}</td><td>${x.first_name + ' ' + x.last_name}</td><td>${x.type}</td><td>${x.branch_name}</td><td>${x.membership}</td><td>${x.due_date["day"] + '/'+x.due_date["month"] + '/'+x.due_date["year"]}</td><td><a onclick="memberview_popup('${x.member_id}','Unbanned','${x.type}')"><i class='bx bxs-show bx-tada bx-flip-horizontal view_popup' ></i></a>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>`
        );

    });
    searchmember();

  }).fail(function(a,b,err){
    alert("Error");
    console.log(a,b,err);
  });

}

function searchmember(){
  $('#search_member').keyup(function(){
    // alert("yohan2");
    let value = $(this).val().toLowerCase();
    $('.member_info').filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
}

//employeecount function of ajax
function membercount(){
  $.ajax({
    method:'POST',
    url:"adminmembercount",
    dataType:'json',
    // contentType:"application/json",
  }).done(function(result){
    $('#physicalcount').html('');
    $('#virtualcount').html('');
    $('#bannedcount').html('');
    $('#all_member_count').html('');

    $('#physicalcount').append(

        `<p>${result[0]}</p>`
    );
    $('#virtualcount').append(

        `<p>${result[1]}</p>`
    );
    $('#bannedcount').append(

        `<p>${result[2]}</p>`
    );

    $('#all_member_count').append(

        `<p>${result[0]+result[1]+result[2]}</p>`
    );


    // alert(result);
    // alert("Data is comming babe");
  }).fail(function(a,b,err){
    alert("Error");
    console.log(a,b,err);
  });
}

// function printmembers(name){
//     let value = name.toLowerCase();
//     $('.member_info').filter(function() {
//       $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
//     });
// }



//function to print the banned members
function printbannedmembers()
{
  $.ajax({
    method:'POST',
    url:"adminmember",
    dataType:'json',
    data : {
      type: "Banned"
    },
    // contentType:"application/json",
  }).done(function(result){
    $('#member_list_table_body').html('');
    document.getElementById("member_title_table").innerHTML = "Banned Members";
    console.log(result);
    $.map(result,function(x){
      $('#member_list_table_body').append(
          `<tr class="member_info"><td>${x.member_id}</td><td>${x.first_name + ' ' + x.last_name}</td><td>${x.type}</td><td>${x.branch_name}</td><td>${x.membership}</td><td>${x.due_date["day"] + '/'+x.due_date["month"] + '/'+x.due_date["year"]}</td><td><a onclick="memberview_popup('${x.member_id}','banned')"><i class='bx bxs-show bx-tada bx-flip-horizontal view_popup' ></i></a>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>`
      );

    });
    searchmember();

  }).fail(function(a,b,err){
    alert("Error");
    console.log(a,b,err);
  });
}

function ban_member(member_id){


  let banned_reason = $('#ban_reason').val();

  if (banned_reason.length=="")
  {
    $('#validation_ban_id').show();
    return false;

  }

  alert(member_id);
  $.ajax({
    method: 'POST',
    url: "adminbanmember",
    data: {
      member_id: member_id,
      banned_reason: banned_reason
    },
    // contentType:"application/json",
  }).done(function (result) {

    if (result == "1") {
      $('#banning_reason input[type="text"]').val('');
      Swal.fire({
        icon: 'success',
        title: "Successfully Banned",
        text: 'Employee Banned!',
        confirmButtonText: '<i class="fa fa-thumbs-up"></i> Success',
        confirmButtonColor: '#0E2C4B',
        footer: '<a href="#">View Employee</a>'
      });
      $('#member_view').hide();
      membercount();
      printmember();
    }
    if (result == "0") {
      Swal.fire({
        icon: 'error',
        title: "Cannot be Banned",
        // text: 'Check for Primary Values',
        confirmButtonText: '<i class="fa fa-thumbs-up"></i> Try Again',
        confirmButtonColor: '#0E2C4B',
        // footer: '<a href="#" onclick=">View Employee</a>'
      });
    }

  }).fail(function (a, b, err) {

    // alert("Faalil");
    Swal.fire({
      icon: 'error',
      title: "Can't register...",
      text: 'Something went wrong!',
      confirmButtonText: '<i class="fa fa-thumbs-up"></i> Try Again!!!',
      confirmButtonColor: '#0E2C4B',
      footer: '<a>Register again</a>'
    });
    console.log(a, b, err);
  });
}

//Function to print the physical members
function printphysicalmember(){
  $.ajax({
    method:'POST',
    url:"adminmember",
    dataType:'json',
    data: {
      type: "Physical"
    },
    // contentType:"application/json",
  }).done(function(result){
    $('#member_list_table_body').html('');
    document.getElementById("member_title_table").innerHTML = "Physical Members";
    console.log(result);
    $.map(result,function(x){
      $('#member_list_table_body').append(
          `<tr class="member_info"><td>${x.member_id}</td><td>${x.first_name + ' ' + x.last_name}</td><td>${x.type}</td><td>${x.branch_name}</td><td>${x.membership}</td><td>${x.due_date["day"] + '/'+x.due_date["month"] + '/'+x.due_date["year"]}</td><td><a onclick="memberview_popup('${x.member_id}','Unbanned','${x.type}')"><i class='bx bxs-show bx-tada bx-flip-horizontal view_popup' ></i></a>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>`
      );

    });
    searchmember();

  }).fail(function(a,b,err){
    alert("Error");
    console.log(a,b,err);
  });

}


//function to print the virtual members
function printvirtualmember(){
  $.ajax({
    method:'POST',
    url:"adminmember",
    dataType:'json',
    data: {
      type: "Virtual"
    },
    // contentType:"application/json",
  }).done(function(result){
    $('#member_list_table_body').html('');
    document.getElementById("member_title_table").innerHTML = "VirtualMembers";
    console.log(result);
    $.map(result,function(x){
      $('#member_list_table_body').append(
          `<tr class="member_info"><td>${x.member_id}</td><td>${x.first_name + ' ' + x.last_name}</td><td>${x.type}</td><td>${x.branch_name}</td><td>${x.membership}</td><td>${x.due_date["day"] + '/'+x.due_date["month"] + '/'+x.due_date["year"]}</td><td><a onclick="memberview_popup('${x.member_id}','Unbanned','${x.type}')"><i class='bx bxs-show bx-tada bx-flip-horizontal view_popup' ></i></a>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>`
      );

    });
    searchmember();

  }).fail(function(a,b,err){
    alert("Error");
    console.log(a,b,err);
  });

}





