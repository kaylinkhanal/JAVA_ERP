<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/base.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <style>
      .modal-dialog {
        padding-top: 15%;
      }
    </style>
    <meta charset="ISO-8859-1" />
    <title>Register Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
  </head>
  <body>
    <div id="registerModal" class="modal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-body">
            Choose the type of customer you want to create?
          </div>
          <div class="modal-footer">
            <input
              type="button"
              class="btn btn-primary"
              value="Personal"
              name="Personal"
              onclick="openPage('personalRegister')"
            />
            <input
              type="button"
              class="btn btn-primary"
              value="Company"
              name="Company"
              onclick="openPage('companyInformation')"
            />
            <button
              type="button"
              class="btn btn-secondary"
              data-dismiss="modal"
            >
              Cancel
            </button>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
<script type="text/javascript">
  $(document).ready(function () {
    $("#registerModal").modal("show");
  });

  function openPage(pageURL) {
    window.location.href = pageURL;
  }
</script>
