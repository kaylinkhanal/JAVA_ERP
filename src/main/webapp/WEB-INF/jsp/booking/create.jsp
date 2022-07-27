<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create Booking</title>
</head>
<body>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Create Booking</h1>
            <hr />
        </div>
        <form method="post" enctype="multipart/form-data" id="bookingForm">
            <input type="hidden" name="bookingId" id="bookingId" value="${booking.bookingId}" />
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="branch">Branch </label>
                    <select id="branch" name="branch" class="form-control" required value="${booking.branch}">
                        <option selected value="">Choose</option>
                        <option value="Bangrak">Bangrak</option>
                        <option value="Asok">Asok</option>
                    </select>
                </div>
                <div class="form-group col-md-6">
                    <label for="location">Location </label>
                    <select id="location" name="location" class="form-control" required value="${booking.location}">
                        <option selected value="">Choose</option>
                        <option value="Location 1">Location 1</option>
                        <option value="Location 2">Location 2</option>
                    </select>
                </div>
            </div>
            <c:if test="${booking.document == null}">
                <div class="form-row">
                    <div class="form-group col-md-4">
                    </div>
                    <div class="form-group col-md-4">
                        <input type="file" class="form-control-file" id="fileupload" name="fileupload" value="${booking.bookingId}">
                    </div>
                    <div class="form-group col-md-4">
                    </div>
                </div>
            </c:if>
            <c:if test="${booking.document != null}">
                <%--              show document--%>
                <div align="center" class="col-md-12">
                    <table border="1" width="100%" class="table table-striped" >
                        <thead align="center" class="bg-primary">
                        <tr>
                            <td>Document Name</td>
                            <td>Action</td>
                        </tr>
                        </thead>
                        <tbody align="center">
                        <tr>
                            <td>${booking.documentName}</td>
                            <td>
                                <i class="far fa-trash-alt icon-button" onclick="openPage('/booking/deleteBookingDocument/${booking.bookingId}/${document.booking.document.documentId}')"></i>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </c:if>
            <div align="center">
                <table border="1" width="60%" class="table table-striped" id="bookingTable">
                    <thead align="center" class="bg-primary">
                    <tr>
                        <td>Status</td>
                        <td>Number</td>
                        <td>Size or Dimension</td>
                        <td>Type</td>
                        <td>Select</td>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
            <div style="display: flex; justify-content: center">
                <input type="submit" class="btn btn-info" value="Save"><br>
                <input type="reset" class="btn btn-danger ml-2" id="cancel" value="Cancel">
            </div>
            <br /><br />
        </form>
     <div align="center">
        <table border="1" width="60%" class="table table-striped boxTable" id="boxTable">
            <thead align="center" class="bg-primary">
            <tr>
                <td>Status</td>
                <td>Number</td>
                <td>Size or Dimension</td>
                <td>Type</td>
                <td>Select</td>
            </tr>
            </thead>
            <c:forEach var="box" items="${boxes}">
                <tbody align="center">
                <tr>
                    <td>Active</td>
                    <td>${box.securityBoxNumber}</td>
                    <td>${box.lockerSize}</td>
                    <td>${box.lockerType}</td>
                    <td>
                        <button class="btn btn-info" id="selectButton">Select</button>
                    </td>
                </tr>
                </tbody>
            </c:forEach>
            <c:if test="${booking.bookingDetails.size() > 0}">
                <c:forEach var="bookingDetail" items="${bookingDetails}">
                    <tbody align="center">
                    <tr>
                        <td>Active</td>
                        <td>${bookingDetail.securityBoxNumber}</td>
                        <td>${bookingDetail.lockerSize}</td>
                        <td>${bookingDetail.lockerType}</td>
                        <td>
                            <button class="btn btn-info" id="deleteButton">Select</button>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </c:if>
        </table>
    </div>
    </div>
</div>
</body>
</html>
<script>
    $(document).ready(function() {
        $('input[type="file"]').change(function(e) {
            var file = e.target.files[0].name;
            $("#documentName").val(file)
            console.log(file)
        });
    });
</script>
<script><%@include file="/WEB-INF/script/booking.js" %></script>

