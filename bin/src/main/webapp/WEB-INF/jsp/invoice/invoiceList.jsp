<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>Invoice List</title>
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
      <h1>Invoice List</h1>
      <hr />
    </div>
    <div style="display: flex">
      <button onclick="openPage('/invoice/createInstallment?caseId=${caseId}')" class="btn btn-primary">Create Installment</button>
      <button onclick="openPage('/invoice/createDeposit?caseId=${caseId}')" class="btn btn-primary ml-2">Create Deposit</button>
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
        <c:forEach var="invoice" items="${invoiceList}">
          <tbody align="center">
          <tr>
            <td>${invoice.caseDto.caseId}</td>
            <td>${invoice.invoiceTitle}</td>
            <td>${invoice.caseDto.customer.fullName != null ? invoice.caseDto.customer.fullName : invoice.caseDto.customer.companyName}</td>
            <td>${invoice.re}</td>
            <td><fmt:formatDate pattern="dd-MM-yyyy" value = "${invoice.caseDto.operatingDate}"/></td>
            <td>
              <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Edit Invoice" data-placement="right">
                <i class="far fa-edit icon-button" onclick="openPage('/invoice/edit/${invoice.invoiceId}')"></i>
              </span>
              <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Delete Invoice" data-placement="right">
                <i class="far fa-trash-alt icon-button" onclick="deleteInvoice('/invoice/delete/${invoice.invoiceId}')"></i>
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
  </div>

</div>
</body>
<jsp:include page="/WEB-INF/jsp/templates/deleteModal.jsp">
  <jsp:param name="message" value="Delete this Invoice?"/>
</jsp:include>
</html>
<script type="text/javascript">
  function deleteInvoice(url) {
    $("#deleteModal").modal("show");
    $("#deleteButton").on('click', function() {
      openPage(url);
    })
  }
</script>
