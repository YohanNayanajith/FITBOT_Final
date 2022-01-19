function accord() {
  // alert("faalil");
  var acc = document.getElementsByClassName("list_accordion");
  var i;

  for (i = 0; i < acc.length; i++) {
    acc[i].addEventListener("click", function () {
      this.classList.toggle("active");
      var panel = this.nextElementSibling;
      if (panel.style.maxHeight) {
        panel.style.maxHeight = null;
      } else {
        panel.style.maxHeight = panel.scrollHeight + "px";
      }
    });
  }
}

function adm_branches() {
  let anchor_branches = document.getElementById("admin_branches");
  let anchor_branches_i = document.getElementById("admin_branches_i");
  let branches_text = document.getElementById("admin_branches_text");
  // console.log("mokada meee branches");
  anchor_branches.style.backgroundColor = "white";
  anchor_branches_i.style.color = "black";
  branches_text.style.color = "black";
}



//function to print branch name and branch id
function printbranches (){
  // alert('Faalil');
  $.ajax({
    method:'POST',
    url:"adminbranch",
    dataType:'json',
    // contentType:"application/json",
  }).done(function(result){
    $('#branch_detail_list').html('')
    console.log(result);
    $.map(result,function(x){
      $('#branch_detail_list').append(

          ` <a href="#" onclick="branchdetails('${x.branch_id}')"><div class ="branch01">
                      <div class ="branch01_id">${x.branch_id}</div>
                      <div class ="branch01_name">${x.branch_name}</div>
                    </div> </a>`);
      // $('#employee_branch_name').append(
      //     `<option value="${x.branch_id}">${x.branch_name}</option>`
      // );
    });

  }).fail(function(a,b,err){
    alert("Error");
    console.log(a,b,err);
  });

}

//function to print details of all branches
function branchdetails(branchid) {
  $.ajax({
    method: 'POST',
    url: "branchview",
    data: {
      branch_id: branchid
    },
  }).done(function (result) {
    $('#branch_details').html('');
    console.log(result);
      $('#branch_details').append(
      `<div class="branch_number" id="branch_number">${result.branch_id}</div>
      <div class="line_vertical"></div>
      <div class="branch_info" id="branch_info">
        <div class="branch_name"> ${result.branch_name + '  ' + 'Branch'} </div>
        <div class="branch_contact">${result.branch_primary_contact + ' / ' + result.branch_secondary_contact}</div>
        <div class="branch_email">${result.branch_email}</div>
        <div class="branch_open">Opened On <span>${result.branch_date_of_commencement["day"] + ' - '+result.branch_date_of_commencement["month"] + ' - '+result.branch_date_of_commencement["year"]}</span></div>
      </div>`
      );


  }).fail(function (a, b, err) {
    alert("Error");
    console.log(a, b, err);
  });

  branchmanager_branch(branchid);
  instructor_branch(branchid);
}

//function to print branch manager names
function branchmanager_branch (branch_id)
{
  $.ajax({
    method: 'POST',
    url: "branchmanagerlist",
    data: {
      branch_id: branch_id
    },
  }).done(function (result) {
    $('#branchmanager_list').html('');
    console.log(result);
    $.map(result, function (x) {
      //alert(${x.branch_name});
      $('#branchmanager_list').append(
          ` <li> ${x.firstname + ' ' + x.lastname} <li>`
      );
    });

  }).fail(function (a, b, err) {
    alert("Error");
    console.log(a, b, err);
  });
}

//function to print instructor names
function instructor_branch (branch_id)
{
  $.ajax({
    method: 'POST',
    url: "instructorlist",
    data: {
      branch_id: branch_id
    },
  }).done(function (result) {
    $('#instructor_list').html('');
    console.log(result);
    $.map(result, function (x) {
      //alert(${x.branch_name});
      $('#instructor_list').append(
          ` <li> ${x.firstname + ' ' + x.lastname} <li>`
      );
    });

  }).fail(function (a, b, err) {
    alert("Error");
    console.log(a, b, err);
  });
}