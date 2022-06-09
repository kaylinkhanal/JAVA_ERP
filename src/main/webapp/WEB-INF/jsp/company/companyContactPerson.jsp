<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Company Contact Person Information</title>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Company Contact Person Information</h1>
          <hr />
        </div>

        <form method="post" action="addCompanyContactPerson">
          <input type="hidden" id="companyId" value="${contact.company.companyId}" name="companyId" />
          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="contactPersonId">Contact Id: </label>
              <input type="text" disabled class="form-control" id="contactPersonId" name="contactPersonId" value="${contact.contactPersonId}" />
              <input type="hidden" class="form-control"  name="contactPersonId" value="${contact.contactPersonId}" />
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="contactName">Contact Name: </label>
              <input type="text" class="form-control" id="contactName" name="contactName" value="${contact.contactName}" />
            </div>
            <div class="form-group col-md-4">
              <label for="dep">Dep: </label>
              <input type="text" class="form-control" id="dep" name="dep" value="${contact.dep}"/>
            </div>
            <div class="form-group col-md-4">
              <label for="title">Title: </label>
              <input type="text" class="form-control" id="title" name="title" value="${contact.title}" />
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="phone">Phone: </label>
              <input type="text" class="form-control" id="phone" name="phone" value="${contact.phone}" />
            </div>
            <div class="form-group col-md-4">
              <label for="email">Email: </label>
              <input type="text" class="form-control" id="email" name="email" value="${contact.email}" />
            </div>

            <div class="form-group col-md-4">
              <label for="site">Site</label>
              <select id="site" name="site" class="form-control" value="${contact.site.siteName}">
               <c:choose>
                  <c:when test="${contactPerson == null}">
                    <option selected value="">Choose...</option>
                  </c:when>
                  <c:otherwise>
                    <option selected value="${contactPerson.site.siteId}">${contactPerson.site.siteName}</option>
                  </c:otherwise>
                </c:choose>

                <c:forEach var="site" items="${sites }" >
                  <option value="${site.siteId }">${site.siteName}</option>
                </c:forEach>
              </select>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-12">
              <label for="description">Description: </label>
              <textArea type="text" row="3" class="form-control" id="description" name="description">${contact.description}</textArea>
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
              <td>Contact ID</td>
              <td>Contact Name</td>
              <td>Phone</td>
              <td>Email</td>
              <td>Site</td>
              <td>Status</td>
              <td></td>
            </tr>
          </thead>

          <c:forEach var="contact" items="${page.getObjects()}">
            <tbody align="center">
            <tr>
              <td>${contact.contactPersonId}</td>
              <td>${contact.contactName}</td>
              <td>${contact.phone}</td>
              <td>${contact.email}</td>
              <td>${contact.site.siteName}</td>
              <td>Enable</td>
              <td>
                <i class="far fa-edit icon-button" onclick="openPage('/company/editContactPerson/${contact.contactPersonId}')"></i>
                <i class="far fa-trash-alt icon-button" onclick="openPage('/company/deleteContactPerson/${contact.contactPersonId}')"></i>
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
      <jsp:param name="message" value="Thank you for your registration. Your Company ID is ${company.companyId} Please
            process next step" />
      <jsp:param name="url" value="/company/information"/>
    </jsp:include>
  </body>
</html>
<script type="text/javascript">
  <c:if test="${success == true}">
  $("#saveModal").modal("show");
  </c:if>
</script>
