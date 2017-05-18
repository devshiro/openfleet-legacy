/**
 * Created by Mark on 2017. 05. 16..
 */
$.getJSON('/api/employees', function (JsonObj) {
    for(var i in JsonObj) {
            $('#employeeInput').append('<option value="' + JsonObj[i]['id'] + '">' + JsonObj[i]['firstName'] + ' ' + JsonObj[i]['lastName'] + '</option>');
    }
});
function showDetails(){
    var addr = "/api/paymentDetails?id="+$('#employeeInput').val();
    $.getJSON(addr, function (JsonObj) {
       writeOutput(JsonObj);
    });
}

function writeOutput(data){
    $('#paymentBody').remove();
    $('#paymentTable').append('<tbody id="paymentBody"></tbody>');
    for(var i in data){
        $('#paymentBody').append('<tr>'+ '<td>'+data[i]['year']+'/'+data[i]['month']+'</td>'+'<td>'+data[i]['workedDays']+'</td>'+'<td>'+data[i]['totalPayout']+'</td>'+'</tr>');
    }
}