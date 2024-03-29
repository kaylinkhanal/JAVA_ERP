<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Case List</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
    <style></style>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container-fluid mt-5">
        <div class="row">
          <div class="col-md-12">
            <h3 class="float-right">
              <span>Customer ID: </span>
              <button type="button" class="btn btn-secondary">${customer.code}</button>
              <button type="button" class="btn btn-secondary">${customer.companyName != null ? customer.companyName : ccustomer.fullName}</button>
            </h3>
          </div>
        </div>
        <div class="col-md-12 row">
          <h3 class="float-left">
            <span>CaseList: </span>
            <button type="button" class="btn btn-primary" onclick="openPage('/case/create')">Create New Case</button>
          </h3>
        </div>
        <form class="col-xs-12 border p-3">
        <div class="col-xs-12 row">
            <div class="col-md-2">
            <jsp:include page="/WEB-INF/jsp/templates/caseSidebar.jsp" />
          </div>
          <div class="form-row col-md-10">
            <div class="form-group col-md-3">
              <label for="searchKeyword">Search: </label>
              <input type="text" class="form-control" id="searchKeyword" />
            </div>
            <div class="form-group col-md-3">
              <br>
              <i class="fas fa-search" onclick="filterCase()"></i>
            </div>
            <div class="form-group col-md-3">
              <label for="filter">Filter</label>
              <select id="filter" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
              </select>
            </div>
            <div class="form-group col-md-3">
              <label for="newStatus">New Status</label>
              <select id="newStatus" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
              </select>
            </div>
            <div align="center" class="col-md-12">
              <table border="1" width="100%" class="table table-striped" id="caseTable">
                <thead align="center" class="bg-primary">
                  <tr>
                    <td>Case ID</td>
                    <td>Customer Code</td>
                    <td>Title</td>
                    <td>Customer Name</td>
                    <td>Contact Name</td>
                    <td>Pre Billing</td>
                    <td>Status</td>
                    <td></td>
                  </tr>
                </thead>
                <c:forEach var="caseDto" items="${page.objects}">
                  <tbody align="center">
                  <tr>
                    <td>${caseDto.caseId}</td>
                    <td>${caseDto.customer.code}</td>
                    <td>${caseDto.title}</td>
                    <td>${caseDto.customer.companyName != null ? caseDto.customer.companyName : caseDto.customer.fullName}</td>
                    <td>${caseDto.contactPerson.contactName}</td>
                    <td></td>
                    <td>${caseDto.status}</td>
                    <td>
                      <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Edit Case" data-placement="right">
                        <i class="far fa-edit icon-button" onclick="openPage('/case/editCase/${caseDto.caseId}')"></i>
                      </span>
                      <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Case Detail" data-placement="right">
                        <i class="far fa-file-alt icon-button" onclick="openPage('/case/detail/${caseDto.caseId}')"></i>
                      </span>
                      <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Delete Case" data-placement="right">
                       <i class="far fa-trash-alt icon-button" onclick="deleteCase('/case/deleteCase/${caseDto.caseId}')"></i>
                      </span>
<%--                      <i class="far fa-trash-alt icon-button" onclick="openPage('/case/deleteCase/${caseDto.caseId}')"></i>--%>
                      <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="End Case" data-placement="right">
                        <i style="font-size:15px" class="fa icon-button" onclick="openPage('/case/endCase/${caseDto.caseId}')">&#xf142;</i>
                      </span>
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
        </div>
        </form>
      </div>
    </div>
  </body>
  <jsp:include page="/WEB-INF/jsp/templates/deleteModal.jsp">
    <jsp:param name="message" value="Delete this Case?"/>
  </jsp:include>
</html>
<script type="text/javascript">
  function deleteCase(url) {
    $("#deleteModal").modal("show");
    $("#deleteButton").on('click', function() {
      openPage(url);
    })
  }
</script>

<script><%@include file="/WEB-INF/script/case.js" %></script>
