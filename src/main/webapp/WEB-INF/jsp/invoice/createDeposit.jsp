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
                        <td>${deposit.caseDto.customer.fullName != null ? deposit.caseDto.customer.fullName: deposit.caseDto.customer.companyName}</td>
                        <td>${deposit.caseDto.customer.contactNo}</td>
                        <td><fmt:formatDate pattern="dd-MM-yyyy" value = "${deposit.caseDto.operatingDate}"/></td>
                        <td>
                            <i class="far fa-edit icon-button" onclick="openPage('/invoice/editDeposit/${deposit.depositId}')"></i>
                            <i class="far fa-trash-alt icon-button" onclick="openPage('/invoice/deleteDeposit/${deposit.depositId}')"></i>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
            <jsp:include page="/WEB-INF/jsp/templates/page.jsp">
                <jsp:param name="page" value="${page}" />
            </jsp:include>
        </div>
        <form method="post" action="/invoice/addDeposit" id="addDepositForm">
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
                <div class="form-group col-md-6">
                </div>
                <div class="form-group col-md-6">
                    <label for="exchangeRate">Actual Amount </label>
                    <input type="text" class="form-control" id="amount" name="amount" value="" />
                </div>
            </div><br/>
            <div class="form-row" id="itemDiv" style="display: none; background: darkgray">
                <div class="form-group col-md-12">
                    <br/>
                    <label id="item" name="item" class="col-md-1"></label>
                    <label id="itemName" name="itemName" class="col-md-3"></label>
                    <label class="col-md-2">Amount</label>
                    <input class="col-md-5" type="text" name="itemAmount" id="itemAmount"  placeholder="0.00">
                    <button type="button" class="itemClose" id="itemClose">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <hr/>
                </div>
            </div>
            <br>
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
<script>
    $("#addDepositForm").submit(function(e) {
        e.preventDefault(); // prevent actual form submit
        // var form = $(this);
        // var url = form.attr('action'); //get submit url [replace url here if desired]
        let deposit = new Object();
        let dto = new Object();
        let itemName = $('#itemName').html();
        let item = $('#item').html();
        let itemAmount = $('#itemAmount').val()
        let depositNumber = $('#depositNumber').val()
        let depositDate = $('#depositDate').val()
        let sequence = $('#sequence').val()
        let caseRemark = $('#caseRemark').val()
        let rejectRemark = $('#rejectRemark').val()
        let depositTitle = $('#depositTitle').val()
        let vat = $('#vat').val()
        let currency = $('#currency').val()
        let exchangeRate = $('#exchangeRate').val()
        let paymentTerm = $('#paymentTerm').val()
        let bankAccount = $('#bankAccount').val()
        let nonVat = $('#nonVat').val()
        let subtotalVat = $('#subtotalVat').val()
        let subtotalAmount = $('#subtotalAmount').val()
        let amount = $('#amount').val()
        let customer = ${caseDto.customer.customerId};
        let caseDto = ${caseDto.caseId};

        dto.itemName = itemName;
        dto.item = item;
        dto.itemAmount = itemAmount;
        deposit.depositNumber = depositNumber;
        deposit.depositTitle = depositTitle;
        deposit.depositDate = depositDate;
        deposit.sequence = sequence;
        deposit.caseRemark = caseRemark;
        deposit.rejectRemark = rejectRemark;
        deposit.vat = vat;
        deposit.currency = currency;
        deposit.exchangeRate = exchangeRate;
        deposit.paymentTerm = paymentTerm;
        deposit.bankAccount = bankAccount;
        deposit.nonVat = nonVat;
        deposit.subtotalVat = subtotalVat;
        deposit.subtotalAmount = subtotalAmount;
        deposit.amount = amount;
        deposit.customer = customer;
        deposit.caseDto = caseDto;
        const dtoList = [];
        dtoList[0] = dto;
        deposit.dtoList = dtoList
        const dataJson = JSON.stringify(deposit)
        console.log(dataJson)
        $.ajax({
            type: "post",
            contentType: "application/json",
            url: "${pageContext.request.contextPath}/invoice/addDeposit/",
            data: dataJson, // serializes form input
            success: function(data){
                openPage("${pageContext.request.contextPath}/case/list");
            }
        });
    });
</script>
