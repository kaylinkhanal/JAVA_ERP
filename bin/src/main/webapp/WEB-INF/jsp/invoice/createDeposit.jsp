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
                            <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Edit Deposit" data-placement="right">
                                <i class="far fa-edit icon-button" onclick="openPage('/invoice/editDeposit/${deposit.depositId}')"></i>
                            </span>
                            <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Delete Deposit" data-placement="right">
                                <i class="far fa-trash-alt icon-button" onclick="deleteDeposit('/invoice/deleteDeposit/${deposit.depositId}')"></i>
                            </span>
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
                    <input type="text" disabled class="form-control" id="depositNumber" name="depositNumber" value="${deposit.depositNumber != null ? deposit.depositNumber : depositNumber}" />
                    <input type="hidden" name="depositNumber" value="${deposit.depositNumber != null ? deposit.depositNumber : depositNumber}" />
                </div>
                <div class="form-group col-md-4">
                    <label for="depositDate">Deposit Date: </label>
                    <input type="date" class="form-control" id="depositDate" name="depositDate" value="${deposit.depositDate}" />
                    <input type="hidden" name="depositDate" value="" />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="sequence">Sequence </label>
                    <input type="text" class="form-control" id="sequence" name="sequence" value="${deposit.sequence}" required />
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="caseRemark">Case Remark: </label>
                    <input type="text" class="form-control" id="caseRemark" name="caseRemark" value="${deposit.caseRemark}" required />
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="rejectRemark">Reject Remark: </label>
                    <input type="text" class="form-control" id="rejectRemark" name="rejectRemark" value="${deposit.rejectRemark}" required />
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="depositTitle">Deposit Title: </label>
                    <input type="text" class="form-control" id="depositTitle" name="depositTitle" value="${deposit.depositTitle}" required />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="vat">Vat: </label>
                    <input type="text" class="form-control" id="vat" name="vat" value="${deposit.vat}" required />
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
                    <input type="text" class="form-control" id="exchangeRate" name="exchangeRate" value="${deposit.exchangeRate}" required />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="paymentTerm">Payment Term: </label>
                    <input type="text" class="form-control" id="paymentTerm" name="paymentTerm" value="${deposit.paymentTerm}" required />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="bankAccount">Bank Account: </label>
                    <input type="text" class="form-control" id="bankAccount" name="bankAccount" value="${deposit.bankAccount}" required />
                </div>
            </div>
            <c:if test="${deposit.depositId == null}">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <input type="button" id="addItem" value="Add Item"/>
                    </div>
                </div>
            </c:if>
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
                        <input type="text" class="form-control" id="nonVat" name="nonVat" value="${deposit.nonVat}" />
                    </div>
                </div>
                <div class="form-group col-md-3">
                    <label for="currency">Vat </label>
                    <input type="text" class="form-control" id="subtotalVat" name="subtotalVat" value="${deposit.subtotalVat}" />
                </div>
                <div class="form-group col-md-3">
                    <label for="exchangeRate">Amount </label>
                    <input type="text" class="form-control" id="subtotalAmount" name="subtotalAmount" value="${deposit.subtotalAmount}" />
                </div>
                <div class="form-group col-md-6">
                </div>
                <div class="form-group col-md-6">
                    <label for="exchangeRate">Actual Amount </label>
                    <input type="text" class="form-control" id="amount" name="amount" value="${deposit.amount}" />
                </div>
            </div><br/>

            <c:if test="${depositDetail.size() > 0}">
                <c:forEach var="installmentItem" items="${depositDetail}">
                    <jsp:include page="/WEB-INF/jsp/templates/addItem.jsp">
                        <jsp:param name="detailId" value="${installmentItem.depositDetailId}" />
                        <jsp:param name="masterId" value="${installmentItem.deposit.depositId}" />
                        <jsp:param name="itemName" value="${installmentItem.item.itemName}" />
                        <jsp:param name="itemAmount" value="${installmentItem.itemAmount}" />
                        <jsp:param name="itemId" value="${installmentItem.item.itemId}" />
                        <jsp:param name="display" value="block" />
                    </jsp:include>
                </c:forEach>
            </c:if>
            <jsp:include page="/WEB-INF/jsp/templates/addItem.jsp">
                <jsp:param name="detailId" value="" />
                <jsp:param name="masterId" value="" />
                <jsp:param name="itemName" value="" />
                <jsp:param name="itemAmount" value="" />
                <jsp:param name="itemId" value="" />
                <jsp:param name="display" value="none" />
            </jsp:include>
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
<jsp:include page="/WEB-INF/jsp/templates/deleteModal.jsp">
    <jsp:param name="message" value="Delete this Deposit?"/>
</jsp:include>
</html>
<script type="text/javascript">
    function deleteDeposit(url) {
        $("#deleteModal").modal("show");
        $("#deleteButton").on('click', function() {
            openPage(url);
        })
    }
</script>

<script><%@include file="/WEB-INF/script/invoice.js" %></script>
<script>
    $(document).ready(function () {
        setDate('${deposit.depositDate}', 'depositDate');
    })
    $("#addDepositForm").submit(function(e) {
        e.preventDefault(); // prevent actual form submit
        let deposit = new Object();
        let dto = new Object();
        let depositDetailId = $('#detailId').val();
        let itemName = $('#itemName').html();
        let item = $('#item').html();
        let itemAmount = $('#itemAmount').val()
        let depositNumber = $('#depositNumber').val()
        let depositId = $('#masterId').val()
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
        dto.depositDetailId = depositDetailId
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
        deposit.depositId = depositId
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
            url: "${${pageContext.request.contextPath}/cb}/invoice/addDeposit/",
            data: dataJson, // serializes form input
            success: function(data){
                openPage("${${pageContext.request.contextPath}/cb}/case/list");
            }
        });
    });
</script>
