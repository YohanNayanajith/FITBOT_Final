function physical_member_instructors(){
    let instructors_workout = document.getElementById("phy_mem_instructors");
    let instructors_workout_i = document.getElementById("phy_mem_instructors_i");
    let instructors_text = document.getElementById("physical_member_instructors_text");
    instructors_workout.style.backgroundColor = "white";
    instructors_workout_i.style.color = "black";
    instructors_text.style.color = "black";
}
function open_instructor_details(){
    // $('#instructors_physical_container_detail_popup').toggle();
}

// $(document).ready(function(){
//
// });

let count_payment = 0;

function payments_pay_instructor(instructorPrice,instructor_id){
    // md5sig = strtoupper (md5 ( merchant_id + order_id + payhere_amount + payhere_currency + status_code + strtoupper(md5(payhere_secret)) ) );

    //fillCustomerDetails();
    editPaymentBackgroundOn();

    //payment ID calculation
    countPaymentId("order_id1");

    $.ajax({
        method:"POST",
        url:"memberDetails",
        dataType:"json",
        // contentType:"application/json",
        success: function (result){
            console.log(result);
            document.getElementById("first_name1").value = result["first_name"];
            document.getElementById("last_name1").value = result["last_name"];
            document.getElementById("email1").value = result["email"];
            document.getElementById("phone1").value = result["contact_number"];
            document.getElementById("address1").value = result["address"];
            //document.getElementById("city").value = result["first_name"];

            let idPaimentCus = ["first_name1","last_name1","email1","phone1","address1"];

            $.each(idPaimentCus,function(index,result_value){
                $('#'+result_value).css("border", "2px solid grey");
                $('#'+result_value).css("color", "grey");
            });

            let idNamesMembership = ["expiry_day1","items1"];
            let dataNames = ["expiry_day","membership_category"];

            console.log("Instructor Price "+instructorPrice);
            document.getElementById("amount1").value = instructorPrice;
            $('#amount1').css("border", "2px solid grey");
            $('#amount1').css("color", "grey");

            if(count_payment == 0){
                $.ajax({
                    method:'POST',
                    url:"membership",
                    dataType:'json',

                }).done(function(data){
                    console.log(data);

                    if(data["has_instructor"].trim().toString() == "0"){
                        $.each(idNamesMembership,function(index,result_value){
                            let name = dataNames[index].toString();
                            if(name == dataNames[0]){
                                let nameObject = {};
                                nameObject = data[name];
                                let nameStr = nameObject["year"]+"-"+nameObject["month"]+"-"+nameObject["day"];
                                document.getElementById(result_value).value = nameStr;
                                $('#'+result_value).css("border", "2px solid grey");
                                $('#'+result_value).css("color", "grey");
                            }else{
                                document.getElementById(result_value).value = data[name];
                                // $('#'+result_value).attr("disabled", true);
                                $('#'+result_value).css("border", "2px solid grey");
                                $('#'+result_value).css("color", "grey");
                            }
                        });
                    }else {
                        $('#after_payment_popup_instructor_details').hide();
                        editPaymentBackgroundOff();
                        Swal.fire({
                            icon: 'error',
                            title: 'You already have an instructor!',
                            // text: 'Logout unsuccessfully!',
                            confirmButtonText:"Ok",
                            confirmButtonColor: '#932828',
                        })
                    }

                }).fail(function(a,b,err){
                    //alert("Error");
                    console.log(a,b,err)
                });
            }

            document.getElementById("currency1").value = "LKR";
            // $('#currency').attr("disabled", true);
            $('#currency1').css("border", "2px solid grey");
            $('#currency1').css("color", "grey");
            count_payment+=1;

        },
        error: function(error){
            console.log(error+"payment");
        }
    });
}