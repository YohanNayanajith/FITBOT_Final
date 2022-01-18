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


function initiateInstructorNextButtons(result,chunk) {
    //initiate the buttons
    $(`[id^=next-button]*`).each(function () {
        console.log(this)
        $(this).on("click", function () {
            // console.log($(this).html())
            let pageno = parseInt($(this).html());
            $("#ins_manager_details_table_tbody").html(' ')
            $.map(result.slice(pageno * chunk - chunk, pageno * chunk), function (x) {
                $('#ins_manager_details_table_tbody').append(
                    '<tr class="manager_instructor_row">' +
                    '<td>' + (x.first_name + " " + x.last_name) + '</td>' +
                    '<td>' + x.mem_count + '</td>' +
                    '<td>' + x.appoinment_count + '</td>' +
                    '<td>' + '<input type="checkbox" class="ins_atte"/>' +
                    '</td>' +
                    '</tr>'
                );
            })
        })
    })
}

