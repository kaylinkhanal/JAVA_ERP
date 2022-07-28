<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %> <%@
        taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1" />
    <title>Customer List</title>
</head>
<body>
<div class="container-wrapper">
    <div class="container">
        <br/>
        <div class="page-header">
            <h1>Customer List</h1>
            <hr />
        </div>
        <div class="container">
            <button type="button" class="btn btn-primary float-right" onclick="openPage('/personalRegister')">Create New Customer</button>
        </div><br/>
        <div align="center" class="container">
            <table border="1" width="60%" class="table table-striped">
                <thead align="center" class="bg-primary">
                <tr>
                    <td>Customer ID</td>
                    <td>Customer Type</td>
                    <td>Customer Name</td>
                    <td>Customer Address</td>
                    <td>Contact Person</td>
                    <td>ID/Passport No.</td>
                    <td>Gender</td>
                    <td>Action</td>
                </tr>
                </thead>
                <c:forEach var="customer" items="${customers}">
                    <tbody align="center">
                    <tr>
                        <td>${customer.customerId}</td>
                        <td>${customer.type}</td>
                        <td>${customer.firstName != null ? customer.firstName : customer.companyName}</td>
                        <td>${customer.address != null ? customer.address.get(0).addressNo : customer.site.get(0).address}</td>
                        <td>${customer.contactPerson != null ? customer.contactPerson.get(0).contactName : ''}</td>
                        <td>${customer.idPassportNo != null ? customer.idPassportNo : ''}</td>
                        <td>${customer.gender != null ? customer.gender : ''}</td>

                        <td>
                            <i class="far fa-edit icon-button" onclick="openPage('/editCustomer/${customer.customerId}')"></i>
<%--                            <i class="far fa-trash-alt icon-button" onclick="openPage('/deleteCustomer/${customer.customerId}')"></i>--%>
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
<script><%@include file="/WEB-INF/script/documentPreview.js" %></script>