<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/base.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Company Information</title>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Company Information Entry</h1>
          <hr />
        </div>
        <form>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="customerId">Customer Id</label>
              <input
                type="text"
                disabled
                class="form-control"
                id="customerId"
              />
            </div>
            <div class="form-group col-md-6">
              <label for="registerDate">Register Date</label>
              <input
                type="text"
                disabled
                class="form-control"
                id="registerDate"
              />
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="companyName">Company Name</label>
              <input type="text" class="form-control" id="companyName" />
            </div>
            <div class="form-group col-md-6">
              <label for="taxId">Tax Id</label>
              <input type="text" class="form-control" id="taxId" />
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="businessType">Business Type: </label>
              <select id="businessType" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
              </select>
            </div>
            <div class="form-group col-md-6">
              <label for="website">Website</label>
              <input type="text" class="form-control" id="website" />
            </div>
          </div>
          <div class="form-row">
            <div class="col-md-2">
              <label for="trading">Trading Relation: </label>
            </div>
            <div class="col-md-6">
              <div class="form-check form-check-inline">
                <input
                  class="form-check-input"
                  type="checkbox"
                  id="inlineCheckbox1"
                  value="option1"
                />
              </div>
              <div class="form-check form-check-inline">
                <input
                  class="form-check-input"
                  type="checkbox"
                  id="inlineCheckbox2"
                  value="option2"
                />
              </div>
            </div>
          </div>
          <button type="submit" class="btn btn-primary">Save</button
          ><br /><br />
          <button type="button" class="btn btn-primary">Add Site</button>
          <button type="button" class="btn btn-primary">
            Add Contact Person
          </button>
          <button type="button" class="btn btn-primary">Add Person Info</button>
        </form>
      </div>
    </div>
  </body>
</html>

<script type="text/javascript">
  function openPage(pageURL) {
    window.location.href = pageURL;
  }
</script>
