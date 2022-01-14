function Instructor_dashboard() {
    let anchor_dashboard = document.getElementById("ins_dashboard");
    let anchor_dashboard_i = document.getElementById("ins_dashboard_i");
    let dashboard_text = document.getElementById("Instructor_dashboard_text");
    console.log("mokada meee dashboard");
    anchor_dashboard.style.backgroundColor = "white";
    anchor_dashboard_i.style.color = "black";
    dashboard_text.style.color = "black";
}


$(document).ready(function(){
    $.ajax({
        method:'POST',
        url:"instructors",
        dataType:'json',

    }).done(function(maintainer){
        console.log(result);
        // alert(maintainer.first_name);

    }).fail(function(a,b,err){
        alert("Error name print");
        console.log(a,b,err)
    });

    // $('#phy_mem_diet_plan').click(function(){

    // });

});