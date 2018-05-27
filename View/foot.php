

<!--  Scripts-->
<script src="https://code.jquery.com/jquery-2.1.1.min.js" DEFER="DEFER"></script>
<script src="View/js/materialize.js" DEFER="DEFER"></script>
<script src="View/js/init.js" DEFER="DEFER"></script>
<script src="View/js/clipboard.min.js" DEFER="DEFER"></script>


<script DEFER="DEFER">
var clipboard = new ClipboardJS('.copy-button');

clipboard.on('success', function(e) {
    console.info('Accion:', e.action);
    console.info('Texto:', e.text);
    console.info('Trigger:', e.trigger);

    e.clearSelection();
});

clipboard.on('error', function(e) {
    console.error('Accion:', e.action);
    console.error('Trigger:', e.trigger);
});
</script>


