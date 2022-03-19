//function to print branch name and branch id
function branchesviewlanding (){
    // alert('Faalil');
    $.ajax({
        method:'POST',
        url:"adminbranch",
        dataType:'json',
        // contentType:"application/json",
    }).done(function(result){
        $('#branch_landing_view').html('')
        console.log(result);
        $.map(result,function(x){
            $('#branch_landing_view').append(

                ` <div class="branch_view1">
            <div class="content_branch">
                <div class="image_branch1"><img src="${x.branch_image}"> </div>
                <div class="name"><p>${x.branch_name}</p></div>
                <div class="rectangle"></div>
                <div class="cantact_no">
                    <ul>
                        <li>Office-<span>${x.branch_primary_contact}</span></li>
                        <li>${x.branch_secondary_contact}</li> 
                    </ul>
                </div>
            </div>
            <div class="eye_mark">
                <i class="fas fa-eye"></i>
            </div>
        </div>`);
        });

    }).fail(function(a,b,err){
        alert("Error");
        console.log(a,b,err);
    });

}