<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- <%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%> -->
<!-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> -->
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
              <input
                type="text"
                disabled
                class="form-control"
                id="siteId"
                name="siteId"
              />
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-8">
              <label for="siteName">Site Name: </label>
              <input
                type="text"
                class="form-control"
                id="siteName"
                name="siteName"
              />
            </div>
            <div class="form-group col-md-4">
              <label for="siteType">Type: </label>
              <select id="siteType" name="siteType" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
              </select>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-8">
              <label for="address">Address: </label>
              <input
                type="text"
                class="form-control"
                id="addressNo"
                name="addressNo"
              />
            </div>
            <div class="form-group col-md-4">
              <label for="country">Country</label>
              <select id="country" name="country" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
              </select>
            </div>
          </div>

          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="phone1">Phone1: </label>
              <input
                type="text"
                class="form-control"
                id="phone1"
                name="phone1"
              />
            </div>
            <div class="form-group col-md-4">
              <label for="phone2">Phone2: </label>
              <input
                type="text"
                class="form-control"
                id="phone2"
                name="phone2"
              />
            </div>

            <div class="form-group col-md-4">
              <label for="fax">Fax: </label>
              <input type="text" class="form-control" id="fax" name="fax" />
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
          <c:forEach var="site" items="${pagedListHolder}">
            <tbody align="center">
              <tr>
                <td>${site.getSiteId()}</td>
                <td>${site.getSiteName()}</td>
                <td>${site.getPhone1()}</td>
                <td>${site.getAddress()}</td>
                <td>${site.getSiteName()}</td>
                <td>Enable</td>
                <td>
                  <i class="far fa-edit"></i>
                  <i class="far fa-trash-alt"></i>
                </td>
              </tr>
            </tbody>
          </c:forEach>
        </table>
        <c:if test="${!isFirst}">
          <a href="/company/site?page=${currentPage -1}">Previous</a>  
        </c:if>
        <c:forEach var="i" begin="0" end="${lastPageNo-1 }" >
          <a href="/company/site?page=${i }">${i+1 }</a>    	<!-- Displaying Page No -->
        </c:forEach>
        <c:if test="${!isLast}">
          <a href="/company/site?page=${currentPage +1}">Next</a>  
        </c:if>
      </div>
    </div>
  </body>
</html>
<script><%@include file="/WEB-INF/script/common.js" %></script>


