<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Register Page</title>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Personal Address Information</h1>
          <hr />
        </div>

        <form method="post" action="/addAddress">
          <input type="hidden" value="${customer.customerId}" name="customer" id="customer" />
          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="addressId">Address Id: </label>
              <input type="text" disabled class="form-control" id="addressId" name="addressId" value="${address.addressId}" />
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="addressType">Address Type: </label>
              <select id="addressType" name="addressType" class="form-control" value="${address.addressType}" required>
                <c:choose>
                  <c:when test="${address == null}">
                    <option selected value="">Choose...</option>
                  </c:when>
                  <c:otherwise>
                    <option selected value="${address.addressType}">${address.addressType}</option>
                  </c:otherwise>
                </c:choose>
                <option value="Home">Home</option>
                <option value="Office">Office</option>
              </select>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-8">
              <label for="addressNo">Address No: </label>
              <input type="text" class="form-control" id="addressNo" name="addressNo" value="${address.addressNo}" required />
            </div>
            <div class="form-group col-md-4">
              <label for="country">Country</label>
              <select id="country"  name="country" class="form-control" required/>
                <c:choose>
                  <c:when test="${address == null}">
                    <option selected value="">Choose...</option>
                  </c:when>
                  <c:otherwise>
                    <option selected value="${address.country.countryId}">${address.country.countryName}</option>
                  </c:otherwise>
                </c:choose>

                <c:forEach var="country" items="${countries }" >
                  <option value="${country.countryId }">${country.countryName}</option>
                </c:forEach>
              </select>
            </div>
          </div>

          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="phone1">Phone1: </label>
              <input type="text" class="form-control" id="phone1" name="phone1" value="${address.phone1}" required />
            </div>
            <div class="form-group col-md-4">
              <label for="phone2">Phone2: </label>
              <input type="text" class="form-control" id="phone2" name="phone2" value="${address.phone2}" required />
            </div>

            <div class="form-group col-md-4">
              <label for="fax">Fax: </label>
              <input type="text" class="form-control" id="fax" name="fax" value="${address.fax}" required/>
            </div>
          </div>
          <c:choose>
            <c:when test="${address == null}">
              <input type="submit" class="btn btn-primary" value="Save">
            </c:when>
            <c:otherwise>
              <input type="submit" class="btn btn-primary" value="Update">
            </c:otherwise>
          </c:choose>
          <br /><br />
        </form>
      </div>
      <div align="center" class="container">
        <table border="1" width="60%" class="table table-striped">
          <thead align="center" class="bg-primary">
            <tr>
              <td>Adress ID</td>
              <td>Address Type</td>
              <td>Phone</td>
              <td>Country</td>
              <td>Status</td>
              <td></td>
            </tr>
          </thead>
           <c:forEach var="address" items="${addresses}">
            <tbody align="center">
              <tr>
                <td>${address.addressId}</td>
                <td>${address.addressType}</td>
                <td>${address.phone1}</td>
                <td>${address.country.countryName}</td>
                <td>Enable</td>
                <td>
                  <i class="far fa-edit icon-button" onclick="openPage('/editAddress/${address.addressId}')"></i>
                  <i class="far fa-trash-alt icon-button" onclick="openPage('/deleteAddress/${address.addressId}')"></i>
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
      <jsp:param name="message" value="Thank you for your registration. Your Personal ID is ${customer.customerId} Please
            process next step" />
      <jsp:param name="url" value="/personalContact?customerId=${customer.customerId}"/>
    </jsp:include>
  </body>
</html>
<script type="text/javascript">
  <c:if test="${address != null}">
  $("#saveModal").modal("show");
  </c:if>
</script>
<script><%@include file="/WEB-INF/script/common.js" %></script>
