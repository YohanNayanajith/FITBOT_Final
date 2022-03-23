let count = 0;
var paymentId = 0;
let checkStatus = 0;

function countPaymentId(order_id){
    $.ajax({
        method:'POST',
        url:"physicalPaymentCount",
        // dataType:'json',
    }).done(function(data){
        console.log(data);
        let result = parseInt(data)+1;
        let resultStr = "Payment"+result;
        paymentId = result;

        document.getElementById(order_id.toString()).value = resultStr;
        // $('#'+result_value).attr("disabled", true);
        $('#'+order_id.toString()).css("border", "2px solid grey");
        $('#'+order_id.toString()).css("color", "grey");
    }).fail(function(a,b,err){
        console.log(a,b,err)
    });
}

//function fillCustomerDetails(){}

function editPaymentBackgroundOn(){
    $('.payment_physical_big_container_background').css('display','block');
}
function editPaymentBackgroundOff(){
    $('.payment_physical_big_container_background').css('display','none');
}

function payments_pay(){
    // md5sig = strtoupper (md5 ( merchant_id + order_id + payhere_amount + payhere_currency + status_code + strtoupper(md5(payhere_secret)) ) );
    $('#payment_popup_details').show();
    //fillCustomerDetails();
    editPaymentBackgroundOn();

    //payment ID calculation
    countPaymentId("order_id");

    $.ajax({
        method:"POST",
        url:"memberDetails",
        dataType:"json",
        // contentType:"application/json",
        success: function (result){
            console.log(result);
            document.getElementById("first_name").value = result["first_name"];
            document.getElementById("last_name").value = result["last_name"];
            document.getElementById("email").value = result["email"];
            document.getElementById("phone").value = result["contact_number"];
            document.getElementById("address").value = result["address"];
            //document.getElementById("city").value = result["first_name"];

            let idPaimentCus = ["first_name","last_name","email","phone","address"];

            $.each(idPaimentCus,function(index,result_value){
                $('#'+result_value).css("border", "2px solid grey");
                $('#'+result_value).css("color", "grey");
            });

            let idNamesMembership = ["expiry_day","items","amount"];
            let dataNames = ["expiry_day","membership_category","renewal"];
            if(count == 0){
                $.ajax({
                    method:'POST',
                    url:"membership",
                    dataType:'json',

                }).done(function(data){
                    console.log(data);
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
                }).fail(function(a,b,err){
                    //alert("Error");
                    console.log(a,b,err)
                });
            }

            document.getElementById("currency").value = "LKR";
            // $('#currency').attr("disabled", true);
            $('#currency').css("border", "2px solid grey");
            $('#currency').css("color", "grey");
            count+=1;

        },
        error: function(error){
            console.log(error+"payment");
        }
    });
}

function pay_bill_view(payment_id,cus_first_name,cus_last_name,cus_address,payment_amount,payment_date_year,payment_date_month,payment_date_day,cus_city){
    $('#after_payment_popup_details').show();
    editPaymentBackgroundOn();

    $('#payment_detail_container_cus_details').append(
        `<div class="payment_detail_container_input">
                            <div>
                                <span><b>First Name</b></span><br>
                                <span>${cus_first_name}</span>
                            </div>

                            <div>
                                <span><b>Last Name</b></span><br>
                                <span>${cus_last_name}</span>
                            </div>
                        </div>

                        <div class="payment_detail_container_input">
                            <div>
                                <span><b>Payment Amount</b></span><br>
                                <span>${payment_amount}</span>
                            </div>

                            <div>
                                <span><b>Payment Date</b></span><br>
                                <span>${payment_date_year}-${payment_date_month}-${payment_date_day}</span>
                            </div>
                        </div>

                        <div class="payment_detail_container_input">
                            <div>
                                <span><b>Address</b></span><br>
                                <span>${cus_address}</span>
                            </div>

                            // <div>
                            //     <span><b>City</b></span><br>
                            //     <span>${cus_city}</span>
                            // </div>
                        </div>`
    );

}

function close_payment_details(){
    $('#payment_popup_details').hide();
    editPaymentBackgroundOff();
}
function close_after_payment_details(){
    $('#after_payment_popup_details').hide();
    editPaymentBackgroundOff();
    $('.payment_detail_container_input').remove();
}

