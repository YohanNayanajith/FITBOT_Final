function adm_reports() {
    let anchor_reports = document.getElementById("admin_reports");
    let anchor_reports_i = document.getElementById("admin_reports_i");
    let anchor_reports_text = document.getElementById("admin_reports_text");
    // console.log("mokada meee dashboard");
    anchor_reports.style.backgroundColor = "white";
    anchor_reports_i.style.color = "black";
    anchor_reports_text.style.color = "black";
  }

// function viewBMI(chartName){
//
//     $.ajax({
//         method:"POST",
//         url:"updateWeightRetrive",
//         dataType:"json",
//         // contentType:"application/json",
//         success: function (result){
//             console.log(result);
//             let arrDate = new Array();
//             let arrWeight = new Array();
//             let todayDateNew;
//             let i = 0;
//
//             $.map(result,function(x){
//                 todayDateNew = x.update_date["year"]+"-"+("0"+x.update_date["month"]).slice(-2)+"-"+("0"+x.update_date["day"]).slice(-2);
//                 // arrDate[i] = x["update_date"];
//                 arrDate[i] = todayDateNew;
//                 arrWeight[i] = x["new_weight"];
//                 i += 1;
//             });
//
//             $.ajax({
//                 method:"POST",
//                 url:"memberDetails",
//                 dataType:"json",
//                 // contentType:"application/json",
//                 success: function (result){
//                     console.log(result);
//                     let height = parseFloat(result.height);
//                     let BMI;
//                     let arrBMI = new Array();
//                     arrWeight.forEach(calculateBMI);
//                     function calculateBMI(value, index, array){
//                         BMI = (parseFloat(value)*100*100)/(height*height)
//                         arrBMI[index] = BMI.toFixed(4);
//                     }
//
//                     new Chart(chartName, {
//                         type: "line",
//                         data: {
//                             labels: arrWeight,
//                             datasets: [{
//                                 label: 'BMI ',
//                                 // data: [860, 1140, 1060, 1060, 1070, 1110, 1330, 2210, 7830, 2478],
//                                 data: arrBMI,
//                                 borderColor: "blue",
//                                 fill: false
//                             }]
//                         },
//                         options: {
//                             title: {
//                                 display: true,
//                                 text: "BMI vs Weight"
//                             },
//                             legend: {display: true},
//                             scales: {
//                                 yAxes: [{
//                                     scaleLabel: {
//                                         display: true,
//                                         labelString: 'BMI'
//                                     }
//                                 }],
//                                 xAxes: [{
//                                     scaleLabel: {
//                                         display: true,
//                                         labelString: 'Weight'
//                                     }
//                                 }]
//                             }
//                         }
//                     });
//                 },
//                 error: function(error){
//                     console.log(error+"edit profile");
//                 }
//             });
//         },
//         error: function(error){
//             console.log(error+"edit profile");
//         }
//     });
// }

function viewCaloriesBurned(){
    alert("I am on the way");
    let xValues = [100,200,300,400,500,600,700,800,900,1000];

    new Chart("myChart2", {
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
function viewWorkoutPlanReports(){
    let xValues = [100,200,300,400,500,600,700,800,900,1000];

    new Chart("myChart3", {
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

function viewMonthlyGoalReports(){
    // alert("mama load venava");
    let xValues = [100,200,300,400,500,600,700,800,900,1000];

    new Chart("monthly_goal_chart", {
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