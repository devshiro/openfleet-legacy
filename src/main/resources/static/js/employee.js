/**
 * Created by Mark on 2017. 05. 07..
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

$('document').ready(function(){
    attachTester('firstName');
    attachTester('lastName');
    attachTester('dateOfBirth');
    attachTester('socialInsuranceNo');
    attachTester('taxNo');
    attachTester('mothersName');
    attachTester('driversCardNo');
    attachTester('employmentDate');
});