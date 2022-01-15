function maintain_requests() {
  let anchor_requests = document.getElementById("maintainer_requests");
  let anchor_requests_i = document.getElementById("maintainer_requests_i");
  let anchor_requests_text = document.getElementById("maintainer_requests_text");
  // console.log("mokada meee requests");
  anchor_requests.style.backgroundColor = "white";
  anchor_requests_i.style.color = "black";
  anchor_requests_text.style.color = "black";
}


// ----------------------------popup page view---------------------------
// const submitBtnClickDineth = document.querySelector('.submitPopFormId');
// ruwanthi =document.getElementById('submitPopFormId');
// ruwanthi.addEventListener("click", function (){
//   console.log("Hasara");
// });
// submitBtnClickDineth.addEventListener("click", function (){
//   console.log("in popup submit");
//   // submitFormMaintainer(popId);
// });
// function callfuntion(){
//   console.log("in call function");
//   submitFormMaintainer(popId)
// }

function PopupForm(popId){
alert("call popupForm");
  console.log("in pop"+popId);
  $('#maintainer_form').show();
  // let form_id_m = "1";
  $('#branch_id_inForm').html(' ');
  $('#equipment_type_inForm').html(' ');
  $('#problem_dis').html(' ');
  $('#req_date').html(' ');
  $('#req_time').html(' ');

  $.ajax({
    method:'POST',
    url:"maintainerWrite",
    data: {popId:popId}
    // dataType: 'json',
    // contentType: "application/json",
  }).done(function (result){
    // alert("Done Shalani");
    let Bname;
    switch (result.branch_id) {
      case "B-0001":
        Bname = "Gampaha";
        break;
      default:
        Bname = "NULL";
        break;
    }


    // console.log(result);
    // $.map(result,function(details){
      $('#branch_id_inForm').append(
      '<p>'+Bname+'</p>'
          );
      $('#equipment_type_inForm').append(
      '<p>'+result.equipment_type+'</p>'
          );
      $('#problem_dis').append(
      '<p>'+result.description+'</p>'
          );
      $('#req_date').append(
      '<p>'+result.re_date+'</p>'
          );
      $('#req_time').append(
      '<p>'+result.re_time+'</p>'
          );


    $('#submitPopFormId').click(function(){
      // alert("in submit alert");
      submitFormMaintainer(result.form_id);

    });

    // if(document.getElementById('button').clicked==true){
    //   alert("in submit");
    // }
    // alert("Data is loading now");
  }).fail(function (a,b,err) {
    alert("Data loading error  Shalani");
    console.log(a,b,err);

  });

}

function PopupCompletForm(popId){
  alert("call PopupCompletForm");
  console.log("in pop"+popId);
  $('#maintainer_form').show();
  // let form_id_m = "1";
  $('#branch_id_inForm').html(' ');
  $('#equipment_type_inForm').html(' ');
  $('#problem_dis').html(' ');
  $('#req_date').html(' ');
  $('#req_time').html(' ');
  $('#completed_form_data1').html(' ');
  $('#completed_form_data2').html(' ');
  $('#completed_form_data3').html(' ');
  $('#completed_form_data4').html(' ');

  $.ajax({
    method:'POST',
    url:"maintainerWrite",
    data: {popId:popId}
    // dataType: 'json',
    // contentType: "application/json",
  }).done(function (result){
    // alert("Done Shalani");
    let Bname;
    switch (result.branch_id) {
      case "B-0001":
        Bname = "Gampaha";
        break;
      default:
        Bname = "NULL";
        break
    }

    // console.log(result);
    // $.map(result,function(details){
    $('#branch_id_inForm').append(
        '<p>'+Bname+'</p>'
    );
    $('#equipment_type_inForm').append(
        '<p>'+result.equipment_type+'</p>'
    );
    $('#problem_dis').append(
        '<p>'+result.description+'</p>'
    );
    $('#req_date').append(
        '<p>'+result.re_date+'</p>'
    );
    $('#req_time').append(
        '<p>'+result.re_time+'</p>'
    );

//completed data

    $('#completed_form_data1').append(
        '<p>'+result.complet_dis+'</p>'
    );
    $('#completed_form_data2').append(
        '<p>'+result.complet_img+'</p>'
    );
    $('#completed_form_data3').append(
        '<p>'+result.comp_date+'</p>'
    );
    $('#completed_form_data4').append(
        '<p>'+result.comp_time+'</p>'
    );

    // let submitBtn = document.querySelector("#formSend_maintainer");
    // $('#formSend_maintainer').addEventListener("click", ()=>{
    //   submitFormMaintainer(popId)
    // });
    $('#submitPopFormId').click(function(){
      // alert("in submit alert");
      submitFormMaintainer(result.form_id);

      // if(operate){
      //   // do smth
      // }
    });

    // if(document.getElementById('button').clicked==true){
    //   alert("in submit");
    // }
    // alert("Data is loading now");
  }).fail(function (a,b,err) {
    alert("Data loading error  Shalani");
    console.log(a,b,err);

  });

}

function close_form_Popup(){
  $('#maintainer_form').hide();
   $('#form_maintainer_con input[type="text"], input[type="date"] , input[type="time"], textarea').val("");

}

function submitFormMaintainer(popId) {
    // console.log("In submitForm");
    // console.log(popId);
    $('#form_maintainer_con').submit(function (e) {
      e.preventDefault();
      // let form_id_m = "1";
      let complet_dis = $('#complet_dis').val();
      let complet_img = $('#complet_img').val();
      let comp_date = $('#comp_date').val();
      let comp_time = $('#comp_time').val();
      console.log(popId);
      console.log("in function");


      $.ajax({
        method: 'POST',
        url: "maintainerFormSubmit",
        // contentType: 'application/json; charset=utf-8',
        data: {popId:popId, complet_dis: complet_dis, complet_img: complet_img, comp_date: comp_date, comp_time: comp_time},

        success: function (result) {

          alert("done success");
          if (result.trim() == "1") {
            // alert("done successsssssssssssssss");
            reloadRequestData();
            $('#maintainer_form input[type="text"],input[type="date"]  input[type="time"], textarea').val('');
            $('#maintainer_form').hide();
            Swal.fire({
              icon: 'success',
              title: 'Successfully Submit',
              text: 'Done!',
              confirmButtonText:"Ok",
              confirmButtonColor: '#0E2C4B',
            })

          }
        },
        fail: function (error) {
          alert(error);
        }


      });

    });

  }

// function submitFormMaintainer(){
//   let form_id_m =1;
//   let complet_dis=$('#complet_dis').val();
//   let complet_img=$('#complet_img').val();
//   let comp_date=$('#comp_date').val();
//   let comp_time=$('#comp_time').val();
//
//   alert("call submit");
//
//   $.ajax({
//     method:'POST',
//     url:"maintainerFormSubmit",
//     // contentType: 'application/json; charset=utf-8',
//     data: {form_id_m:form_id_m, complet_dis:complet_dis, complet_img:complet_img,comp_date:comp_date,comp_time:comp_time},
//
//     success:function (result){
//
//       alert("done success");
//     },
//     fail:function (error){
//       alert(error);
//     }
//
//   });
//
// }