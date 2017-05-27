/**
 * Created by Mark on 2017. 05. 19..
 */
$.getJSON('/api/badges', function (JsonObj) {
    $('#locBadge').text(JsonObj['locationCount']);
    $('#empBadge').text(JsonObj['employeeCount']);
    $('#tractorBadge').text(JsonObj['tractorCount']);
    $('#trailerBadge').text(JsonObj['trailerCount']);
    $('#jobBadge').text(JsonObj['jobCount']);
});