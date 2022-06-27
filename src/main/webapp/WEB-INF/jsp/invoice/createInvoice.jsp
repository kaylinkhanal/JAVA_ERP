<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create Invoice</title>
</head>
<body>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Create Invoice</h1>
            <hr />
        </div>
        <div align="center">
            <table border="1" width="60%" class="table table-striped">
                <thead align="center" class="bg-primary">
                <tr>
                    <td>Case ID</td>
                    <td>Title</td>
                    <td>Customer</td>
                    <td>Contact</td>
                    <td>Opening Date</td>
                    <td>Status</td>
                </tr>
                </thead>
                <c:forEach var="address" items="${page.getObjects()}">
                    <tbody align="center">
                    <tr>
                        <td>${address.addressId}</td>
                        <td>${address.addressType}</td>
                        <td>${address.phone1}</td>
                        <td>${address.country.countryName}</td>
                        <td>Enable</td>
                        <td>
                            <i class="far fa-edit icon-button" onclick="openPage('/editAddress/${address.addressId}')"></i>
                            <i class="far fa-trash-alt icon-button" onclick="openPage('/deleteAddress/${address.addressId}')"></i>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
            <jsp:include page="/WEB-INF/jsp/templates/page.jsp">
                <jsp:param name="page" value="${page}" />
            </jsp:include>
        </div>
        <form method="post" action="/addInvoice">
            <div class="form-row">
                <div class="form-group col-md-8">
                    <label for="invoiceNumber">Invoice Number: </label>
                    <input type="text" disabled class="form-control" id="invoiceNumber" name="invoiceNumber" value="" />
                    <input type="hidden" name="invoiceNumber" value="" />
                </div>
                <div class="form-group col-md-4">
                    <label for="invoiceDate">Invoice Date: </label>
                    <input type="date" class="form-control" id="invoiceDate" name="invoiceDate" value="" />
                    <input type="hidden" name="invoiceDate" value="" />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="re">RE: <strong>Copy default</strong> </label>
                    <input type="text" class="form-control" id="re" name="re" value="" required />
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="caseRemark">Case Remark: </label>
                    <input type="text" class="form-control" id="caseRemark" name="caseRemark" value="" required />
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="rejectRemark">Reject Remark: </label>
                    <input type="text" class="form-control" id="rejectRemark" name="rejectRemark" value="" required />
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="invoiceTitle">Invoice Title: </label>
                    <input type="text" class="form-control" id="invoiceTitle" name="invoiceTitle" value="" required />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="vat">Vat: </label>
                    <input type="text" class="form-control" id="vat" name="vat" value="" required />
                </div>
                <div class="form-group col-md-4">
                    <label for="currency">Currency: </label>
                    <input type="text" class="form-control" id="currency" name="addressNo" value="" required />
                </div>
                <div class="form-group col-md-4">
                    <label for="exchangeRate">Exchange Rate: </label>
                    <input type="text" class="form-control" id="exchangeRate" name="exchangeRate" value="" required />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="paymentTerm">Payment Term: </label>
                    <input type="text" class="form-control" id="paymentTerm" name="paymentTerm" value="" required />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="bankAccount">Bank Account: </label>
                    <input type="text" class="form-control" id="bankAccount" name="bankAccount" value="" required />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="description">Select tasks to create Invoice: </label>
                    <input type="text" class="form-control" id="description" name="description" value="" required />
                </div>
            </div>
            <div class="form-row col-md-6">
                <div class="form-group col-md-4">
                    <button>Add Item</button>
                </div>
                <div class="form-group col-md-4">
                    <button>Add Installment</button>
                </div>
                <div class="form-group col-md-4">
                    <button>Add Deposit</button>
                </div>
            </div>
        </form>
    </div>

</div>
<div id="searchModal" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Search Customers</h5>
                <button type="button" class="close" id="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <input type="text" id="keyword" name="keyword" class="searchInput" placeholder="Customer name or code">
            <div class="modal-body">
                <form>
                    <table id="customerTable" class="table">
                        <thead><td></td><td>Customer Name</td><td>Customer Code</td><td>Type</td></thead>
                        <tbody></tbody>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</body>
</html>
