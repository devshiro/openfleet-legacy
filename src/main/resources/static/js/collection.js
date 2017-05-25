/**
 * Created by Mark on 2017. 04. 28..
 */
function drawChart() {
    $.getJSON("/api/employeePerformance",function (Obj) {
        var counter = -1;
        var buffer = "";
        for(var i in Obj){
            counter++;
            if(counter>2) counter = 0;
            if(counter === 2){
                $('#charts').append(createRow(buffer));
                buffer = "";
            }
            buffer += createColumn(createPanel(Obj[i]['first'],'chart'+i));
        }
        if(buffer.length != 0){
            $('#charts').append(createRow(buffer));
        }
        buffer = "";
        counter = -1;
        for(var i in Obj){
            console.log(Obj[i]['second']['first']);
            counter++;
            var buffer = "";
            //$("#charts").append('<p>'+Obj[i]['first']+'</p><div id="chart'+i+'"></div>');
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Type');
            data.addColumn('number', 'Percentage');
            var row1 = [];
            row1[0] = 'Work hours';
            row1[1] = Obj[i]['second']['first'];
            var row2 = [];
            row2[0] = 'Rest hours';
            row2[1] = Obj[i]['second']['second'];
            var array = [];
            array[0] = row1;
            array[1] = row2;
            console.log(array);
            data.addRows(array);
            var chart = new google.visualization.PieChart(document.getElementById('chart'+i));
            var options = {'legend' : 'none'};
            chart.draw(data,options);
        }
    });

}

function attachTester(selector){
    $('#'+selector+'Input').change(function () {
        tester(selector);
    })
}


function tester(selector) {
    if($('#'+selector+'Input').val() === ''){
        $('#'+selector+'Group').removeClass('has-success').addClass('has-error');
    } else {
        $('#'+selector+'Group').removeClass('has-error').addClass('has-success');
    }
}

function createRow(data){
    return '<div class="row">'+data+'</div>';
}

function createColumn(column){
    return '<div class="col-md-4">'+column+'</div>';
}


function createPanel(heading, id){
    var panel = '<div class="panel panel-default"><div class="panel-heading"><h3 class="panel-title">'+heading+'</h3></div>';
    var body = '<div class="panel-body" id="'+id+'"></div></div>';
    return panel+body;
}