/**
 * Created by Mark on 2017. 05. 10..
*/
var tractorId = $('#hiddenTractorId').val();
$.getJSON('/api/tractors', function (JsonObj) {
    for(var i in JsonObj) {
        if (tractorId == JsonObj[i]['id']) {
            $('#tractorInput').append('<option selected="selected" value="' + JsonObj[i]['id'] + '">' + JsonObj[i]['manufacturer'] + ' ' + JsonObj[i]['type'] + '</option>');
        } else {
            $('#tractorInput').append('<option value="' + JsonObj[i]['id'] + '">' + JsonObj[i]['manufacturer'] + ' ' + JsonObj[i]['type'] + '</option>');
        }
    }
});

var trailerId = $('#hiddenTrailerId').val();
$.getJSON('/api/trailers', function (JsonObj) {
    for(var i in JsonObj) {
        if (trailerId == JsonObj[i]['id']) {
            $('#trailerInput').append('<option selected="selected" value="' + JsonObj[i]['id'] + '">' + JsonObj[i]['manufacturer'] + ' ' + JsonObj[i]['type'] + '</option>');
        } else {
            $('#trailerInput').append('<option value="' + JsonObj[i]['id'] + '">' + JsonObj[i]['manufacturer'] + ' ' + JsonObj[i]['type'] + '</option>');
        }
    }
});

var employeeid = $('#hiddenEmployeeId').val();
$.getJSON('/api/employees', function (JsonObj) {
    for(var i in JsonObj) {
        if (employeeid == JsonObj[i]['id']) {
            $('#employeeInput').append('<option selected="selected" value="' + JsonObj[i]['id'] + '">' + JsonObj[i]['firstName'] + ' ' + JsonObj[i]['lastName'] + '</option>');
        } else {
            $('#employeeInput').append('<option value="' + JsonObj[i]['id'] + '">' + JsonObj[i]['firstName'] + ' ' + JsonObj[i]['lastName'] + '</option>');
        }
    }
});
var placeOfLoad = $('#hiddenPlaceOfLoad').val();
var placeOfUnload = $('#hiddenPlaceOFUnload').val();
$.getJSON('/api/locations', function (JsonObj) {
    for(var i in JsonObj) {
        if (placeOfLoad == JsonObj[i]['id']) {
            $('#placeOfLoadInput').append('<option selected="selected" value="'+JsonObj[i]['id']+'">'+JsonObj[i]['country']+' '+JsonObj[i]['city']+' '+JsonObj[i]['street']+' '+JsonObj[i]['houseNo']+', '+JsonObj[i]['zipcode']+'</option>');
        } else {
            $('#placeOfLoadInput').append('<option value="'+JsonObj[i]['id']+'">'+JsonObj[i]['country']+' '+JsonObj[i]['city']+' '+JsonObj[i]['street']+' '+JsonObj[i]['houseNo']+', '+JsonObj[i]['zipcode']+'</option>');
        }
        if (placeOfUnload == JsonObj[i]['id']) {
            $('#placeOfUnloadInput').append('<option selected="selected" value="'+JsonObj[i]['id']+'">'+JsonObj[i]['country']+' '+JsonObj[i]['city']+' '+JsonObj[i]['street']+' '+JsonObj[i]['houseNo']+', '+JsonObj[i]['zipcode']+'</option>');
        } else {
            $('#placeOfUnloadInput').append('<option value="'+JsonObj[i]['id']+'">'+JsonObj[i]['country']+' '+JsonObj[i]['city']+' '+JsonObj[i]['street']+' '+JsonObj[i]['houseNo']+', '+JsonObj[i]['zipcode']+'</option>');
        }
    }
});

$('document').ready(function () {
    populateSelect();
    $.getJSON("/transports/api",function(JsonObj){
       console.log(JsonObj[0]);
    });
})

function populateSelect(){
    var select = $("select[name='locationSelect']");
    select.append('<option>Something</option>');
}

function sendData(){
    alert('Sending data!');
    $.post("/location/add",$('#locationForm').serialize())
        .done(function(){
           alert('hopefully done!');
        });
}