function email_regex_Validate(emailValue){
    let regexPattern = new RegExp(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/);    // regular expression pattern
    return regexPattern.test(emailValue);
}
function checkDataValidate(form_data,idNamesCustomer,namesOFId){
    let i = 0;
    let count = 1;
    $.each(form_data,function(index,value){
        //console.log("Mavai hoyanne"+form_data);
        console.log(form_data);
        if(value.length == ''){
            console.log(index+" : "+value);
            let idValue = idNamesCustomer[i];
            let errorMsg = "**"+namesOFId[i]+" is missing";
            $('#'+idValue).html(errorMsg);
            $('#'+idValue).css("color", "red");
            $('#'+idValue).show();

            i+=1;
            count = 0;
        }
    });
    return count;
}
function hideErrors(){
    $('#payment_error1').hide();
    $('#payment_error2').hide();
    $('#payment_error3').hide();
    $('#payment_error4').hide();
    $('#payment_error5').hide();
}

function hideErrors1(){
    $('#payment_error11').hide();
    $('#payment_error21').hide();
    $('#payment_error31').hide();
    $('#payment_error41').hide();
    $('#payment_error51').hide();
}

$(document).ready(function(){
    hideErrors();
});

//payment from payhere
function payment_cash(){
    //cash payment function
    //send a request to branch manager
    checkStatus = 0;
    hideErrors();
    $('#payment_detail_container_form').submit(function(e){

        // e.preventDefault();
        let form_data = $("form").serializeArray();
        console.log(form_data);
        let payment = {};
        $.each(form_data, function(i, field){
            payment[field.name] = field.value;
        });
        payment["payment_id"] = paymentId.toString();
        console.log(payment);
        console.log(payment["merchant_id"]);
        // let idNamesCustomer = ["first_name","last_name","email","phone"];
        let idNamesCustomer = ["payment_error1","payment_error2","payment_error3","payment_error4"];
        let namesOFId = ["First Name","Last Name","Email","Contact Number"];

        let first_name = $('#first_name').val();
        let last_name = $('#last_name').val();
        let email = $('#email').val();
        let phone = $('#phone').val();
        let city = $('#city').val();

        let returnVal = checkDataValidate(payment,idNamesCustomer,namesOFId);
        if(returnVal == 0){
            e.preventDefault();
            return;
        }

        if(city == ''){
            $('#payment_error5').html("**Can't be empty");
            return;
        }

        if(!email_regex_Validate(email)){
            $('#payment_error3').html("**Enter valid email");
            $('#payment_error3').css("color", "red");
            e.preventDefault();
            return;
        }
        if (!(/[a-z]/.test(first_name) || /[A-Z]/.test(first_name))){
            $('#payment_error1').html("**First Name must only contain characters");
            $('#payment_error1').css("color", "red");
            e.preventDefault();
            return;
        }else if(!(/[a-z]/.test(last_name) || /[A-Z]/.test(last_name))){
            $('#payment_error2').html("**Last Name must only contain characters");
            $('#payment_error2').css("color", "red");
            e.preventDefault();
            return;
        }
        let isnum = /^\d+$/.test(phone);
        if(!isnum){
            $('#payment_error4').html("**Contact Number must only contain digit");
            $('#payment_error4').css("color", "red");
            e.preventDefault();
            return;
        }
        hideErrors();

        //after get the payhere response then its check,
        // if(paymentStatus == 2){}

        //now suppose its get the every payment is done
        // alert();

        afterOnlinePayment(payment,checkStatus,"Cash Payment");
        e.preventDefault();

        saveNotification();
        setTimeout(function() {
            window.location.href = 'http://localhost:8080/group39_fitbot_war_exploded/physicalMember';
        }, 1000);

    });
}
function saveNotification(){

    const date = new Date();
    // let year_age = date.getFullYear() - arr_date[0];
    // let month_age = date.getMonth()+1 - arr_date[1];
    // let date_age =  arr_date[2] - date.getDate();

    let user_id = null; //branchID
    let notification_title = "Cash Payment Reminder";
    let notification_time = ("0" + date.getHours()).slice(-2)+":"+("0" + date.getMinutes()).slice(-2)+":"+("0" + date.getSeconds()).slice(-2);
    let notification_date = date.getFullYear()+"-"+("0" + (date.getMonth()+1)).slice(-2)+"-"+("0" + date.getDate()).slice(-2);
    let notification_type = "immediate";
    let notification_status = 0;

    $.ajax({
        method:"POST",
        url:"branchDetails",
        //data: {},
        // dataType:"json",
        // contentType:"application/json",
        success: function (result){
            console.log(result);
            user_id = result;

            //let arr = saveNotificationData(user_id,notification_title,notification_time,notification_date,notification_type,notification_status);
            //return arr;

            $.ajax({
                method:"POST",
                url:"saveNotification",
                data: {user_id:user_id,notification_title:notification_title,notification_time:notification_time,notification_date:notification_date,notification_type:notification_type,notification_status:notification_status},
                // dataType:"json",
                // contentType:"application/json",
                success: function (result){
                    if(result.trim() == "1"){
                        console.log("Notification is saved");
                    }else if(result.trim() == "0"){
                        console.log("Notification is not saved");
                    }else {
                        console.log("Notification is saved and error1");
                    }
                },
                error: function(error){
                    console.log(error);
                    console.log("Notification is saved and error2");
                }
            });
        },
        error: function(error){
            console.log(error);
            console.log("Notification is saved and error2");
        }
    });
}

