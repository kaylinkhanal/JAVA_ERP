<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
        <c:forEach var="installment" items="${page.getObjects()}">
          <tbody align="center">
          <tr>
            <td>${installment.caseDto.caseId}</td>
            <td>${installment.installmentTitle}</td>
            <td>${installment.customer.fullName != null ? installment.customer.fullName: installment.customer.companyName}</td>
            <td>${installment.customer.contactNo}</td>
            <td><fmt:formatDate pattern="dd-MM-yyyy" value = "${installment.caseDto.operatingDate}"/></td>
            <td>
              <i class="far fa-edit icon-button" onclick="openPage('/invoice/editInstallment/${installment.installmentId}')"></i>
              <i class="far fa-trash-alt icon-button" onclick="openPage('/invoice/deleteInstallment/${installment.installmentId}')"></i>
            </td>
          </tr>
          </tbody>
        </c:forEach>
      </table>
      <jsp:include page="/WEB-INF/jsp/templates/page.jsp">
        <jsp:param name="page" value="${page}" />
      </jsp:include>
    </div>
    <form method="post" id="addInstallmentForm" action="/invoice/addInstallment">
      <input type="hidden" value="${installment.installmentId}" name="installmentId" id="installmentId" />
      <input type="hidden" value="${caseDto.caseId}" name="caseDto" id="caseDto" />
      <input type="hidden" value="${caseDto.customer.customerId}" name="customer" id="customer" />
      <div class="form-row">
        <div class="form-group col-md-8">
          <label for="installmentNumber">Installment Number: </label>
          <input type="text" disabled class="form-control" id="installmentNumber" name="installmentNumber" value="${installment.installmentNumber != null ? installment.installmentNumber : installmentNumber}" />
          <input type="hidden" name="installmentNumber" value="${installment.installmentNumber != null ? installment.installmentNumber : installmentNumber}" />
        </div>
        <div class="form-group col-md-4">
          <label for="installmentDate">Installment Date: </label>
          <input type="date" class="form-control" id="installmentDate" required name="installmentDate" value="${installment.installmentDate}" />
          <input type="hidden" name="installmentDate" value="" />
        </div>
      </div>
      <div class="form-row">
        <div class="form-group col-md-12">
          <label for="sequence">Sequence </label>
          <input type="text" class="form-control" id="sequence" name="sequence" value="${installment.sequence}" required />
        </div>
      </div>

      <div class="form-row">
        <div class="form-group col-md-12">
          <label for="caseRemark">Case Remark: </label>
          <input type="text" class="form-control" id="caseRemark" name="caseRemark" value="${installment.caseRemark}" required />
        </div>
      </div>

      <div class="form-row">
        <div class="form-group col-md-12">
          <label for="rejectRemark">Reject Remark: </label>
          <input type="text" class="form-control" id="rejectRemark" name="rejectRemark" value="${installment.rejectRemark}" required />
        </div>
      </div>

      <div class="form-row">
        <div class="form-group col-md-12">
          <label for="installmentTitle">Installment Title: </label>
          <input type="text" class="form-control" id="installmentTitle" name="installmentTitle" value="${installment.installmentTitle}" required />
        </div>
      </div>
      <div class="form-row">
        <div class="form-group col-md-4">
          <label for="vat">Vat: </label>
          <input type="text" class="form-control" id="vat" name="vat" value="${installment.vat}" required />
        </div>
        <div class="form-group col-md-4">
          <label for="currency">Currency: </label>
          <select id="currency" name="currency" class="form-control" value="${installment.currency}" required>
            <c:choose>
              <c:when test="${installment == null}">
                <option selected value="">Choose...</option>
              </c:when>
              <c:otherwise>
                <option selected value="${installment.currency.currencyId}">${installment.currency.currencyName}</option>
              </c:otherwise>
            </c:choose>

            <c:forEach var="currency" items="${currencies }" >
              <option value="${currency.currencyId }">${currency.currencyName}</option>
            </c:forEach>
          </select>
        </div>
        <div class="form-group col-md-4">
          <label for="exchangeRate">Exchange Rate: </label>
          <input type="text" class="form-control" id="exchangeRate" name="exchangeRate" value="${installment.exchangeRate}" required />
        </div>
      </div>
      <div class="form-row">
        <div class="form-group col-md-12">
          <label for="paymentTerm">Payment Term: </label>
          <input type="text" class="form-control" id="paymentTerm" name="paymentTerm" value="${installment.paymentTerm}" required />
        </div>
      </div>
      <div class="form-row">
        <div class="form-group col-md-12">
          <label for="bankAccount">Bank Account: </label>
          <input type="text" class="form-control" id="bankAccount" name="bankAccount" value="${installment.bankAccount}" required />
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
            <input type="text" class="form-control" id="nonVat" name="nonVat" value="${installment.nonVat}" />
          </div>
        </div>
        <div class="form-group col-md-3">
          <label for="currency">Vat </label>
          <input type="text" class="form-control" id="subtotalVat" name="subtotalVat" value="${installment.subtotalVat}" />
        </div>
        <div class="form-group col-md-3">
          <label for="exchangeRate">Amount </label>
          <input type="text" class="form-control" id="subtotalAmount" name="subtotalAmount" value="${installment.subtotalAmount}" />
        </div>
        <div class="form-group col-md-6">
        </div>
        <div class="form-group col-md-6">
          <label for="exchangeRate">Actual Amount </label>
          <input type="text" class="form-control" id="amount" name="amount" value="${installment.amount}" />
        </div>
      </div><br/>
