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
          <h1>Personal Contact Information</h1>
          <hr />
        </div>
        <form method="post" action="addContactPerson">
          <input type="hidden" value="${customer.customerId}" name="customer" id="customer" />
          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="contactId">Contact Id: </label>
              <input type="hidden" class="form-control" id="contactId" name="contactId" value="${contact.contactId}" />
              <input type="text" disabled class="form-control" value="${contact.contactId}" />
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
                    <option selected value="">Choose...</option>
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
              <input type="text" class="form-control" id="relationship" name="relationship" required value="${contact.relationship}"/>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-12">
              <label for="description">Description: </label>
              <textArea type="text" row="3"  class="form-control" id="description" name="description" required>${contact.description}</textArea>
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
              <td>${contact.contactId}</td>
              <td>${contact.addressType}</td>
              <td>${contact.phone}</td>
              <td>${contact.relationship}</td>
              <td>${contact.email}</td>
              <td>Enable</td>
              <td>
                <i class="far fa-edit icon-button" onclick="openPage('/editContactPerson/${contact.contactId}')"></i>
                <i class="far fa-trash-alt icon-button" onclick="openPage('/deleteContactPerson/${contact.contactId}')"></i>
              </td>
            </tr>
            </tbody>
          </c:forEach>
        </table>
<%--        <jsp:include page="/WEB-INF/jsp/templates/page.jsp">--%>
<%--          <jsp:param name="page" value="${page}" />--%>
<%--        </jsp:include>--%>
        <jsp:include page="/WEB-INF/jsp/templates/page.jsp">
          <jsp:param name="page" value="${page}" />
        </jsp:include>
      </div>
    </div>
    <div id="saveModal" class="modal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <h2>Successfully</h2>
          <div class="modal-body">
            Thank you for your registration. Your Company ID is ${contact.contactId} Please
            process next step
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary">Next</button>
            <button
              type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
          </div>
        </div>
      </div>
    </div>

  </body>
</html>
<%--<script type="text/javascript">--%>
<%--  $(document).ready(function() {--%>
<%--    let customer = getStorage("customer");--%>
<%--  });--%>
<%--</script>--%>
