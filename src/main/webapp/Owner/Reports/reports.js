function own_reports() {
    let anchor_reports = document.getElementById("owner_reports");
    let anchor_reports_i = document.getElementById("owner_reports_i");
    let anchor_reports_text = document.getElementById("owner_reports_text");
    // console.log("mokada meee dashboard");
    anchor_reports.style.backgroundColor = "white";
    anchor_reports_i.style.color = "black";
    anchor_reports_text.style.color = "black";
  }


function EmployeeCountChart(){
    alert("I am on the way");
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
            var barColors = ["blue", "green","yellow","orange","brown"];
            i =0;

            $.map(result, function (x) {
                arrBranch[i] = x["branch_name"];
                arrInsCount[i] = x["instructor_count"];
                arrBMCount[i] = x["branchmanager_count"];
                i += 1;
            });

            // let xValues = [100,200,300,400,500,600,700,800,900,1000];

            new Chart("employee_type", {
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

function ViewBranchEquipmentCount(){
    alert("BranchEquipmentCount");
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
                arrBranch[i] = x["branch_name"];
                arrCount[i] = x["equipment_count"];
                i += 1;
            });


            new Chart("equipmentcount", {
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
                    }
                }
            });
        },
        error: function (error) {
            console.log(error );
        }
    });
}

function ViewBranchMemberCount(){
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

            new Chart("member_statistics", {
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