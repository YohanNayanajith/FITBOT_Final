
function diet_plan_row_instructor() {
    var index, table = document.getElementById('table');
    for (var i = 0; i < table.rows.length; i++) {
        table.rows[i].cells[2].onclick = function () {
            var c = confirm("Do you want to delete this row?");
            if (c === true) {
                index = this.parentElement.rowIndex;
                table.deleteRow(index);
            }
        }
    }
}


// -----------------pop up form----------------------

$(document).ready(function(){
    $("#new_diet_row1").click(function(){
        var breakfastaddcontrols="<tr>"
            breakfastaddcontrols+= "<td><input type = 'text' name='mealname' class='diet_row mealname'   placeholder='Meal Name'></td>"
            breakfastaddcontrols+= "<td><input type = 'text' name='quantity' class='diet_row quantity' placeholder='Quantity'></td>"
        breakfastaddcontrols+="</tr>";

        $("#breakfast_table_tbody").append(breakfastaddcontrols);
        // $("#breakfast_table #breakfast_table_tbody").append(breakfastaddcontrols);
    });
});


$(document).ready(function(){
    $("#new_diet_row2").click(function(){
        var lunchaddcontrols="<tr>"
            lunchaddcontrols+= "<td><input type = 'text' name='mealname' class='diet_row mealname' placeholder='Meal Name'></td>"
            lunchaddcontrols+= "<td><input type = 'text' name='quantity' class='diet_row quantity' placeholder='Quantity'></td>"
        lunchaddcontrols+="</tr>";

        $("#lunch_table_tbody").append(lunchaddcontrols);
    });
});

$(document).ready(function(){
    $("#new_diet_row3").click(function(){
        var dinneraddcontrols="<tr>"
            dinneraddcontrols+= "<td><input type = 'text' name='mealname' class='diet_row mealname' placeholder='Meal Name'></td>"
            dinneraddcontrols+= "<td><input type = 'text' name='quantity' class='diet_row quantity' placeholder='Quantity'></td>"
        dinneraddcontrols+="</tr>";

        $("#dinner_table_tbody").append(dinneraddcontrols);
    });
});

