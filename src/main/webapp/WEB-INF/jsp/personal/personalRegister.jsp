<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/base.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Register Page</title>
  </head>
  <style>
    .modal-dialog {
      padding-top: 15%;
    }
  </style>
  <body>
    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Personal Information Entry</h1>
          <hr />
        </div>
        <form>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="customerId">Customer Id</label>
              <input type="text" class="form-control" id="customerId" />
            </div>
            <div class="form-group col-md-6">
              <label for="registerDate">Register Date</label>
              <input type="text" class="form-control" id="registerDate" />
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="firstName">First Name</label>
              <input type="text" class="form-control" id="firstName" />
            </div>
            <div class="form-group col-md-6">
              <label for="lastName">Last Name</label>
              <input type="text" class="form-control" id="lastName" />
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="gender">Gender</label>
              <input type="text" class="form-control" id="gender" />
            </div>
            <div class="form-group col-md-6">
              <label for="dob">DOB</label>
              <input type="text" class="form-control" id="dob" />
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="passportNo">ID/Passport No:</label>
              <input type="text" class="form-control" id="passportNo" />
            </div>
            <div class="form-group col-md-4">
              <label for="email">Email:</label>
              <input type="text" class="form-control" id="email" />
            </div>

            <div class="form-group col-md-4">
              <label for="contactNo">Contact No</label>
              <input type="text" class="form-control" id="contactNo" />
            </div>
          </div>
          <button type="button" id="save" class="btn btn-primary">Save</button
          ><br /><br />
          <input
            type="button"
            class="btn btn-primary"
            value="Add Address"
            name="personalAddress"
            onclick="openPage('personalAddress')"
          />
          <input
            type="button"
            class="btn btn-primary"
            value="Add Contact Person"
            name="personalContact"
            onclick="openPage('personalContact')"
          />
        </form>
      </div>
    </div>
    <div id="saveModal" class="modal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <h2>Successfully</h2>
          <div class="modal-body">
            Thank you for your registration. Your Personal ID is XXXX Please
            process next step
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary">Next</button>
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


  $("#save").click(function () {
    $("#saveModal").modal("show");
  });
</script>
<script><%@include file="/WEB-INF/script/common.js" %></script>
