function adm_reports() {
    let anchor_reports = document.getElementById("admin_reports");
    let anchor_reports_i = document.getElementById("admin_reports_i");
    let anchor_reports_text = document.getElementById("admin_reports_text");
    // console.log("mokada meee dashboard");
    anchor_reports.style.backgroundColor = "white";
    anchor_reports_i.style.color = "black";
    anchor_reports_text.style.color = "black";
  }


function viewBranchEquipmentCount(){
    alert("I am on the way");
    let xValues = [100,200,300,400,500,600,700,800,900,1000];

    new Chart("branch_equipment_count", {
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
        type: "bar",
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

function viewBranchMemberCount() {
    $.ajax({
        method: "POST",
        url: "branchmembercount",
        dataType: "json",
        // contentType:"application/json",
        success: function (result) {
            console.log(result);
            let arrBranch = new Array();
            let arrCount = new Array();
            var barColors = ["blue", "green","yellow","orange","brown"];
            i =0;

            $.map(result, function (x) {
                arrBranch[i] = x["branch_name"];
                arrCount[i] = x["branchmember_count"];
                i += 1;
            });

            // let xValues = [100,200,300,400,500,600,700,800,900,1000];

            new Chart("branch_member_count", {
                type: "bar",
                data: {
                    labels: arrBranch,
                    datasets: [{
                        data: arrCount,
                        backgroundColor: barColors

                    }]
                },
                options: {
                    legend: {display: false},
                    title: {
                        display: false
                    }
                }
            });
        },
        error: function (error) {
            console.log(error );
        }
    });
}