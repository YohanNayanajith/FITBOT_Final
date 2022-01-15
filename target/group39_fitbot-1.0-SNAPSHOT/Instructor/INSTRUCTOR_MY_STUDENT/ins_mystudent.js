function Instructor_mystudents() {
    let anchor_student = document.getElementById("ins_student");
    let anchor_student_i = document.getElementById("ins_student_i");
    let student_text = document.getElementById("Instructor_mystudents_text");
    console.log("mokada meee payments");
    anchor_student.style.backgroundColor = "white";
    anchor_student_i.style.color = "black";
    student_text.style.color = "black";
  }


  function loadStudent(){
      alert("load student");
      var age;
      $('#instructor_student_tab_body').html(' ');
      $.ajax({
          method:'POST',
          url:"instructorsStudent",
          dataType: 'json',
          contentType: "application/json",
      }).done(function (result){
          console.log(result);
          $.map(result,function(x){

              $('#instructor_student_tab_body').append(
                  '<tr class="details_row">'+
                  '<td>'+x.name+'</td>'+
                  '<td>'+x.dob +'</td>'+
                  '<td>'+x.gender+'</td>'+
                  '<td>'+x.workout_plan_name +'</td>'+
                  '<td>'+x.diet_plan_name +'</td>'+
                  '</tr>'

              );
          });

      }).fail(function (a,b,err) {
          alert("Data loading error in student table");
          console.log(a,b,err);

      });

  }

  function loadStudentBoxData(){
    var newReq=0;
    var phyReq=0;
    var virReq=0;

    alert("in box");
    $.ajax({
        method:'POST',
        url:"instructorsStudentBoxData",
        dataType: 'json',
    }).done(function (result){
        // console.log("in done")
        console.log(result);

        result.forEach(element =>{
            if(element.status ==1){
                newReq++;
            }
            else if(element.status ==2){
                if(element.member_status == 1){
                    virReq++;
                }
                else if(element.member_status == 2){
                    phyReq++;
                }
            }
        })
        $('#new_request_number').append(
            '<h1>'+newReq +'</h1>'
        );
        $('#physical_request_number').append(
            '<h1>'+phyReq +'</h1>'
        );
        $('#virtual_request_number').append(
            '<h1>'+virReq +'</h1>'
        );


    }).fail(function (a,b,err) {
        alert("Data loading error in student table");
        console.log(a,b,err);

    });
  }