/**
 * Created by Mark on 2017. 05. 10..
 */
var locId = $('#hiddenPlaceOfBirth').val();
var livId = $('#hiddenPlaceOfLiving').val();
$.getJSON('/api/locations', function(JsonObj){
    for(var i in JsonObj){
        if(locId == JsonObj[i]['id']){
            $('#placeOfBirthInput').append('<option selected="selected" value="'+JsonObj[i]['id']+'">'+JsonObj[i]['country']+' '+JsonObj[i]['city']+' '+JsonObj[i]['street']+' '+JsonObj[i]['houseNo']+', '+JsonObj[i]['zipcode']+'</option>');
        } else {
            $('#placeOfBirthInput').append('<option value="'+JsonObj[i]['id']+'">'+JsonObj[i]['country']+' '+JsonObj[i]['city']+' '+JsonObj[i]['street']+' '+JsonObj[i]['houseNo']+', '+JsonObj[i]['zipcode']+'</option>');
        }
        if(livId == JsonObj[i]['id']){
            $('#placeOfLivingInput').append('<option selected="selected" value="'+JsonObj[i]['id']+'">'+JsonObj[i]['country']+' '+JsonObj[i]['city']+' '+JsonObj[i]['street']+' '+JsonObj[i]['houseNo']+', '+JsonObj[i]['zipcode']+'</option>');
        } else {
            $('#placeOfLivingInput').append('<option value="'+JsonObj[i]['id']+'">'+JsonObj[i]['country']+' '+JsonObj[i]['city']+' '+JsonObj[i]['street']+' '+JsonObj[i]['houseNo']+', '+JsonObj[i]['zipcode']+'</option>');
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