<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Company Site</title>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
          <h1>Company Site Information</h1>
          <hr />
        </div>

        <form method="post" action="addSite">
          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="siteId">Site Id: </label>
              <input type="text" disabled class="form-control" id="siteId" name="siteId" value="${site.siteId}"/>
              <input type="hidden" class="form-control" name="siteId" value="${site.siteId}"/>
              <input type="hidden" class="form-control" name="customer" value="${site != null ? site.customer.customerId : customer.customerId}"/>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-8">
              <label for="siteName">Site Name: </label>
              <input type="text" class="form-control" id="siteName" name="siteName" value="${site.siteName}" required/>
            </div>
            <div class="form-group col-md-4">
              <label for="siteType">Type: </label>
              <select id="siteType" name="siteType" class="form-control" required>
                <c:choose>
                  <c:when test="${site == null}">
                    <option selected value="">Choose...</option>
                  </c:when>
                  <c:otherwise>
                    <option selected value="${site.siteType}">${site.siteType}</option>
                  </c:otherwise>
                </c:choose>
                <option value="Type 1">Type 1</option>
                <option value="Type 2">Type 2</option>
              </select>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-8">
              <label for="address">Address: </label>
              <input type="text" class="form-control" id="address" name="address" value="${site.address}" required/>
            </div>
            <div class="form-group col-md-4">
              <label for="country">Country</label>
              <select id="country" name="country" class="form-control" value="${site.country.countryName}" required>
                <c:choose>
                  <c:when test="${site == null}">
                    <option selected value="">Choose...</option>
                  </c:when>
                  <c:otherwise>
                    <option selected value="${site.country.countryId}">${site.country.countryName}</option>
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
              <input type="text" class="form-control" id="phone1" name="phone1" value="${site.phone1}" required />
            </div>
            <div class="form-group col-md-4">
              <label for="phone2">Phone2: </label>
              <input type="text" class="form-control" id="phone2" name="phone2" value="${site.phone2}" />
            </div>

            <div class="form-group col-md-4">
              <label for="fax">Fax: </label>
              <input type="text" class="form-control" id="fax" name="fax" value="${site.fax}"/>
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
              <td>Site ID</td>
              <td>Site Name</td>
              <td>Phone</td>
              <td>Address</td>
              <td>Type</td>
              <td>Status</td>
              <td></td>
            </tr>
          </thead>
          <c:forEach var="site" items="${page.objects}">
            <tbody align="center">
              <tr>
                <td>${site.getSiteId()}</td>
                <td>${site.getSiteName()}</td>
                <td>${site.getPhone1()}</td>
                <td>${site.getAddress()}</td>
                <td>${site.getSiteName()}</td>
                <td>Enable</td>
                <td>
                  <i class="far fa-edit icon-button" onclick="openPage('/company/editSite/${site.siteId}')"></i>
                  <i class="far fa-trash-alt icon-button" onclick="openPage('/company/deleteSite/${site.siteId}')"></i>
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
      <jsp:param name="message" value="Thank you for your registration. Your Company ID is ${site != null ? site.customer.customerId : customer.customerId} Please
            process next step" />
      <jsp:param name="url" value="/personalContact"/>
    </jsp:include>
  </body>
</html>
<script type="text/javascript">
  <c:if test="${success == true}">
  $("#saveModal").modal("show");
  </c:if>
</script>


