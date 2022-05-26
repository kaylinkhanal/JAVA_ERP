<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/base.jsp" %> <%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Document Type List</title>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container">
        <br/>
        <div class="page-header">
          <h1>Document Type List</h1>
          <hr />
        </div>
        <div class="col-md-12">
            <form method="get" action="searchDocumentType" >
                <div class="form-row justify-content-end">
                    <input type="text" class="form-control col-md-6" name="search" id="search" placeholder="Put your document name"/>
                    <div class="col-me-2"></div>
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </form>
        </div>
        <br/>
       <div class="col-md-12">
            <form method="post" action="addDocumentType">
                <div class="form-row justify-content-end">
                    <div class="form-group col-md-3">
                    <input type="text" class="form-control" id="passportNo" />
                    </div>
                    <div class="form-group col-md-3">
                    <input type="text" class="form-control" id="email" />
                    </div>
                    <div class="form-group col-md-3">
                    <input type="text" class="form-control" id="contactNo" />
                    </div>
                    <div class="form-group">
                    <button type="button" id="save" class="btn btn-primary float-right"> Save </button>
                    </div>
                </div>
            </form>
       </div><br/>
       <h5 for="typeList" class="col-form-label">Document Type List</h5>
       <div align="center" class="container">
        <table border="1" width="60%" class="table table-striped">
          <thead align="center" class="bg-primary">
            <tr>
              <td>Document Type</td>
              <td>Document Type Name</td>
              <td>Description</td>
              <td>Action</td>
              <td>View</td>
            </tr>
          </thead>

          <tbody align="center">
            <tr>
              <td>Final Lease</td>
              <td>Final Lease</td>
              <td></td>
              <td>
                <i class="far fa-edit"></i>
                <i class="far fa-trash-alt"></i>
              </td>
              <td>
                <i class="far fa-file-alt"></i>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      </div>
    </div>
  </body>
</html>