<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Company Finance Information</title>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Company Finance Information</h1>
          <hr />
        </div>

        <form>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="creditLine">Credit Line: </label>
              <input
                type="text"
                disabled
                class="form-control"
                id="creditLine"
              />
            </div>
            <div class="form-group col-md-6">
              <label for="paymentTerm">Payment Term</label>
              <select id="paymentTerm" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
              </select>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="bankName">Bank Name: </label>
              <input type="text" class="form-control" id="bankName" />
            </div>
            <div class="form-group col-md-6">
              <label for="accountNumber">Account Number: </label>
              <input type="text" class="form-control" id="accountNumber" />
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="currency">Currency</label>
              <select id="currency" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
              </select>
            </div>
            <div class="form-group col-md-6">
              <label for="country">Country</label>
              <select id="country" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
              </select>
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
              <td>Payment Term</td>
              <td>Bank Name</td>
              <td>Account Number</td>
              <td>Currency</td>
              <td>Country</td>
              <td>Status</td>
              <td></td>
            </tr>
          </thead>

          <tbody align="center">
            <tr>
              <td>001</td>
              <td>XXX</td>
              <td>662 488-3322</td>
              <td>THB</td>
              <td>ABC</td>
              <td>Enable</td>
              <td>
                <i class="far fa-edit"></i>
                <i class="far fa-trash-alt"></i>
              </td>
            </tr>
            <tr>
              <td>002</td>
              <td>XXX</td>
              <td>662 488-3322</td>
              <td>THB</td>
              <td>ABC</td>
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
