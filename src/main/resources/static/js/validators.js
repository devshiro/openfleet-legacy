/**
 * Created by Mark on 2017. 05. 04..
 */
$('document').ready(function(){
    //TODO: attach automatically by adding a tests.framework-testable class to the input groups.
    /*$('#countryInput').change(function () {
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
    })*/
    attachTester('country');
    attachTester('region');
    attachTester('city');
    attachTester('street');
    attachTester('houseNo');
    attachTester('zipcode');
});

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