/**
 * Created by Mark on 2017. 05. 19..
 */
$.getJSON('/api/badges', function (JsonObj) {
    $('#locBadge').text(JsonObj['location_count']);
    $('#empBadge').text(JsonObj['employee_count']);
    $('#tractorBadge').text(JsonObj['tractor_count']);
    $('#trailerBadge').text(JsonObj['trailer_count']);
    $('#jobBadge').text(JsonObj['job_count']);
});