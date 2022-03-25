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
    $.ajax({
        method: "POST",
        url: "branchequipmentcount",
        dataType: "json",
        // contentType:"application/json",
        success: function (result) {
            console.log(result);
            let arrBranch = new Array();
            let arrCount = new Array();
            i =0;

            $.map(result, function (x) {
                arrBranch[i] = x['X'];
                arrCount[i] = x['Y'];
                i += 1;
            });


            new Chart("branch_equipment_count", {
                type: "bar",
                data: {
                    labels: arrBranch,
                    datasets: [
                        {
                            label:"Equipments",
                            data: arrCount,
                            backgroundColor: "#2b5797"
                        }]

                },
                options: {
                    legend: {display: false},
                    title: {
                        display: false
                    },
                    scales: {
                        xAxes: [{
                            maxBarThickness: 100
                        }]
                    },
                }
            });
        },
        error: function (error) {
            console.log(error );
        }
    });
}
function ViewAdminEmployee(){
    $.ajax({
        method: "POST",
        url: "employeetypecount",
        dataType: "json",
        // contentType:"application/json",
        success: function (result) {
            console.log(result);
            let arrBranch = new Array();
            let arrInsCount = new Array();
            let arrBMCount =new Array();
            i =0;

            $.map(result, function (x) {
                arrBranch[i] = x['X'];
                arrInsCount[i] = x['Y1'];
                arrBMCount[i] = x['Y2'];
                i += 1;
            });

            // let xValues = [100,200,300,400,500,600,700,800,900,1000];

            new Chart("admin_employee", {
                type: "bar",
                data: {
                    labels: arrBranch,
                    datasets: [{
                        label:"Instructors",
                        data: arrInsCount,
                        backgroundColor: "#00aba9"
                    },
                        {
                            label:"Branch Manager",
                            data: arrBMCount,
                            backgroundColor: "#2b5797"
                        }]
                },
                options: {
                    legend: {display: true},
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
            let arrBanCount =new Array();
            i =0;

            $.map(result, function (x) {
                arrBranch[i] = x["branch_name"];
                arrCount[i] = x["unbanmember_count"];
                arrBanCount[i]=x["banmember_count"]
                i += 1;
            });

            // let xValues = [100,200,300,400,500,600,700,800,900,1000];

            new Chart("branch_member_count", {
                type: "bar",
                data: {
                    labels: arrBranch,
                    datasets: [{
                        label :"Active Members",
                        data: arrCount,
                        backgroundColor: "#00aba9"
                    },
                        {
                            label:"Banned Member",
                            data: arrBanCount,
                            backgroundColor: "#2b5797"
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