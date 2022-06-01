<div id="saveModal" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <h2 class="justify-content-center basic-modal">Successfully</h2>
            <div class="modal-body">
                ${param.message}
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="openPage('${param.url}')">Next</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>