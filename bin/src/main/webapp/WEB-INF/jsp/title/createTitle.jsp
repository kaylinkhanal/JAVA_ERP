<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create Title</title>
</head>
<body>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Title</h1>
            <hr />
        </div>
        <form method="post" action="/title/addTitle">
            <input type="hidden" name="titleId" value="${title.titleId}" />
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="caseTypeCode">Case Type Code </label>
                    <input type="text" class="form-control" id="caseTypeCode" name="caseTypeCode" value="${title.caseTypeCode}" required />
                </div>
                <div class="form-group col-md-6">
                    <label for="caseTypeCode">Case Type Name </label>
                    <input type="text" class="form-control" id="caseTypeName" name="caseTypeName" value="${title.caseTypeName}" required />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="duration">Duration </label>
                    <input type="text" class="form-control" id="duration" name="duration" value="${title.duration}" required />
                </div>
                <div class="form-group col-md-6">
                    <label for="price">Price </label>
                    <input type="text" class="form-control" id="price" name="price" value="${title.price}" required />
                </div>
            </div>
            <div style="display: flex; justify-content: center">
                <input type="submit" class="btn btn-info" value="Save"><br>
                <input type="reset" class="btn btn-danger ml-2" id="cancel" value="Cancel">
            </div>
            <br /><br />
        </form>
    </div>
    <div align="center" class="container">
        <table border="1" width="60%" class="table table-striped">
            <thead align="center" class="bg-primary">
            <tr>
                <td>Case Type Code</td>
                <td>Case Type Name</td>
                <td>Duration</td>
                <td>Price</td>
                <td></td>
            </tr>
            </thead>
            <c:forEach var="title" items="${page.getObjects()}">
                <tbody align="center">
                <tr>
                    <td>${title.caseTypeCode}</td>
                    <td>${title.caseTypeName}</td>
                    <td>${title.duration}</td>
                    <td>${title.price}</td>
                    <td>
                         <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Edit Title" data-placement="right">
                             <i class="far fa-edit icon-button" onclick="openPage('/title/editTitle/${title.titleId}')"></i>
                         </span>

<%--                        <i class="far fa-trash-alt icon-button" onclick="openPage('/title/deleteTitle/${title.titleId}')"></i>--%>
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
</body>
</html>
