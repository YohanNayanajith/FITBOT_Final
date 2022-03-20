function own_dashboard() {
    let anchor_dashboard = document.getElementById("owner_dashboard");
    let anchor_dashboard_i = document.getElementById("owner_dashboard_i");
    let anchor_dashboard_text = document.getElementById("owner_dashboard_text");
    // console.log("mokada meee dashboard");
    anchor_dashboard.style.backgroundColor = "white";
    anchor_dashboard_i.style.color = "black";
    anchor_dashboard_text.style.color = "black";
  }

function ownerincomechart() {
    var xValues = ["Physical Members", "Virtual Members"];
    var yValues = [55, 49];
    var barColors = [
        "#b91d47",
        "#00aba9"
    ];

    new Chart("myIncomeChart", {
        type: "line",
        data: {
            labels: xValues,
            datasets: [{
                backgroundColor: barColors,
                data: yValues
            }]
        },
        options: {
            title: {
                display: true,
                text: "Members"
            }
        }
    });
}

function memberRegisteringCharts() {
    $.ajax({
        method: "POST",
        url: "memberregisteringcount",
        dataType: "json",
        // contentType:"application/json",
        success: function (result) {
            console.log(result);
            let arrMonth = new Array();
            let arrCount = new Array();
            var barColors = ["blue", "green","yellow","orange","brown"];
            i =0;

            $.map(result, function (x) {
                arrMonth[i] = x[",month"];
                arrCount[i] = x["member_count"];
                i += 1;
            });

            // let xValues = [100,200,300,400,500,600,700,800,900,1000];

            new Chart("memberregisteringchart", {
                type: "line",
                data: {
                    labels: arrMonth,
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

function dashboardcount(){
    alert("Faalil");
    $.ajax({
        method:'POST',
        url:"ownerdashboardcount",
        dataType:'json',
        // contentType:"application/json",
    }).done(function(result){
        $('#new_members').html('');
        $('#all_employees_gym').html('');
        $('#all_members_gym').html('');
        $('#income_gym').html('');

        $('#new_members').append(

            `<p>${result[0]}</p>`
        );
        $('#all_members_gym').append(

            `<p>${result[1]}</p>`
        );
        $('#all_employees_gym').append(

            `<p>${result[2]}</p>`
        );

        $('#income_gym').append(

            `<p>${result[3]}</p>`
        );


        // alert(result);
        // alert("Data is comming babe");
    }).fail(function(a,b,err){
        alert("Error");
        console.log(a,b,err);
    });
}
