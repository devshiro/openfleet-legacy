/**
 * Created by Mark on 2017. 05. 10..
 */
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