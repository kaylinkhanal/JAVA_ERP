<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Register Page</title>
  </head>
  <style>

  </style>
  <body>
    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Personal Information Entry</h1>
          <hr />
        </div>
         <form method="post" action="/addCustomer">
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="customerId">Customer Id</label>
              <input type="text" disabled class="form-control" id="customerId" name="customerId" value="${customer.customerId}"/>
              <input type="hidden" class="form-control"  name="customerId" value="${customer.customerId}"/>
              <input type="hidden" class="form-control"  name="type" value="Personal"/>
              <input type="hidden" class="form-control"  name="code" value="${customer.code}"/>
            </div>
            <div class="form-group col-md-6">
              <label for="registerDate">Register Date</label>
              <input type="date" class="form-control" id="registerDate" name="registerDate" required/>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="firstName">First Name</label>
              <input type="text" class="form-control" id="firstName" name="firstName" required value="${customer.firstName}"/>
            </div>
            <div class="form-group col-md-6">
              <label for="lastName">Last Name</label>
              <input type="text" class="form-control" id="lastName" name="lastName" required value="${customer.lastName}"/>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="gender">Gender</label>
              <select id="gender" class="form-control" name="gender" required value="${customer.gender}">
                <c:choose>
                  <c:when test="${customer == null}">
                    <option selected value="">Choose...</option>
                  </c:when>
                  <c:otherwise>
                    <option selected value="${customer.gender}">${customer.gender}</option>
                  </c:otherwise>
                </c:choose>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
              </select>
            </div>
            <div class="form-group col-md-6">
              <label for="dob">DOB</label>
              <input type="date" class="form-control" id="dob" name="dateOfBirth" required value="${customer.dateOfBirth}"/>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="passportNo">ID/Passport No:</label>
              <input type="text" class="form-control" id="passportNo" name="idPassportNo" required value="${customer.idPassportNo}"/>
            </div>
            <div class="form-group col-md-4">
              <label for="email">Email:</label>
              <input type="text" class="form-control" id="email" name="email" required value="${customer.email}"/>
            </div>

            <div class="form-group col-md-4">
              <label for="contactNo">Contact No</label>
              <input type="text" class="form-control" id="contactNo" name="contactNo" required value="${customer.contactNo}" />
            </div>
          </div>
          <button type="submit" id="save" class="btn btn-primary">Save</button
          ><br /><br />
         <input type="button" class="btn btn-primary" value="Add Address" name="personalAddress" onclick="openPage('personalAddress')" />
         <input type="button" class="btn btn-primary" value="Add Contact Person" name="personalContact" onclick="openPage('personalContact')"/>
         </form>
      </div>
    </div>
    <jsp:include page="/WEB-INF/jsp/templates/basicModal.jsp">
      <jsp:param name="message" value="Thank you for your registration. Your Personal ID is ${customer.customerId} Please
            process next step" />
      <jsp:param name="url" value="${customer.firstName != null ? 'personalAddress' : '/company/site'}" />
    </jsp:include>
  </body>
</html>
<script type="text/javascript">
  $(document).ready(function () {
    setDate('${customer.registerDate}', 'registerDate');
    setDate('${customer.dateOfBirth}', 'dob');
  });
  <c:if test="${success == true}">
    $("#saveModal").modal("show");
  </c:if>
</script>

