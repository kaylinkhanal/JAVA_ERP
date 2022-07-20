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
                    <select id="branch" name="branch" class="form-control" required>
                        <option selected>Choose</option>
                        <option value="Bangrak">Bangrak</option>
                        <option value="Asok">Asok</option>
                    </select>
                </div>
                <div class="form-group col-md-6">
                    <label for="location">Location </label>
                    <select id="location" name="location" class="form-control" required>
                        <option selected>Choose</option>
                        <option value="Location 1">Location 1</option>
                        <option value="Location 2">Location 2</option>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                </div>
                <div class="form-group col-md-4">
                    <input type="file" class="form-control-file" id="fileupload" name="fileupload">
                </div>
                <div class="form-group col-md-4">
                </div>
            </div>
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
        </table>
    </div>
    </div>
</div>
</body>
</html>
<script><%@include file="/WEB-INF/script/booking.js" %></script>

