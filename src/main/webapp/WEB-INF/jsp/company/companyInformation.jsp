<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Company Information</title>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Company Information Entry</h1>
          <hr />
        </div>
        <form method="post" action="/addCustomer">
          <input type="hidden" class="form-control"  name="code" value="${customer.code}"/>
          <input type="hidden" class="form-control"  name="type" value="Company"/>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="customerId">Customer Id</label>
              <input type="text" disabled class="form-control" id="customerId" name="customerId" value="${customer.customerId}"/>
              <input type="hidden" class="form-control"  name="customerId" value="${customer.customerId}"/>
            </div>
            <div class="form-group col-md-6">
              <label for="registerDate">Register Date</label>
              <input type="date" required class="form-control" id="registerDate" name="registerDate" />
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="companyName">Company Name</label>
              <input type="text" class="form-control" id="companyName" name="companyName" required value="${customer.companyName}" />
            </div>
            <div class="form-group col-md-6">
              <label for="taxId">Tax Id</label>
              <input type="text" class="form-control" id="taxId" name="taxId" required value="${customer.taxId}"/>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="businessType">Business Type: </label>
              <select id="businessType" name="businessType" class="form-control" required value="${customer.businessType}">
                <c:choose>
                  <c:when test="${customer == null}">
                    <option selected value="">Choose...</option>
                  </c:when>
                  <c:otherwise>
                    <option selected value="${customer.businessType}">${customer.businessType}</option>
                  </c:otherwise>
                </c:choose>
                <option value="Type1">Type1</option>
                <option value="Type2">Type2</option>
              </select>
            </div>
            <div class="form-group col-md-6">
              <label for="website">Website</label>
              <input type="text" class="form-control" id="website" name="website" required value="${customer.website}" />
            </div>
          </div>
          <div class="form-row row">
            <div class="col-md-2">
              <label for="tradingRelation">Trading Relation: </label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="tradingRelation" id="tradingRelation" value="Customer" checked="${customer.tradingRelation == 'Customer' ? 'checked':''}">
              <label class="form-check-label" for="tradingRelation">Customer</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="tradingRelation" id="tradingRelation1" value="Agent" checked="${customer.tradingRelation == 'Agent' ? 'checked':''}">
              <label class="form-check-label" for="tradingRelation1">Agent</label>
            </div>
          </div>
          <button type="submit" class="btn btn-primary">Save</button
          ><br /><br />
          <button type="button" class="btn btn-primary" onclick="openPage('/company/site')">Add Site</button>
          <button type="button" class="btn btn-primary" onclick="openPage('/company/contactPerson')">Add Contact Person</button>
          <button type="button" class="btn btn-primary" onclick="openPage('/company/finance')">Add Finance Info</button>
        </form>
      </div>
    </div>
  </body>
  <jsp:include page="/WEB-INF/jsp/templates/basicModal.jsp">
    <jsp:param name="message" value="Thank you for your registration. Your Company ID is ${customer.customerId} Please
            process next step" />
    <jsp:param name="url" value="/company/site"/>
  </jsp:include>
</html>
<script type="text/javascript">
  $(document).ready(function () {
    setDate('${customer.registerDate}', 'registerDate');
  });
  <c:if test="${success == true}">
  $("#saveModal").modal("show");
  </c:if>
</script>
