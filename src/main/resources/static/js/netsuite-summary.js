$(document).ready(function() {
    $('#netsuiteSummaryTable').DataTable({
        "scrollX": true,
        dom: 'Bfrtip',
        buttons: [
            'csv'
        ],
        "ordering": false,
        "lengthChange": false,
        "paging": false,
        "searching": false,
        "info": false
    });
});