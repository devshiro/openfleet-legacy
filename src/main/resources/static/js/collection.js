/**
 * Created by Mark on 2017. 04. 28..
 */
function alertTest(){
    alert('A');
}

function drawChart() {
    // Define the chart to be drawn.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Element');
    data.addColumn('number', 'Percentage');
    var retArray = [];
    $.getJSON('/api/drivers', function(JsonObj) {
        for(var i in JsonObj) {
            var array = [];
            array[0] = JsonObj[i]['name'];
            array[1] = JsonObj[i]['share'];
            retArray[i] = array;
        }
        data.addRows(retArray);
        var chart = new google.visualization.PieChart(document.getElementById('myPieChart'));
        chart.draw(data, null);
    });
}