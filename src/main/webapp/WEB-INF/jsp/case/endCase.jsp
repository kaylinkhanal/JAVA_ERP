<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1" />
    <title>End Case</title>
</head>
<body>
<div class="container">
    <div class="col-md-12 row">
        <h3>Case Information</h3>
    </div>
    <h5>Booking Information</h5>
    <div align="center" class="col-md-12">
        <table border="1" width="100%" class="table table-striped">
            <thead align="center" class="bg-primary">
            <tr>
                <td>Booking ID</td>
                <td>Branch</td>
                <td>Location</td>
                <td>Document</td>
            </tr>
            </thead>
            <c:forEach var="booking" items="${bookings}">
                <tbody align="center">
                <tr>
                    <td>${booking.bookingId}</td>
                    <td>${booking.branch}</td>
                    <td>${booking.location}</td>
                    <td>${booking.documentName}</td>

                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
    <hr/>
    <h5>Invoice Information</h5>
    <div align="center" class="col-md-12">
        <table border="1" width="100%" class="table table-striped">
            <thead align="center" class="bg-primary">
            <tr>
                <td>Invoice ID</td>
                <td>Invoice Title</td>
                <td>Case Remark</td>
                <td>Amount</td>

            </tr>
            </thead>
            <c:forEach var="invoice" items="${invoices}">
                <tbody align="center">
                <tr>
                    <td>${invoice.invoiceId}</td>
                    <td>${invoice.invoiceTitle}</td>
                    <td>${invoice.caseRemark}</td>
                    <td>${invoice.amount}</td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
    <hr/>
    <h5>Installment Information</h5>
    <div align="center" class="col-md-12">
        <table border="1" width="100%" class="table table-striped">
            <thead align="center" class="bg-primary">
            <tr>
                <td>Installment ID</td>
                <td>Installment Title</td>
                <td>Case Remark</td>
                <td>Amount</td>
            </tr>
            </thead>
            <c:forEach var="installment" items="${installments}">
                <tbody align="center">
                <tr>
                    <td>${installment.installmentId}</td>
                    <td>${installment.installmentTitle}</td>
                    <td>${installment.caseRemark}</td>
                    <td>${installment.amount}</td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
    <hr/>
    <h5>Deposit Information</h5>
    <div align="center" class="col-md-12">
        <table border="1" width="100%" class="table table-striped">
            <thead align="center" class="bg-primary">
            <tr>
                <td>Deposit ID</td>
                <td>Deposit Title</td>
                <td>Case Remark</td>
                <td>Amount</td>
            </tr>
            </thead>
            <c:forEach var="deposit" items="${deposits}">
                <tbody align="center">
                <tr>
                    <td>${deposit.depositId}</td>
                    <td>${deposit.depositTitle}</td>
                    <td>${deposit.caseRemark}</td>
                    <td>${deposit.amount}</td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
    <hr/>

</div>
</body>
</html>
<script><%@include file="/WEB-INF/script/case.js" %></script>
