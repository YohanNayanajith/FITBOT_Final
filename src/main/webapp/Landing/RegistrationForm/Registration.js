//country selector
// $(function () {
//     $("#country").change(function() {
//         var val = $(this).val();
//         var text = $("#country option:selected").text();
//         $("#selected_country").html(val + '<br>' + text);
//     });
// });

console.log("Iam back");

// client-side form validate
function regFormValidate(frm) {
    // read form data
    let dob = frm.date_of_birth.value;
    let phoneNo = frm.phone_number.value;
    let country = frm.selected_country.value;
    let password = frm.reg_password.value;
    let confirmPassword = frm.confirm_password.value;
    let membershipType = frm.membership_type.value;
    let membershipCategory = frm.membership_category.value;
    let height = frm.height.value;
    let weight = frm.weight.value;
    let flag = true;

    // client side form validation logic
    const date = new Date();
    let year_age = date.getFullYear() - dob.getFullYear();
    let month_age = date.getMonth() - dob.getMonth();
    let date_age = date.getDate() - dob.getDate();

    if((year_age >= 14 && year_age <= 80)){
        alert("Person age must be between 14 to 80");
        frm.date_of_birth.focus();
        console.log("Age verify")
        flag = false;
    }
    if(!(password === confirmPassword)){
        alert("Password and confirm password must be equal");
        frm.confirm_password.focus();
        flag = false;
    }
    if(!(height >= 80 && height <= 250)){
        alert("Person height must be between 80cm to 250cm");
        let height_value = document.getElementById("height");
        height_value.style.borderColor = "red";
        frm.height.focus();
        flag = false;
    }
    if(!(weight >= 28 && weight <= 150)){
        alert("Person weight must be between 28kg to 150kg");
        let weight_value = document.getElementById("weight");
        weight_value.style.borderColor = "red";
        frm.weight.focus();
        flag = false;
    }

    console.log(dob);
    console.log(phoneNo);
    console.log(country);
    console.log(password);
    console.log(confirmPassword);
    console.log(membershipType);
    console.log(membershipCategory);
    console.log(height);
    console.log(weight);


    return flag;
    // true => form is error free
    // false => form validation errors
}

function branch_select(){
    // alert("branch");
    let member_type = $('#membership_type').val();

    if(member_type == "virtual_member"){
        $("#branch_type").attr("disabled", true);
        $('#branch_type').css("border-bottom", "2px solid grey");
        $('#branch_type_label').css("color", "grey");
        document.getElementById("branch_type").value = "none";

        $("#membership_category").attr("disabled", true);
        $('#membership_category').css("border-bottom", "2px solid grey");
        $('#membership_category_label').css("color", "grey");
        document.getElementById("membership_category").value = "none";

    }else if(member_type == "physical_member"){
        $("#branch_type").attr("disabled", false);
        $('#branch_type').css("border-bottom", "2px solid #0E2C4B");
        $('#branch_type_label').css("color", "black");

        $("#membership_category").attr("disabled", false);
        $('#membership_category').css("border-bottom", "2px solid #0E2C4B");
        $('#membership_category_label').css("color", "black");
    }

}

$(document).ready(function(){
    $('#verify_email_register').hide();

});

function close_verify_email_register(){
    $('#verify_email_register').hide();
}

function back_verify_email_register(){
    $('#verify_email_register').hide();
}

function forward_verify_email_register(){
    //open_confirm_password_Popup();

    let verify_code = $('#verify_detail_name').val();

    $.ajax({
        method:"POST",
        url:"verifyEmail",
        data: {verify_code:verify_code},
        // dataType:"json",
        // contentType:"application/json",
        success: function (result){
            if(result.trim() == "1"){

                Swal.fire({
                    title: 'Email Verified',
                    // text: "Registration is not completed,You won't be able to revert this!",
                    icon: 'success',
                    showCancelButton: false,
                    confirmButtonColor: '#0E2C4B',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Ok'
                }).then((result) => {
                    if (result.isConfirmed) {
                        window.location.href ="http://localhost:8080/group39_fitbot_war_exploded/medical";
                    }
                    // else if (result.isDenied){
                    //     // Swal.fire('Changes are not saved', '', 'info')
                    //     console.log("Log out cancel");
                    // }
                })

                // Swal.fire({
                //     icon: 'success',
                //     title: 'Email Verified',
                //     // text: 'Password is successfully updated!',
                //     confirmButtonText:"Ok",
                //     confirmButtonColor: '#0E2C4B',
                // })
                // console.log("verify email is correct");
                // $('#reset_new_password_container').hide();
                // window.location.href ="http://localhost:8080/group39_fitbot_war_exploded/medical";
            }else{
                console.log(result);
                Swal.fire({
                    icon: 'error',
                    title: 'Try Again',
                    text: 'Your verify code is incorrect!',
                    confirmButtonText:"Ok",
                    confirmButtonColor: '#932828',
                })
                // window.location.href ="http://localhost:8080/group39_fitbot_war_exploded/register";
            }
        },
        error: function(err){
            console.log("phone number wrong", err);
            window.location.href ="http://localhost:8080/group39_fitbot_war_exploded/register";
            // Swal.fire({
            //     icon: 'error',
            //     title: 'Try Again',
            //     text: 'System issue!',
            //     confirmButtonText:"Ok",
            //     confirmButtonColor: '#932828',
            // })
        }
    });
}