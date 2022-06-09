<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
         <form method="post" action="addCustomer">
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="customerId">Customer Id</label>
              <input type="text" disabled class="form-control" id="customerId" name="customerId" value="${customer.customerId}"/>
            </div>
            <div class="form-group col-md-6">
              <label for="registerDate">Register Date</label>
              <input type="date" class="form-control" id="registerDate" name="registerDate"required/>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="firstName">First Name</label>
              <input type="text" class="form-control" id="firstName" name="firstName" required/>
            </div>
            <div class="form-group col-md-6">
              <label for="lastName">Last Name</label>
              <input type="text" class="form-control" id="lastName" name="lastName" required/>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="gender">Gender</label>
              <select id="gender" class="form-control" name="gender" required>
                <option value="">Choose...</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
              </select>
            </div>
            <div class="form-group col-md-6">
              <label for="dob">DOB</label>
              <input type="date" class="form-control" id="dob" name="dateOfBirth" required/>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="passportNo">ID/Passport No:</label>
              <input type="text" class="form-control" id="passportNo" name="idPassportNo" required/>
            </div>
            <div class="form-group col-md-4">
              <label for="email">Email:</label>
              <input type="text" class="form-control" id="email" name="email" required/>
            </div>

            <div class="form-group col-md-4">
              <label for="contactNo">Contact No</label>
              <input type="text" class="form-control" id="contactNo" name="contactNo" required />
            </div>
          </div>
          <button type="submit" id="save" class="btn btn-primary">Save</button
          ><br /><br />
         <c:if test="${customer != null}">
           <input type="button" class="btn btn-primary" value="Add Address" name="personalAddress" onclick="nextPage()" />
           <input type="button" class="btn btn-primary" value="Add Contact Person" name="personalContact" onclick="openPage('personalContact')"/>
         </c:if>
         </form>
      </div>
    </div>
    <jsp:include page="/WEB-INF/jsp/templates/basicModal.jsp">
      <jsp:param name="message" value="Thank you for your registration. Your Personal ID is ${customer.customerId} Please
            process next step" />
      <jsp:param name="url" value="/personalAddress"/>
    </jsp:include>
  </body>
</html>
<script type="text/javascript">
  <c:if test="${success == true}">
    $("#saveModal").modal("show");
    setStorage('customer', JSON.stringify('${customer}'));
  </c:if>

  function nextPage() {
      setStorage('customer', JSON.stringify('${customer}'));
      openPage('personalAddress')
  }
</script>