<%--      <div class="form-row" id="item" style="display: none; background: darkgray">--%>
<%--        <div class="form-group col-md-12">--%>
<%--          <br/>--%>
<%--          <label for="vat" id="itemName" class="col-md-4"></label>--%>
<%--          <label class="col-md-2">Amount</label>--%>
<%--          <input class="col-md-5" type="text" placeholder="0.00">--%>
<%--          <hr/>--%>
<%--        </div>--%>
<%--      <div class="form-row" id="itemDiv" style="display: none; background: darkgray">--%>
<%--        <div class="form-group col-md-12">--%>
<%--          <br/>--%>
<%--          <label id="item" name="item" class="col-md-1">${installment.paymentTerm}</label>--%>
<%--          <label id="itemName" name="itemName" class="col-md-3"></label>--%>
<%--          <label class="col-md-2">Amount</label>--%>
<%--          <input class="col-md-5" type="text" name="itemAmount" id="itemAmount"  value="${installment.paymentTerm}">--%>
<%--          <button type="button" class="itemClose" id="itemClose">--%>
<%--            <span aria-hidden="true">&times;</span>--%>
<%--          </button>--%>
<%--          <hr/>--%>
<%--        </div>--%>
<%--      </div>--%>
      <c:if test="${installmentDetail.size() > 0}">
        <c:forEach var="installmentItem" items="${installmentDetail}">
          <jsp:include page="/WEB-INF/jsp/templates/addItem.jsp">
            <jsp:param name="detailId" value="${installmentItem.installmentDetailId}" />
            <jsp:param name="masterId" value="${installmentItem.installment.installmentId}" />
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
</html>
<script>
  $(document).ready(function () {
    setDate('${installment.installmentDate}', 'installmentDate');
  })
</script>
<script>
  $("#addInstallmentForm").submit(function(e) {
    e.preventDefault(); // prevent actual form submit
    // var form = $(this);
    // var url = form.attr('action'); //get submit url [replace url here if desired]
    let installment = new Object();
    let dto = new Object();
    let installmentId = $('#masterId').val();
    let installmentDetailId = $('#detailId').val();
    let itemName = $('#itemName').html();
    let item = $('#item').html();
    let itemAmount = $('#itemAmount').val()
    let installmentNumber = $('#installmentNumber').val()
    let installmentDate = $('#installmentDate').val()
    let sequence = $('#sequence').val()
    let caseRemark = $('#caseRemark').val()
    let rejectRemark = $('#rejectRemark').val()
    let installmentTitle = $('#installmentTitle').val()
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
    dto.installmentDetailId = installmentDetailId;
    installment.installmentNumber = installmentNumber;
    installment.installmentTitle = installmentTitle;
    installment.installmentDate = installmentDate;
    installment.sequence = sequence;
    installment.caseRemark = caseRemark;
    installment.rejectRemark = rejectRemark;
    installment.vat = vat;
    installment.currency = currency;
    installment.exchangeRate = exchangeRate;
    installment.paymentTerm = paymentTerm;
    installment.bankAccount = bankAccount;
    installment.nonVat = nonVat;
    installment.subtotalVat = subtotalVat;
    installment.subtotalAmount = subtotalAmount;
    installment.amount = amount;
    installment.customer = customer;
    installment.caseDto = caseDto;
    installment.installmentId = installmentId;
    const dtoList = [];
    dtoList[0] = dto;
    installment.dtoList = dtoList
    const dataJson = JSON.stringify(installment)
    console.log(dataJson)
    $.ajax({
      type: "post",
      contentType: "application/json",
      url: "${pageContext.request.contextPath}/invoice/addInstallment/",
      data: dataJson, // serializes form input
      success: function(data){
        console.log(data);
        openPage("${pageContext.request.contextPath}/case/list");
      }
    });
  });
</script>
<script><%@include file="/WEB-INF/script/invoice.js" %></script>
