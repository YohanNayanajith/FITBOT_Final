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

                ` <a href="#" onclick="branchdetails('${x.branch_id}')"><div class ="branch01">
                      <div class ="branch01_id">${x.branch_id}</div>
                      <div class ="branch01_name">${x.branch_name}</div>
                    </div> </a>`);
        });

    }).fail(function(a,b,err){
        alert("Error");
        console.log(a,b,err);
    });

}