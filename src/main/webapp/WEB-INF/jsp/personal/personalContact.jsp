<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Register Page</title>
    <style>
      .modal-dialog {
        padding-top: 15%;
      }
    </style>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Contact Information</h1>
          <hr />
        </div>
        <form method="post" action="addContactPerson">
          <input type="hidden" value="${contact != null ? contact.customer.customerId : customer.customerId}" name="customer" id="customer" />
          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="contactPersonId">Contact Id: </label>
              <input type="hidden" class="form-control" id="contactPersonId" name="contactPersonId" value="${contact.contactPersonId}" />
              <input type="text" disabled class="form-control" value="${contact.contactPersonId}" />
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-8">
              <label for="contactName">Contact Name: </label>
              <input type="text" class="form-control" id="contactName" name="contactName" required value="${contact.contactName}"/>
            </div>
            <div class="form-group col-md-4">
              <label for="addressType">Address Type: </label>
              <select id="addressType" name="addressType" class="form-control"required value="${contact.addressType}">
                <c:choose>
                  <c:when test="${contact == null}">
                    <option value="">Choose...</option>
                  </c:when>
                  <c:otherwise>
                    <option selected value="${contact.addressType}">${contact.addressType}</option>
                  </c:otherwise>
                </c:choose>
                <option value="Home">Home</option>
                <option value="Office">Office</option>
              </select>
            </div>
          </div>

          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="phone">Phone: </label>
              <input type="text" class="form-control" id="phone" name="phone" required value="${contact.phone}"/>
            </div>
            <div class="form-group col-md-4">
              <label for="email">Email: </label>
              <input type="text" class="form-control" id="email" name="email" required value="${contact.email}"/>
            </div>

            <div class="form-group col-md-4">
              <label for="relationship">Relationship: </label>
              <input type="text" class="form-control" id="relationship" name="relationship" value="${contact.relationship}"/>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-12">
              <label for="description">Description: </label>
              <textArea type="text" row="3"  class="form-control" id="description" name="description">${contact.description}</textArea>
            </div>
          </div>
          <c:choose>
            <c:when test="${contact == null}">
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
              <td>Contact ID</td>
              <td>Address Type</td>
              <td>Phone</td>
              <td>Relationship</td>
              <td>Email</td>
              <td>Status</td>
              <td></td>
            </tr>
          </thead>

          <c:forEach var="contact" items="${page.getObjects()}">
            <tbody align="center">
            <tr>
              <td>${contact.contactPersonId}</td>
              <td>${contact.addressType}</td>
              <td>${contact.phone}</td>
              <td>${contact.relationship}</td>
              <td>${contact.email}</td>
              <td>Enable</td>
              <td>
                <i class="far fa-edit icon-button" onclick="openPage('/editContactPerson/${contact.contactPersonId}')"></i>
                <i class="far fa-trash-alt icon-button" onclick="openPage('/deleteContactPerson/${contact.contactPersonId}')"></i>
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
      <jsp:param name="message" value="Thank you for your registration. Your Personal ID is ${customer.customerId}." />
      <jsp:param name="url" value="/case/create"/>
    </jsp:include>
  </body>
</html>
<script type="text/javascript">
  <c:if test="${success == true}">
  $("#saveModal").modal("show");
  </c:if>
</script>
<%--<script type="text/javascript">--%>
<%--  $(document).ready(function() {--%>
<%--    let customer = getStorage("customer");--%>
<%--  });--%>
<%--</script>--%>
