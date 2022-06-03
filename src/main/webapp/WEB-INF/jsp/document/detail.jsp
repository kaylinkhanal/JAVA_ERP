<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1" />
  <title>Document Template Detail</title>
</head>
<body>
<div class="container-wrapper">
  <div class="container">
    <br/>
    <div class="page-header">
      <h1>Generate Document Detail</h1>
      <hr />
    </div>
    <div class="form-row justify-content-end">
      <div class="form-group col-md-4">
        <input type="text" class="form-control" id="type" name="type" disabled value="${documentType.type}" required/>
      </div>
      <div class="form-group col-md-4">
        <input type="text" class="form-control" id="documentTypeName" name="documentTypeName" disabled value="${documentType.documentTypeName}" required />
      </div>
      <div class="form-group col-md-4">
        <input type="text" class="form-control" id="description" name="description" disabled value="${documentType.description}" required />
      </div>
    </div>
  </div>
</div>
</body>
</html>
