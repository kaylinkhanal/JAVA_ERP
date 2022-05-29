<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Company Contact Person Information</title>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Company Contact Person Information</h1>
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
            <div class="form-group col-md-4">
              <label for="contactName">Contact Name: </label>
              <input type="text" class="form-control" id="contactName" />
            </div>
            <div class="form-group col-md-4">
              <label for="dep">Dep: </label>
              <input type="text" class="form-control" id="dep" />
            </div>
            <div class="form-group col-md-4">
              <label for="title">Title: </label>
              <input type="text" class="form-control" id="title" />
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
              <label for="site">Site</label>
              <select id="site" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
              </select>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-12">
              <label for="description">Description: </label>
              <textArea type="text" row="3" class="form-control" id="description"
              ></textArea>
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
              <td>Contact ID</td>
              <td>Contact Name</td>
              <td>Phone</td>
              <td>Email</td>
              <td>Site</td>
              <td>Status</td>
              <td></td>
            </tr>
          </thead>

          <tbody align="center">
            <tr>
              <td>001</td>
              <td>ABC Company</td>
              <td>+662 488-3322</td>
              <td>abc@gmail.com</td>
              <td>ABC</td>
              <td>Enable</td>
              <td>
                <i class="far fa-edit"></i>
                <i class="far fa-trash-alt"></i>
              </td>
            </tr>
            <tr>
              <td>002</td>
              <td>Natty</td>
              <td>+662 488-3322</td>
              <td>abc@gmail.com</td>
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
