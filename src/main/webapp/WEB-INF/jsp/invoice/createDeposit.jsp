<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Create Deposit</title>
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
            <h1>Create/Edit Deposit</h1>
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
                <c:forEach var="deposit" items="${page.getObjects()}">
                    <tbody align="center">
                    <tr>
                        <td>${deposit.caseDto.caseId}</td>
                        <td>${deposit.depositTitle}</td>
                        <td>${deposit.customer.fullName != null ? deposit.customer.fullName: deposit.customer.companyName}</td>
                        <td>${deposit.customer.contactNo}</td>
                        <td><fmt:formatDate pattern="dd-MM-yyyy" value = "${deposit.caseDto.operatingDate}"/></td>
                        <td>
                            <i class="far fa-edit icon-button" onclick="openPage('/deposit/editDeposit/${deposit.depositId}')"></i>
                            <i class="far fa-trash-alt icon-button" onclick="openPage('/deposit/deleteDeposit/${deposit.depositId}')"></i>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
            <jsp:include page="/WEB-INF/jsp/templates/page.jsp">
                <jsp:param name="page" value="${page}" />
            </jsp:include>
        </div>
        <form method="post" action="/invoice/addDeposit">
            <input type="hidden" value="${deposit.depositId}" name="depositId" id="depositId" />
            <input type="hidden" value="${caseDto.caseId}" name="caseDto" id="caseDto" />
            <input type="hidden" value="${caseDto.customer.customerId}" name="customer" id="customer" />
            <div class="form-row">
                <div class="form-group col-md-8">
                    <label for="depositNumber">Deposit Number: </label>
                    <input type="text" disabled class="form-control" id="depositNumber" name="depositNumber" value="${depositNumber}" />
                    <input type="hidden" name="depositNumber" value="${depositNumber}" />
                </div>
                <div class="form-group col-md-4">
                    <label for="depositDate">Deposit Date: </label>
                    <input type="date" class="form-control" id="depositDate" name="depositDate" value="" />
                    <input type="hidden" name="depositDate" value="" />
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
                    <label for="depositTitle">Deposit Title: </label>
                    <input type="text" class="form-control" id="depositTitle" name="depositTitle" value="" required />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="vat">Vat: </label>
                    <input type="text" class="form-control" id="vat" name="vat" value="" required />
                </div>
                <div class="form-group col-md-4">
                    <label for="currency">Currency: </label>
                    <select id="currency" name="currency" class="form-control" value="${deposit.currency}" required>
                        <c:choose>
                            <c:when test="${deposit == null}">
                                <option selected value="">Choose...</option>
                            </c:when>
                            <c:otherwise>
                                <option selected value="${deposit.currency.currencyId}">${deposit.currency.currencyName}</option>
                            </c:otherwise>
                        </c:choose>

                        <c:forEach var="currency" items="${currencies }" >
                            <option value="${currency.currencyId }">${currency.currencyName}</option>
                        </c:forEach>
                    </select>
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
            <div class="form-row" id="item" style="display: none; background: darkgray">
                <div class="form-group col-md-12">
                    <br/>
                    <label for="vat" id="itemName" class="col-md-4"></label>
                    <label class="col-md-2">Amount</label>
                    <input class="col-md-5" type="text" placeholder="0.00">
                    <hr/>
                </div>
            </div><br>
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
<jsp:include page="/WEB-INF/jsp/templates/searchModal.jsp">
    <jsp:param name="modalId" value="itemSearchModal" />
    <jsp:param name="title" value="Search Item" />
    <jsp:param name="placeholder" value="Search an item" />
    <jsp:param name="id" value="Item Id" />
    <jsp:param name="name" value="Item Name" />
    <jsp:param name="other" value="Item Part Name" />
    <jsp:param name="tableName" value="itemTable" />
</jsp:include>
</body>
</body>
</html>
<script><%@include file="/WEB-INF/script/invoice.js" %></script>