function Branchvisibility(){
  var x =document.getElementById("designation").value;
  if (x=="Maintainer")
  {
    document.getElementById("branch_name_employee").style.opacity=0.1;
    // document.getElementById("employee_branch_name").disabled=true;

  }
  else{
    // document.getElementById("employee_branch_name").disabled=false;
    document.getElementById("branch_name_employee").style.opacity=1;
  }
}

//function to print branch name and branch id
function printbranchesemployeeform (){
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

      $('#employee_branch_name').append(
          `<option value=${x.branch_id}>${x.branch_name}</option>`
      );
    });

  }).fail(function(a,b,err){
    alert("Error");
    console.log(a,b,err);
  });

}

function getEmployeeId(value){
  $.ajax({
    method:'POST',
    url:"employeeid",
    data: {
      designation: value
    },
    // contentType:"application/json",
  }).done(function(result){
    console.log(result);
    document.getElementById("employee_id").value = result;

  }).fail(function(a,b,err){
    alert("Error");
    console.log(a,b,err);
  });

}
