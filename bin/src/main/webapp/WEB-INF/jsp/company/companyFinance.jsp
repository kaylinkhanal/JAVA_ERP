<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Company Finance Information</title>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Company Finance Information</h1>
          <hr />
        </div>

        <form METHOD="post" action="addCompanyFinance">
          <input type="hidden" id="customer" value="${companyFinance != null ? companyFinance.customer.customerId : customer.customerId}" name="customer" />
          <input type="hidden" id="financeId" value="${companyFinance.financeId}" name="financeId" />
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="averageLimit">Average Limit: </label>
              <input type="text"    class="form-control" id="averageLimit" name="averageLimit" value="${companyFinance.averageLimit}" required />
            </div>
            <div class="form-group col-md-6">
              <label for="paymentTerm">Payment Term</label>
              <select id="paymentTerm" name="paymentTerm" class="form-control" value="${companyFinance.paymentTerm}" required>
                <c:choose>
                  <c:when test="${companyFinance == null}">
                    <option selected value="">Choose...</option>
                  </c:when>
                  <c:otherwise>
                    <option selected value="${companyFinance.paymentTerm}">${companyFinance.paymentTerm}</option>
                  </c:otherwise>
                </c:choose>
                <option value="Term 1">Term 1</option>
                <option value="Term 2">Term 2</option>
              </select>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="bankName">Bank Name: </label>
              <input type="text" class="form-control" id="bankName" name="bankName" value="${companyFinance.bankName}" required/>
            </div>
            <div class="form-group col-md-6">
              <label for="accountNumber">Account Number: </label>
              <input type="text" class="form-control" id="accountNumber" name="accountNumber" value="${companyFinance.accountNumber}" required/>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="currency">Currency</label>
              <select id="currency" name="currency" class="form-control" value="${companyFinance.currency}" required>
                <c:choose>
                  <c:when test="${companyFinance == null}">
                    <option selected value="">Choose...</option>
                  </c:when>
                  <c:otherwise>
                    <option selected value="${companyFinance.currency.currencyId}">${companyFinance.currency.currencyName}</option>
                  </c:otherwise>
                </c:choose>

                <c:forEach var="currency" items="${currencies }" >
                  <option value="${currency.currencyId }">${currency.currencyName}</option>
                </c:forEach>
              </select>
            </div>
            <div class="form-group col-md-6">
              <label for="country">Country</label>
              <select id="country" name="country" class="form-control" value="${companyFinance.country}" required>
                <c:choose>
                  <c:when test="${companyFinance == null}">
                    <option selected value="">Choose...</option>
                  </c:when>
                  <c:otherwise>
                    <option selected value="${companyFinance.country.countryId}">${companyFinance.country.countryName}</option>
                  </c:otherwise>
                </c:choose>

                <c:forEach var="country" items="${countries }" >
                  <option value="${country.countryId }">${country.countryName}</option>
                </c:forEach>
              </select>
            </div>
          </div>

          <button type="submit" class="btn btn-primary">Save</button
          ><br /><br />
        </form>
      </div>
      <div align="center" class="container">
        <table border="1" width="60%" class="table table-striped">
          <thead align="center" class="bg-primary">
            <tr>
              <td>Payment Term</td>
              <td>Bank Name</td>
              <td>Account Number</td>
              <td>Currency</td>
              <td>Country</td>
              <td>Status</td>
              <td></td>
            </tr>
          </thead>

          <c:forEach var="finance" items="${page.getObjects()}">
            <tbody align="center">
            <tr>
              <td>${finance.paymentTerm}</td>
              <td>${finance.bankName}</td>
              <td>${finance.accountNumber}</td>
              <td>${finance.currency.currencyName}</td>
              <td>${finance.country.countryName}</td>
              <td>Enable</td>
              <td>
                <i class="far fa-edit icon-button" onclick="openPage('/company/editCompanyFinance/${finance.financeId}')"></i>
                <i class="far fa-trash-alt icon-button" onclick="openPage('/company/deleteCompanyFinance/${finance.financeId}')"></i>
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
    <jsp:include page="/WEB-INF/jsp/templates/basicModal.jsp">
      <jsp:param name="message" value="Thank you for your registration. Your Company ID is ${customer.customerId} Please
            process next step" />
      <jsp:param name="url" value="/case/create"/>
    </jsp:include>
  </body>
</html>
<script type="text/javascript">
  <c:if test="${success == true}">
  $("#saveModal").modal("show");
  </c:if>
</script>
