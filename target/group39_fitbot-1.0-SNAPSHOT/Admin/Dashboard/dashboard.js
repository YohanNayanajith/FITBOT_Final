function employeechart() {
  $.ajax({
    method:'POST',
    url:"employeecount",
    dataType:'json',
    // contentType:"application/json",
  }).done(function(result){
  var xValues = ["Instructors", "Maintainers","Branch Managers"];
  var yValues = [result.instructor_count,result.maintainer_count,result.branch_manager_count];
  var barColors = [
    "#00aba9",
    "#2b5797"
  ];

  new Chart("Employees", {
    type: "bar",
    data: {
      labels: xValues,
      datasets: [{
        barPercentage: 0.4,
        barThickness: 50,
        backgroundColor: barColors,
        data: yValues
      }]
    },
    options: {
      plugins:{
        legend: {
          display: false
        }
      },
      title: {
        display: true,
        text: "Members"
      }
    }
  });
  }).fail(function(a,b,err){
    alert("Error");
    console.log(a,b,err);
  });
}



function adm_dashboard() {
  let anchor_dashboard = document.getElementById("admin_dashboard");
  let anchor_dashboard_i = document.getElementById("admin_dashboard_i");
  let dashboard_text = document.getElementById("admin_dashboard_text");
  // console.log("mokada meee dashboard");
  anchor_dashboard.style.backgroundColor = "white";
  anchor_dashboard_i.style.color = "black";
  dashboard_text.style.color = "black";
}

function admindashboardcount(){
  // alert("Faalil");
  $.ajax({
    method:'POST',
    url:"admindashboardcount",
    dataType:'json',
    // contentType:"application/json",
  }).done(function(result){
    $('#new_members_admin').html('');
    $('#all_employees_gym_admin').html('');
    $('#all_members_gym_admin').html('');
    $('#branches_admin').html('');

    $('#new_members_admin').append(

        `<p>${result[0]}</p>`
    );
    $('#all_members_gym_admin').append(

        `<p>${result[1]}</p>`
    );
    $('#all_employees_gym_admin').append(

        `<p>${result[2]}</p>`
    );

    $('#branches_admin').append(

        `<p>${result[3]}</p>`
    );


    // alert(result);
    // alert("Data is comming babe");
  }).fail(function(a,b,err){
    alert("Error");
    console.log(a,b,err);
  });
}

function mychart() {

  $.ajax({
    method:'POST',
    url:"adminmembercount",
    dataType:'json',
    // contentType:"application/json",
  }).done(function(result){
  var xValues = ["Physical Members", "Virtual Members"];
  var yValues = [result[0], result[1]];
  var barColors = [
    "#00aba9",
    "#2b5797"
  ];

  new Chart("myChart", {
    type: "pie",
    data: {
      labels: xValues,
      datasets: [{
        backgroundColor: barColors,
        data: yValues
      }]
    },
    options :{
      title: {
        display: true,
        text: "Members"
      }
    }
  });
}).fail(function(a,b,err){
    alert("Error");
    console.log(a,b,err);
  });
}