// function saveNotificationData(user_id,notification_title,notification_time,notification_date,notification_type,notification_status){
//
//     let arr = [user_id,notification_title,notification_time,notification_date,notification_type,notification_status];
//
//     return arr;
// }
//
// function saveNotification(){
//     //getBranchData();
//     const arrData = getBranchData();
//
//     let user_id = arrData[0]; //branchID
//     let notification_title = arrData[1];
//     let notification_time = arrData[2];
//     let notification_date = arrData[3];
//     let notification_type = arrData[4];
//     let notification_status = arrData[5];
//
//
// }

function payment_online(){
    checkStatus = 1;
    hideErrors();
    $('#payment_detail_container_form').submit(function(e){

        // e.preventDefault();
        let form_data = $("form").serializeArray();
        console.log(form_data);
        let payment = {};
        $.each(form_data, function(i, field){
            payment[field.name] = field.value;
        });
        payment["payment_id"] = paymentId.toString();
        console.log(payment);
        console.log(payment["merchant_id"]);
        // let idNamesCustomer = ["first_name","last_name","email","phone"];
        let idNamesCustomer = ["payment_error1","payment_error2","payment_error3","payment_error4"];
        let namesOFId = ["First Name","Last Name","Email","Contact Number"];

        let first_name = $('#first_name').val();
        let last_name = $('#last_name').val();
        let email = $('#email').val();
        let phone = $('#phone').val();
        let city = $('#city').val();

        let returnVal = checkDataValidate(payment,idNamesCustomer,namesOFId);
        if(returnVal == 0){
            e.preventDefault();
            return;
        }

        if(city == ''){
            $('#payment_error5').html("**Can't be empty");
            return;
        }

        if(!email_regex_Validate(email)){
            $('#payment_error3').html("**Enter valid email");
            $('#payment_error3').css("color", "red");
            e.preventDefault();
            return;
        }
        if (!(/[a-z]/.test(first_name) || /[A-Z]/.test(first_name))){
            $('#payment_error1').html("**First Name must only contain characters");
            $('#payment_error1').css("color", "red");
            e.preventDefault();
            return;
        }else if(!(/[a-z]/.test(last_name) || /[A-Z]/.test(last_name))){
            $('#payment_error2').html("**Last Name must only contain characters");
            $('#payment_error2').css("color", "red");
            e.preventDefault();
            return;
        }
        let isnum = /^\d+$/.test(phone);
        if(!isnum){
            $('#payment_error4').html("**Contact Number must only contain digit");
            $('#payment_error4').css("color", "red");
            e.preventDefault();
            return;
        }
        hideErrors();

        //e.preventDefault();
        afterOnlinePayment(payment,checkStatus,"Online Payment");

    });
}

function instructor_payment_online(){
    //alert("Yohan");
    checkStatus = 1;
    hideErrors1();
    $('#payment_detail_container_form1').submit(function(e){
        // e.preventDefault();
        let form_data = $("form").serializeArray();
        //console.log(form_data);
        let payment = {};
        $.each(form_data, function(i, field){
            payment[field.name] = field.value;
        });
        payment["payment_id"] = paymentId.toString();
        console.log(payment);
        //console.log(payment["merchant_id"]);
        // let idNamesCustomer = ["first_name","last_name","email","phone"];
        let idNamesCustomer = ["payment_error11","payment_error21","payment_error31","payment_error41"];
        let namesOFId = ["First Name","Last Name","Email","Contact Number"];

        let first_name = $('#first_name1').val();
        let last_name = $('#last_name1').val();
        let email = $('#email1').val();
        let phone = $('#phone1').val();
        let instructor_id = $('#instructor_id_hidden').val();
        console.log("Instructor ID"+instructor_id);

        let returnVal = checkDataValidate(payment,idNamesCustomer,namesOFId);
        if(returnVal == 0){
            e.preventDefault();
            return;
        }

        if(!email_regex_Validate(email)){
            $('#payment_error31').html("**Enter valid email");
            $('#payment_error31').css("color", "red");
            e.preventDefault();
            return;
        }
        if (!(/[a-z]/.test(first_name) || /[A-Z]/.test(first_name))){
            $('#payment_error11').html("**First Name must only contain characters");
            $('#payment_error11').css("color", "red");
            e.preventDefault();
            return;
        }else if(!(/[a-z]/.test(last_name) || /[A-Z]/.test(last_name))){
            $('#payment_error21').html("**Last Name must only contain characters");
            $('#payment_error21').css("color", "red");
            e.preventDefault();
            return;
        }
        let isnum = /^\d+$/.test(phone);
        if(!isnum){
            $('#payment_error41').html("**Contact Number must only contain digit");
            $('#payment_error41').css("color", "red");
            e.preventDefault();
            return;
        }
        hideErrors1();

        e.preventDefault();
        alert("yohan");
        saveVirtualPhysicalTableData(instructor_id);
        afterOnlinePayment(payment,checkStatus,"Instructor Payment");
    });
}

