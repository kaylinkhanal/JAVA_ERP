<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1" />
    <title>Email Template</title>
</head>
<body>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Email Template List</h1>
            <hr />
        </div>

        <form method="post" action="/findTemplate">
            <div class="form-row col-md-8">
                <div class="form-group col-md-6">
                    <input type="text"  class="form-control" id="template" name="template" placeholder="Browser Email Template"/>
                </div>
                <div class="form-group col-md-6">
                    <input type="submit" class="form-control btn-primary" value="Attach Email Template"/>
                </div>
            </div>

        </form>
    </div>
    <div align="center" class="container">
        <table border="1" width="60%" class="table table-striped">
            <thead align="center" class="bg-primary">
            <tr>
                <td>Template ID</td>
                <td>Email Template Name</td>
                <td>Created By</td>
                <td>Last Update</td>
                <td>Manage</td>
                <td></td>
            </tr>
            </thead>
            <c:forEach var="template" items="${page.getObjects()}">
                <tbody align="center">
                <tr>
                    <td>${template.templateId}</td>
                    <td>${template.templateName}</td>
                    <td>${template.createdBy}</td>
                    <td>${template.lastUpdatedBy}</td>
                    <td>${template.manage}</td>
                    <td>
                        <i class="far fa-file-alt icon-button" onclick="openPage('/email/viewTemplate/${template.templateId}')"></i>
                        <i class="far fa-edit icon-button" onclick="openPage('/email/editTemplate/${template.templateId}')"></i>
                        <i class="far fa-trash-alt icon-button" onclick="openPage('/email/deleteTemplate/${template.templateId}')"></i>
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

