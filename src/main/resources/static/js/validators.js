/**
 * Created by Mark on 2017. 05. 04..
 */
$('document').ready(function(){
    //alert(1);
    $('#countryInput').change(function () {
        tester('country');
    })
    $('#regionInput').change(function () {
        tester('region');
    })
    $('#cityInput').change(function () {
        tester('city');
    })
    $('#streetInput').change(function () {
        tester('street');
    })
    $('#houseNoInput').change(function () {
        tester('houseNo');
    })
    $('#zipcodeInput').change(function () {
        tester('zipcode');
    })
});


var tester = function (selector) {
    if($('#'+selector+'Input').val() === ''){
        $('#'+selector+'Group').removeClass('has-success').addClass('has-error');
    } else {
        $('#'+selector+'Group').removeClass('has-error').addClass('has-success');
    }
}

function validate() {
    var country = $('#countryInput').val();
    var city = $('#cityInput').val();
    var region = $('#regionInput').val();
    var street = $('#streetInput').val();
    var houseNo = $('#houseNoInput').val();
    var zipcode = $('#zipcodeInput').val();
    if (country === '') return false;
    if (city === '') return false;
    if (region === '') return false;
    if (houseNo === '') return false;
    if (street === '') return false;
    if (zipcode === '') return false;

    //probably everything is fine.
    return true;
}