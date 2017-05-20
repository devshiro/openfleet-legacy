/**
 * Created by Mark on 2017. 05. 10..
 */
var tractorId = $('#hiddenTractorId').val();
$.getJSON('/api/tractors', function (JsonObj) {
    for(var i in JsonObj) {
        if (tractorId == JsonObj[i]['id']) {
            $('#tractorInput').text(JsonObj[i]['manufacturer'] + ' ' + JsonObj[i]['type']);
        }
    }
});

var trailerId = $('#hiddenTrailerId').val();
$.getJSON('/api/trailers', function (JsonObj) {
    for(var i in JsonObj) {
        if (trailerId == JsonObj[i]['id']) {
            $('#trailerInput').text(JsonObj[i]['manufacturer'] + ' ' + JsonObj[i]['type']);
        }
    }
});

var employeeid = $('#hiddenEmployeeId').val();
$.getJSON('/api/employees', function (JsonObj) {
    for(var i in JsonObj) {
        if (employeeid == JsonObj[i]['id']) {
            $('#employeeInput').text(JsonObj[i]['firstName'] + ' ' + JsonObj[i]['lastName']);
        }
    }
});
var placeOfLoad = $('#hiddenPlaceOfLoad').val();
var placeOfUnload = $('#hiddenPlaceOfUnload').val();
$.getJSON('/api/locations', function (JsonObj) {
    for(var i in JsonObj) {
        if (placeOfLoad == JsonObj[i]['id']) {
            $('#placeOfLoadInput').text(JsonObj[i]['country']+' '+JsonObj[i]['city']+' '+JsonObj[i]['street']+' '+JsonObj[i]['houseNo']+', '+JsonObj[i]['zipcode']);
        }
        if (placeOfUnload == JsonObj[i]['id']) {
            $('#placeOfUnloadInput').text(JsonObj[i]['country']+' '+JsonObj[i]['city']+' '+JsonObj[i]['street']+' '+JsonObj[i]['houseNo']+', '+JsonObj[i]['zipcode']);
        }
    }
});

$('document').ready(function () {
    $.getJSON("/transports/api",function(JsonObj){
        console.log(JsonObj[0]);
    });
})