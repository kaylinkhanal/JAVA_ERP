<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Create Invoice</title>
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
                <c:forEach var="invoice" items="${page.getObjects()}">
                    <tbody align="center">
                    <tr>
                        <td>${invoice.caseDto.caseId}</td>
                        <td>${invoice.invoiceTitle}</td>
                        <td>${invoice.caseDto.customer.fullName != null ? invoice.caseDto.customer.fullName: invoice.caseDto.customer.companyName}</td>
                        <td>${invoice.re}</td>
                        <td><fmt:formatDate pattern="dd-MM-yyyy" value = "${invoice.caseDto.operatingDate}"/></td>
                        <td>
                            <i class="far fa-edit icon-button" onclick="openPage('/invoice/edit/${invoice.invoiceId}')"></i>
                            <i class="far fa-trash-alt icon-button" onclick="openPage('/invoice/delete/${invoice.invoiceId}')"></i>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
            <jsp:include page="/WEB-INF/jsp/templates/page.jsp">
                <jsp:param name="page" value="${page}" />
            </jsp:include>
        </div>
        <form method="post" action="/invoice/addInvoice">
            <div class="form-row">
                <div class="form-group col-md-8">
                    <label for="invoiceNumber">Invoice Number: </label>
                    <input type="text" disabled class="form-control" id="invoiceNumber" name="invoiceNumber" value="${invoiceNumber!=null ? invoiceNumber: invoice.invoiceNumber}" />
                    <input type="hidden" name="invoiceNumber" value="${invoiceNumber}" />
                    <input type="hidden" name="caseDto" value="${caseId}" />
                </div>
                <div class="form-group col-md-4">
                    <label for="invoiceDate">Invoice Date: </label>
                    <input type="date" class="form-control" id="invoiceDate" name="invoiceDate" pattern="mm/dd/yyyy" value="${invoice.invoiceDate}"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="re">RE: <strong>Copy default</strong> </label>
                    <input type="text" class="form-control" id="re" name="re" value="${invoice.re}" required />
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="caseRemark">Case Remark: </label>
                    <input type="text" class="form-control" id="caseRemark" name="caseRemark" value="${invoice.caseRemark}" required />
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="rejectRemark">Reject Remark: </label>
                    <input type="text" class="form-control" id="rejectRemark" name="rejectRemark" value="${invoice.rejectRemark}" required />
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="invoiceTitle">Invoice Title: </label>
                    <input type="text" class="form-control" id="invoiceTitle" name="invoiceTitle" value="${invoice.invoiceTitle}" required />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="vat">Vat: </label>
                    <input type="text" class="form-control" id="vat" name="vat" value="${invoice.vat}" required />
                </div>
                <div class="form-group col-md-4">
                    <label for="currency">Currency: </label>
                    <select id="currency" name="currency" class="form-control" value="${invoice.currency}" required>
                        <c:choose>
                            <c:when test="${invoice == null}">
                                <option selected value="">Choose...</option>
                            </c:when>
                            <c:otherwise>
                                <option selected value="${invoice.currency.currencyId}">${invoice.currency.currencyName}</option>
                            </c:otherwise>
                        </c:choose>

                        <c:forEach var="currency" items="${currencies }" >
                            <option value="${currency.currencyId }">${currency.currencyName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-md-4">
                    <label for="exchangeRate">Exchange Rate: </label>
                    <input type="text" class="form-control" id="exchangeRate" name="exchangeRate" value="${invoice.exchangeRate}" required />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="paymentTerm">Payment Term: </label>
                    <input type="text" class="form-control" id="paymentTerm" name="paymentTerm" value="${invoice.paymentTerm}" required />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="bankAccount">Bank Account: </label>
                    <input type="text" class="form-control" id="bankAccount" name="bankAccount" value="${invoice.bankAccount}" required />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="description">Select tasks to create Invoice: </label>
                    <input type="text" class="form-control" id="description" name="description" value="${invoice.description}" required />
                </div>
            </div>
            <div class="form-row col-md-6">
                <div class="form-group col-md-4">
                    <input type="button" id="addItem" value="Add Item"/>
                </div>
                <div class="form-group col-md-4">
                    <input type="button" id="addInstallment" value="Add Installment"/>
                </div>
                <div class="form-group col-md-4">
                    <button>Add Deposit</button>
                </div>
            </div>
            <div class="form-row">
                <label class="col-md-2">Merge</label>
                <label class="col-md-2">Item</label>
                <label class="col-md-8 taxable">VAT taxable?</label>
            </div>
            <div class="form-row" style="background: aliceblue">

                <div class="form-group col-md-3">
                    <br/><br/>
                    <label>Subtotal: </label>
                </div>
                <div class="form-group col-md-3">
                    <label for="vat">Non-Vat </label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="nonVat" name="nonVat" value="" />
                    </div>
                </div>
                <div class="form-group col-md-3">
                    <label for="currency">Vat </label>
                    <input type="text" class="form-control" id="subtotalVat" name="subtotalVat" value="" />
                </div>
                <div class="form-group col-md-3">
                    <label for="exchangeRate">Amount </label>
                    <input type="text" class="form-control" id="subtotalAmount" name="subtotalAmount" value="" />
                </div>

            </div><br/>
            <div class="form-row" id="item" style="visibility: hidden; background: darkgray">
                <div class="form-group col-md-12">
                    <br/>
                    <label for="vat" id="itemName" class="col-md-4"></label>
                    <label class="col-md-2">Amount</label>
                    <input class="col-md-5" type="text" placeholder="0.00">
                    <hr/>
                </div>
            </div><br>
            <input class="btn btn-primary" value="Save" type="submit"/>
        </form>
        <br>
    </div>

</div>
<jsp:include page="/WEB-INF/jsp/templates/searchModal.jsp">
    <jsp:param name="modalId" value="itemSearchModal" />
    <jsp:param name="title" value="Search Item" />
    <jsp:param name="placeholder" value="Search an item" />
    <jsp:param name="id" value="Item Id" />
    <jsp:param name="name" value="Item Name" />
    <jsp:param name="other" value="Item Part Name" />
    <jsp:param name="tableName" value="itemTable" />
</jsp:include>
<jsp:include page="/WEB-INF/jsp/templates/searchModal.jsp">
    <jsp:param name="modalId" value="installmentSearchModal" />
    <jsp:param name="title" value="Search Installment" />
    <jsp:param name="placeholder" value="Search an installment" />
    <jsp:param name="id" value="Installment Id" />
    <jsp:param name="name" value="Installment Title" />
    <jsp:param name="other" value="Installment Number" />
    <jsp:param name="tableName" value="installmentTable" />
</jsp:include>
</body>
</body>
</html>
<script><%@include file="/WEB-INF/script/invoice.js" %></script>
