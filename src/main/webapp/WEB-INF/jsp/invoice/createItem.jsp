<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Item</h1>
            <hr />
        </div>

        <form method="post" action="/addItem">
            <input type="hidden" value="${address != null ? address.customer.customerId : customer.customerId}" name="customer" id="customer" />
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="itemId">Item Id: </label>
                    <input type="text" disabled class="form-control" id="itemId" name="itemId" value="${item.itemId}" />
                    <input type="hidden" name="itemId" value="${item.itemId}" />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-8">
                    <label for="itemName">Item Name: </label>
                    <input type="text" class="form-control" id="itemName" name="itemName" value="" required />
                </div>
                <div class="form-group col-md-4">
                    <label for="itemPartName">Item Part Name:</label>
                    <select id="itemPartName"  name="itemPartName" class="form-control" required/>
                    <c:choose>
                        <c:when test="${address == null}">
                            <option selected value="">Choose...</option>
                        </c:when>
                        <c:otherwise>
<%--                            <option selected value="${address.country.countryId}">${address.country.countryName}</option>--%>
                            <option value="one">Item One</option>
                            <option value="two">Item Two</option>
                        </c:otherwise>
                    </c:choose>

                    <c:forEach var="country" items="${countries }" >
                        <option value="${country.countryId }">${country.countryName}</option>
                    </c:forEach>
                    </select>
                </div>
            </div>
            <c:choose>
                <c:when test="${item == null}">
                    <input type="submit" class="btn btn-primary" value="Save">
                </c:when>
                <c:otherwise>
                    <input type="submit" class="btn btn-primary" value="Update">
                </c:otherwise>
            </c:choose>
            <br /><br />
        </form>
    </div>
    <div align="center" class="container">
        <table border="1" width="60%" class="table table-striped">
            <thead align="center" class="bg-primary">
            <tr>
                <td>Item ID</td>
                <td>Item Name</td>
                <td>Item Part Name</td>
                <td>Status</td>
                <td></td>
            </tr>
            </thead>
            <c:forEach var="address" items="${page.getObjects()}">
                <tbody align="center">
                <tr>
                    <td>${address.addressId}</td>
                    <td>${address.addressType}</td>
                    <td>${address.phone1}</td>
                    <td>Enable</td>
                    <td>
                        <i class="far fa-edit icon-button" onclick="openPage('/editItem/${item.itemId}')"></i>
                        <i class="far fa-trash-alt icon-button" onclick="openPage('/deleteItem/${item.itemId}')"></i>
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
