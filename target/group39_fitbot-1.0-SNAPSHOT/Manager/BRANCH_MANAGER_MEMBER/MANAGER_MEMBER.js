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