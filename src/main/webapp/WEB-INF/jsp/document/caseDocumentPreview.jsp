<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %> <%@
        taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1" />
    <title>Document Template</title>
    <style>
        .docs {
            background: azure;
            padding: 20px;
        }
    </style>
</head>
<body>
<div class="container-wrapper">
    <div class="container">
        <br/>
        <div class="page-header">
            <h1>Preview Document Template</h1>
            <hr />
        </div>
        <div class="border border-dark docs" id="document-text">
            ${document}
        </div>
        <br><br>
        <button type="button" onclick="printDocument($('#document-text').html())" class="btn btn-primary float-right" id="save"><span class="far fa-save"></span>  Save</button>
        <br><br>
    </div>
</div>
</body>
</html>

<script><%@include file="/WEB-INF/script/documentPreview.js" %></script>