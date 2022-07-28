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
                  <c:forEach var="address" items="${page.getObjects()}">
                      <tbody align="center">
                      <tr>
                          <td>${address.documentId}</td>
                          <td>${address.documentName}</td>
                          <td>${address.documentType.documentTypeName}</td>
                          <td>${address.branch}</td>
                          <td>${address.language}</td>
                          <td>Enable</td>
                          <td>
                              <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Print Document" data-placement="right">
                                <i class="fa fa-print icon-button" onclick="printBlankDocument(${address.documentId})"></i>
                              </span>
                              <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Edit Document" data-placement="right">
                                <i class="far fa-edit icon-button" onclick="openPage('/document/editDocument/${address.documentId}')"></i>
                              </span>
                              <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Delete Document" data-placement="right">
                                <i class="far fa-trash-alt icon-button" onclick="deleteDocument('/document/deleteDocument/${address.documentId}')"></i>
                              </span>
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
  <jsp:include page="/WEB-INF/jsp/templates/deleteModal.jsp">
      <jsp:param name="message" value="Delete this Document?"/>
  </jsp:include>
</html>
<script type="text/javascript">
    function deleteDocument(url) {
        $("#deleteModal").modal("show");
        $("#deleteButton").on('click', function() {
            openPage(url);
        })
    }
</script>
<script><%@include file="/WEB-INF/script/documentPreview.js" %></script>