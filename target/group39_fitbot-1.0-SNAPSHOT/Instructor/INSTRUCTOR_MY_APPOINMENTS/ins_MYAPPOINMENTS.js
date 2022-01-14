function Instructor_appoinments() {
    let anchor_appoinment = document.getElementById("ins_appoinment");
    let anchor_appoinment_i = document.getElementById("ins_appoinment_i");
    let appoinment_text = document.getElementById("Instructor_appoinments_text");
    console.log("mokada meee dashboard");
    anchor_appoinment.style.backgroundColor = "white";
    anchor_appoinment_i.style.color = "black";
    appoinment_text.style.color = "black";
  }

  function loadAppointmentPage(){
    alert("Now you are in appointment");

      $('#instructor_appointment_tab_body').html(' ');
      $.ajax({
          method:'POST',
          url:"instructorsAppointmentpage",
          dataType: 'json',
          contentType: "application/json",
      }).done(function (result){
          console.log(result);
          var AppointmentCount=0;
          $.map(result,function(x){
              AppointmentCount++;
              $('#instructor_appointment_tab_body').append(
                  '<tr class="member_appoinment_row">'+
                  '<td>'+x.name+'</td>'+
                  '<td>'+x.appointment_date +'</td>'+
                  '<td>'+x.start_time+'</td>'+
                  '<td>'+x.finish_time +'</td>'+

                  '</tr>'

              );
          });
          console.log(AppointmentCount);
          $('#appointment_count').append(
              '<h3>'+ AppointmentCount+'</h3>'
          )


      }).fail(function (a,b,err) {
          alert("Data loading error in student table");
          console.log(a,b,err);

      });

  }
