<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %> <%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Document Template List</title>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container">
        <br/>
        <div class="page-header">
          <h1>Document Template List</h1>
          <hr />
        </div>
          <div class="container">
              <button type="button" class="btn btn-primary float-right" onclick="openPage('/document/create')">Create</button>
          </div><br/>
          <div align="center" class="container">
              <table border="1" width="60%" class="table table-striped">
                  <thead align="center" class="bg-primary">
                  <tr>
                      <td>Document No</td>
                      <td>Document Name</td>
                      <td>Document Type</td>
                      <td>Branch</td>
                      <td>Language</td>
                      <td>Status</td>
                      <td>Action</td>
                  </tr>
                  </thead>
                  <c:forEach var="document" items="${page.getObjects()}">
                      <tbody align="center">
                      <tr>
                          <td>${document.documentId}</td>
                          <td>${document.documentName}</td>
                          <td>${document.documentType.documentTypeName}</td>
                          <td>${document.branch}</td>
                          <td>${document.language}</td>
                          <td>Enable</td>
                          <td>
                              <i class="fa fa-print icon-button"></i>
                              <i class="far fa-edit icon-button" onclick="openPage('/document/editDocument/${document.documentId}')"></i>
                              <i class="far fa-trash-alt icon-button" onclick="openPage('/document/deleteDocument/${document.documentId}')"></i>
                          </td>
                      </tr>
                      </tbody>
                  </c:forEach>
              </table>
              <jsp:include page="/WEB-INF/jsp/templates/page.jsp">
                  <jsp:param name="page" value="${page}" />
              </jsp:include>
          </div>
      </div>

      </div>
    </div>
  </body>
</html>