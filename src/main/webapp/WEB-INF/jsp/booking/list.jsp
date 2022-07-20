<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>Booking List</title>
  <style>
    .taxable {
      display: flex;
      justify-content: end;
    }
  </style>
</head>
<body>
<div class="container-wrapper">
  <div class="container">
    <div class="page-header">
      <h1>View Case</h1>
      <hr />
    </div>
    <div style="display: flex">
      <button onclick="openPage('/booking/create?caseId=${caseId}')" class="btn btn-primary">Create Booking</button>
    </div>
    <div align="center" class="col-md-12">
      <table border="1" width="100%" class="table table-striped" id="caseTable">
        <thead align="center" class="bg-primary">
        <tr>
          <td>Case ID</td>
          <td>Customer Code</td>
          <td>Title</td>
          <td>Customer Name</td>
          <td>Contact Name</td>
          <td>Pre Billing</td>
          <td>Status</td>
          <td></td>
        </tr>
        </thead>
          <tbody align="center">
          <tr>
            <td>${caseDto.caseId}</td>
            <td>${caseDto.customer.code}</td>
            <td>${caseDto.title}</td>
            <td>${caseDto.customer.companyName != null ? caseDto.customer.companyName : caseDto.customer.fullName}</td>
            <td>${caseDto.contactPerson.contactName}</td>
            <td></td>
            <td>${caseDto.status}</td>
          </tr>
      </table>
    </div>
    <div>
      <div class="page-header">
        <h1>All Booking</h1>
        <hr />
      </div>
    </div>
    <div align="center">
      <table border="1" width="60%" class="table table-striped">
        <thead align="center" class="bg-primary">
        <tr>
          <td>Booking ID</td>
          <td>Number</td>
          <td>Size or Dimension</td>
          <td>Type</td>
          <td>Select</td>
        </tr>
        </thead>
        <c:forEach var="booking" items="${bookings}">
          <tbody align="center">
          <tr>
            <td>${booking.bookingId}</td>
            <td>${booking.number}</td>
            <td>${booking.size}</td>
            <td>${booking.type}</td>
            <td>
<%--              <i class="far fa-edit icon-button" onclick="openPage('/booking/edit/${booking.bookingId}')"></i>--%>
              <i class="far fa-edit icon-button"></i>
            </td>
          </tr>
          </tbody>
        </c:forEach>
      </table>
    </div>
  </div>

</div>