function afterOnlinePayment(data,status,payment_method){
    //alert("submit");
    const date = new Date();
    let fullDate = date.getFullYear()+"-"+(date.getMonth() + 1).toString().padStart(2, "0")+"-"+date.getDate().toString().padStart(2, "0");
    data["current_date"] = fullDate;
    // console.log(data);
    let new_expire_date1 = parseInt(date.getFullYear())+1;
    let new_expire_date = new_expire_date1 + "-" +(date.getMonth() + 1).toString().padStart(2, "0")+"-"+date.getDate().toString().padStart(2, "0");
    data["new_expire_date"] = new_expire_date;

    //console.log(data);
    let payment_id = paymentId;
    let payment_date = data.current_date;
    // let payment_method = data.
    let newExpireDate = data.expiry_day.split("-");
    //console.log(newExpireDate);
    let previous_expire_date = newExpireDate[0]+"-"+("0"+newExpireDate[1]).slice(-2)+"-"+("0"+newExpireDate[2]).slice(-2);
    console.log(previous_expire_date);
    // let previous_expire_date = data.expiry_day;
    //previous_expire_date = x.appointment_date["year"]+"-"+("0" + x.appointment_date["month"]).slice(-2)+"-"+("0" + x.appointment_date["day"]).slice(-2);
    let currency = data.currency;
    let payment_amount = data.amount;
    // let authorization_token
    let payment_status = status; //newly added. Meken thama apita kiyanna puluwan cash payment ekakda online da kiyala
    let cus_first_name = data.first_name;
    let cus_last_name = data.last_name;
    let cus_address = data.address;
    let cus_city = data.city;
    //let cus_city = "None";
    // let new_expire_date = new_expire_date2;

    $.ajax({
        method:"POST",
        url:"payment",
        data: {payment_id:payment_id, payment_date:payment_date, previous_expire_date:previous_expire_date, currency:currency, payment_amount:payment_amount,payment_status:payment_status, cus_first_name:cus_first_name, cus_last_name:cus_last_name, cus_address:cus_address, cus_city:cus_city, new_expire_date:new_expire_date,payment_method:payment_method},
        // dataType:"json",
        // contentType:"application/json",
        success: function (result){
            if(result.trim() == "1"){
                //alert(result);

                if(checkStatus == 0){
                    Swal.fire({
                        icon: 'success',
                        title: 'Request Send to Manager!',
                        // text: 'Physical Member!',
                        confirmButtonText:"Ok",
                        confirmButtonColor: '#0E2C4B',
                    })
                }else {
                    Swal.fire({
                        icon: 'success',
                        //title: 'Paid Successfully',
                        title: 'Payment Proceed',
                        // text: 'Physical Member!',
                        confirmButtonText:"Ok",
                        confirmButtonColor: '#0E2C4B',
                    })
                }


            }else if(result.trim() == "0"){
                Swal.fire({
                    icon: 'error',
                    title: 'Paid Unsuccessfully!',
                    text: 'Payment cannot completed!',
                    confirmButtonText:"Ok",
                    confirmButtonColor: '#932828',
                })
            }else {
                // alert(result);
                Swal.fire({
                    icon: 'error',
                    title: 'Paid Unsuccessfully!',
                    text: 'Payment cannot completed!',
                    confirmButtonText:"Ok",
                    confirmButtonColor: '#932828',
                })
            }

        },
        error: function(error){
            console.log(error);
            Swal.fire({
                icon: 'error',
                title: 'Payment Unsuccessfully!',
                text: 'Cannot resolve, System issue!!',
                confirmButtonText:"Ok",
                confirmButtonColor: '#932828',
            })
        }
    });
}

function saveVirtualPhysicalTableData(instructor_id){
    alert("Save data");
    $.ajax({
        method:"POST",
        url:"saveInstructorVirtualPhysicalData",
        data: {instructor_id:instructor_id},
        // dataType:"json",
        // contentType:"application/json",
        success: function (result){
            console.log(result);
            if(result.trim() == "1") {
                //alert(result);
                console.log("saveInstructorVirtualPhysicalData saved");
            }else {
                console.log("saveInstructorVirtualPhysicalData unsaved");
            }
        },
        error: function (error){
            console.log(error);
        }
    });
}