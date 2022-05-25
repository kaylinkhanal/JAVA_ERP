<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/base.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Register Page</title>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Personal Address Information</h1>
          <hr />
        </div>

        <form>
          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="addressId">Address Id: </label>
              <input type="text" disabled class="form-control" id="addressId" />
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="addressType">Address Type: </label>
              <select id="addressType" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
              </select>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-8">
              <label for="addressNo">Address No: </label>
              <input type="text" class="form-control" id="addressNo" />
            </div>
            <div class="form-group col-md-4">
              <label for="country">Country</label>
              <select id="country" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
              </select>
            </div>
          </div>

          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="phone1">Phone1: </label>
              <input type="text" class="form-control" id="phone1" />
            </div>
            <div class="form-group col-md-4">
              <label for="phone2">Phone2: </label>
              <input type="text" class="form-control" id="phone2" />
            </div>

            <div class="form-group col-md-4">
              <label for="fax">Fax: </label>
              <input type="text" class="form-control" id="fax" />
            </div>
          </div>
          <button type="button" class="btn btn-primary">Save</button
          ><br /><br />
        </form>
      </div>
      <div align="center" class="container">
        <table border="1" width="60%" class="table table-striped">
          <thead align="center" class="bg-primary">
            <tr>
              <td>Adress ID</td>
              <td>Address Type</td>
              <td>Phone</td>
              <td>Country</td>
              <td>Status</td>
              <td></td>
            </tr>
          </thead>

          <tbody align="center">
            <tr>
              <td>001</td>
              <td>Home</td>
              <td>+662 488-3322</td>
              <td>123 ABC Road</td>
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
              <td>123 ABC Road</td>
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
  </body>
</html>
