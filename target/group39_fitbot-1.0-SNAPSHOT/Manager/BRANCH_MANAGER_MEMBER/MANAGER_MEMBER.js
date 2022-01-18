function manager_member_page() {
    let anchor_member = document.getElementById("man_member");
    let anchor_member_i = document.getElementById("man_member_i");
    let member_text = document.getElementById("manager_member_page_text");
    console.log("mokada meee dashboard");
    anchor_member.style.backgroundColor = "white";
    anchor_member_i.style.color = "black";
    member_text.style.color = "black";
  }


function searchmember(){
    $('#manager_member_search').keyup(function(){
        // alert("yohan2");
        let value = $(this).val().toLowerCase();
        $('.manager_member_row').filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
}



function initiateMembeNextButtons(result,chunk) {
    //initiate the buttons
    $(`[id^=next-button]*`).each(function () {
        console.log(this)
        $(this).on("click", function () {
            // console.log($(this).html())
            let pageno = parseInt($(this).html());
            $("#ins_manager_details_table_tbody").html(' ')
            $.map(result.slice(pageno * chunk - chunk, pageno * chunk), function (x) {
                $('#ins_manager_mem_details_table_tbody').append(
                    '<tr class="manager_member_row">' +
                    '<td>' + (x.firstname + " " + x.lastname) + '</td>' +
                    '<td>' + ((x.membertype).replace("_", " ")) + '</td>' +
                    '<td>' + x.intructorname + '</td>' +
                    '<td>' + '<input type="checkbox" class="atte"/>' +
                    '</td>' +
                    '</tr>'
                );
            })
        })
    })
}


