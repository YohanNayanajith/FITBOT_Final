function maintain_equipments() {
  let anchor_equipments = document.getElementById("maintainer_equipments");
  let anchor_equipments_i = document.getElementById("maintainer_equipments_i");
  let anchor_equipments_text = document.getElementById("maintainer_equipments_text");
  // console.log("mokada meee dashboard");
  anchor_equipments.style.backgroundColor = "white";
  anchor_equipments_i.style.color = "black";
  anchor_equipments_text.style.color = "black";

}

function dataLoadEquipments(str){
  console.log(str);


}

function reloadEquipmentsData(Equipments_id,Branch_selecter,List_order){
  // alert("load equipments");
  console.log("+++++++++++");
  console.log(List_order);
  console.log(Branch_selecter);
  console.log(Equipments_id);
  $('#maintain_equipments_tab_body').html(' ');
  $.ajax({
    method:'POST',
    url:"maintainerEqupimentsLoad",
    data:{Equipments_id:Equipments_id,Branch_selecter:Branch_selecter,List_order:List_order},

    // dataType: 'json',
    // contentType: "application/json",
  }).done(function (result){
    console.log(result);
    $.map(result,function(x){

      $('#maintain_equipments_tab_body').append(
          '<tr class="equipment_info">'+
          '<td>'+x.equipment_id+'</td>'+
          '<td>'+x.category+'</td>'+
          '<td>'+x.branch_name+'</td>'+
          '<td>'+x.last_modified_date+'</td>'+
          '<td>'+x.next_maintenance_date+'</td>'+
          '</tr>'
      );
    });

  }).fail(function (a,b,err) {
    alert("Data loading error  Shalani");
    console.log(a,b,err);
  });
}


function loadBranchName(){
  // alert("call branch list");
  $('.branch_option_selecter_equipments').html(' ');
  $.ajax({
    method:'POST',
    url:"maintainerEquipmentPageBranchName",
    dataType: 'json',
    contentType: "application/json",
  }).done(function (result){
    console.log(result);
    $.map(result,function(x){
      $('.select_Filter_List').append(
          '<option class="branch_option_selecter_equipments" value='+x.branch_id + '>'+ x.branch_location +'</option>'
      );
    });

  }).fail(function (a,b,err) {
    alert("Data loading error");
    console.log(a,b,err);

  });
}


function searchEquipmentsList(){
  alert("click search");
  let Equipments_id = $('#search_equipment_by_ID').val();
  let Branch_selecter = $('#select_Filter_List').val();
  let List_order = $('#select_Filter_List_order').val();

  reloadEquipmentsData(Equipments_id,Branch_selecter,List_order);
  // console.log(List_order);
  // console.log(Branch_selecter);
  // console.log(Equipments_id);


}