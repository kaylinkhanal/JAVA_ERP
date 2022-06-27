<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Create Installment</title>
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
      <h1>Create/Edit Installment</h1>
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
    <form method="post" action="invoice/addInstallment">
      <input type="hidden" value="${installment.id}" name="id" id="id" />
      <div class="form-row">
        <div class="form-group col-md-8">
          <label for="installmentNumber">Installment Number: </label>
          <input type="text" disabled class="form-control" id="installmentNumber" name="installmentNumber" value="" />
          <input type="hidden" name="installmentNumber" value="" />
        </div>
        <div class="form-group col-md-4">
          <label for="installmentDate">Installment Date: </label>
          <input type="date" class="form-control" id="installmentDate" name="installmentDate" value="" />
          <input type="hidden" name="installmentDate" value="" />
        </div>
      </div>
      <div class="form-row">
        <div class="form-group col-md-12">
          <label for="sequence">Sequence </label>
          <input type="text" class="form-control" id="sequence" name="sequence" value="" required />
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
          <label for="installmentTitle">Installment Title: </label>
          <input type="text" class="form-control" id="installmentTitle" name="installmentTitle" value="" required />
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
        <div class="form-group col-md-4">
          <input type="button" id="addItem" value="Add Item"/>
        </div>
      </div>
      <div class="form-row">
        <label class="col-md-2">Merge</label>
        <label class="col-md-2">Item</label>
        <label class="col-md-8 taxable">VAT taxable?</label>
      </div>
      <div class="form-row" style="background: aliceblue">
        <div class="form-group col-md-2">
        </div>
        <div class="form-group col-md-2">
          <br/><br/>
          <label>Subtotal: </label>
        </div>
        <div class="form-group col-md-2">
          <label for="vat">Non-Vat </label>
          <div class="col-md-10">
            <input type="text" class="form-control" id="nonVat" name="nonVat" value="" />
          </div>
        </div>
        <div class="form-group col-md-2">
          <label for="currency">Vat </label>
          <input type="text" class="form-control" id="subtotalVat" name="subtotalVat" value="" />
        </div>
        <div class="form-group col-md-2">
          <label for="exchangeRate">Amount </label>
          <input type="text" class="form-control" id="subtotalAmount" name="subtotalAmount" value="" />
        </div>
        <div class="form-group col-md-2">
        </div>
      </div><br/>
      <div class="form-row col-md-6">
        <div class="form-group col-md-2">
          <input type="submit" value="Save">
        </div>
        <div class="form-group col-md-2">
          <input type="button" value="Cancel">
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
<script><%@include file="/WEB-INF/script/invoice.js" %></script>
