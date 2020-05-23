$(document).ready(function() {
    $('#mdcBranchTable').DataTable({
        dom: 'frtipB',
        buttons: {
            dom: {
                button: {
                    className: 'btn'
                }
            },
            buttons: [
                {
                    extend: 'csvHtml5',
                    text: 'Export as CSV',
                    charset: 'utf-8',
                    extension: '.csv',
                    filename: 'mdc-per-branch-sales',
                    className: 'btn-info',
                    bom: true,
                }
            ]
        },
        "ordering": false,
        "lengthChange": false,
        "paging": false,
        "searching": false,
        "info": false
    });
});