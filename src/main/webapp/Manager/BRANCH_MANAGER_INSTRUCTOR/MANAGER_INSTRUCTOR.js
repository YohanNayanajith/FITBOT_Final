function manager_instructor_page() {
    let anchor_instructor = document.getElementById("man_instructor");
    let anchor_instructor_i = document.getElementById("man_instructor_i");
    let instructor_text = document.getElementById("manager_instructor_page_text");
    console.log("mokada meee dashboard");
    anchor_instructor.style.backgroundColor = "white";
    anchor_instructor_i.style.color = "black";
    instructor_text.style.color = "black";
  }


function searchinstructor(){
    $('#manager_instructor_search').keyup(function(){
        // alert("yohan2");
        let value = $(this).val().toLowerCase();
        $('.manager_instructor_row').filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
}