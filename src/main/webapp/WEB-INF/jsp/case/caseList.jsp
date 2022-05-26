<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/base.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Case List</title>
    <style></style>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container mt-5">
        <div class="row">
          <div class="col-md-12">
            <h3 class="float-right">
              <span>Customer ID: </span>
              <button type="button" class="btn btn-secondary">00001</button>
              <button type="button" class="btn btn-secondary">John Does</button>
            </h3>
          </div>
        </div>
        <div class="col-md-12 row">
          <h3 class="float-left">
            <span>CaseList: </span>
            <button type="button" class="btn btn-primary">
              Create New Case
            </button>
          </h3>
        </div>
        <form class="col-xs-12">
          <div class="form-row">
            <div class="form-group col-md-3">
              <label for="search">Search: </label>
              <input type="text" class="form-control" id="search" />
            </div>
            <div class="form-group col-md-3">
              <label for="search1"> : </label>
              <input type="text" class="form-control" id="search1" />
            </div>
            <div class="form-group col-md-3">
              <label for="filter">Filter</label>
              <select id="filter" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
              </select>
            </div>
            <div class="form-group col-md-3">
              <label for="newStatus">New Status</label>
              <select id="newStatus" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
              </select>
            </div>
          </div>
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
