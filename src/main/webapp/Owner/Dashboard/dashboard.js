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
