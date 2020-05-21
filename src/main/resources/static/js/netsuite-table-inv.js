$(document).ready(function() {
    $('#netsuiteTableInventoryTables').DataTable({
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