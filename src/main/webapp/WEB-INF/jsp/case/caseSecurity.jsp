<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/base.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Case Security</title>
    <style></style>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container mt-5">
        <div class="row">
          <div class="col-md-12">
            <h5 class="float-right">
              <span>Customer ID: </span>
              <button type="button" class="btn btn-secondary">00001</button>
              <button type="button" class="btn btn-secondary">John Doe</button>
            </h5>
          </div>
        </div>
        <form class="col-xs-12 border p-3">
          <div class="col-md-12 row">
            <div class="col-md-6 row">
              <h3 class="float-left">
                <span>Case ID: </span>
                <button type="button" class="btn btn-secondary">0001</button>
              </h3>
            </div>
            <div class="col-md-6 row">
              <label class="col-form-label col-md-4" for="location"
                >Location</label
              >
              <select id="status" class="form-control col-md-8">
                <option selected>Choose...</option>
                <option>...</option>
              </select>
            </div>
            <div class="col-md-12 row">
              <input
                type="button"
                class="btn btn-primary float-right"
                value="Save"
              />
            </div>
            <br />
          </div>
        </form>
      </div>
    </div>
  </body>
</html>
