<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/base.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Register Page</title>
    <style>
      .modal-dialog {
        padding-top: 15%;
      }
    </style>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Personal Contact Person Information</h1>
          <hr />
        </div>
        <form>
          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="contactId">Contact Id: </label>
              <input type="text" disabled class="form-control" id="contactId" />
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-8">
              <label for="contactName">Contact Name: </label>
              <input type="text" class="form-control" id="contactName" />
            </div>
            <div class="form-group col-md-4">
              <label for="addressType">Address Type: </label>
              <select id="addressType" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
              </select>
            </div>
          </div>

          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="phone">Phone: </label>
              <input type="text" class="form-control" id="phone" />
            </div>
            <div class="form-group col-md-4">
              <label for="email">Email: </label>
              <input type="text" class="form-control" id="email" />
            </div>

            <div class="form-group col-md-4">
              <label for="relationship">Relationship: </label>
              <input type="text" class="form-control" id="relationship" />
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-12">
              <label for="description">Description: </label>
              <textArea
                type="text"
                row="3"
                class="form-control"
                id="description"
              ></textArea>
            </div>
          </div>
          <button type="button" id="save" class="btn btn-primary">Save</button
          ><br /><br />
        </form>
      </div>

      <div align="center" class="container">
        <table border="1" width="60%" class="table table-striped">
          <thead align="center" class="bg-primary">
            <tr>
              <td>Contact ID</td>
              <td>Address Type</td>
              <td>Phone</td>
              <td>Relationship</td>
              <td>Email</td>
              <td>Status</td>
              <td></td>
            </tr>
          </thead>

          <tbody align="center">
            <tr>
              <td>001</td>
              <td>Home</td>
              <td>+662 488-3322</td>
              <td>Sister</td>
              <td>abc@gmail.com</td>
              <td>Enable</td>
              <td>
                <i class="far fa-edit"></i>
                <i class="far fa-trash-alt"></i>
              </td>
            </tr>
            <tr>
              <td>002</td>
              <td>Office</td>
              <td>+662 488-3322</td>
              <td>Sister</td>
              <td>abc@gmail.com</td>
              <td>Enable</td>
              <td>
                <i class="far fa-edit"></i>
                <i class="far fa-trash-alt"></i>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div id="saveModal" class="modal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <h2>Successfully</h2>
          <div class="modal-body">
            Thank you for your registration. Your Company ID is XXXX Please
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
