<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Case Detail</title>
    <style></style>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container mt-5">
        <div class="row">
         
          <div class="col-md-12">
            <h5 class="float-right">
              <span>Customer ID: </span>
<%--              <button type="button" class="btn btn-secondary">${caseDto.customer.code}</button>--%>
<%--              <button type="button" class="btn btn-secondary">${caseDto.customer.companyName != null ? caseDto.customer.companyName : caseDto.customer.fullName}</button>--%>
            </h5>
          </div>
        </div>
        <form class="col-xs-12 border p-3">
          <div class="col-xs-12 row">
            <div class="col-md-6 float-left">
              <span>View Single Case </span>
            </div>
          </div>
          <br />
          <div class="col-xs-12 row">
            <div class="col-md-2">
              <jsp:include page="/WEB-INF/jsp/templates/caseSidebar.jsp" />
            </div>
            <div class="form-row row col-md-10">
              <div class="col-md-12 bg-primary">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="caseDetail" class="col-form-label text-white"
                      >Case Details</label
                    >
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <label for="caseDetail"></label>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="caseId" class="col-form-label">Case ID</label>
                  </div>
                  <div class="col-md-4 d-flex align-items-center">
                    <label for="caseId">${caseDto.caseId}</label>
                  </div>
                  <div class="col-md-4 d-flex align-items-center">
                    <select id="document" name="document" class="form-control" required>
                      <c:forEach var="template" items="${templates }" >
                        <option selected value="">Choose...</option>
                        <option value="${template.documentId }">${template.documentName}</option>
                      </c:forEach>
                    </select>

                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="title" class="col-form-label">Title</label>
                  </div>
                  <div class="col-md-4 d-flex align-items-center">
                    <label for="title">${caseDto.title}</label>
                  </div>
                  <div class="form-group col-md-4">
                    <input type="button" onclick="caseDocumentPreview(${caseDto.caseId});" class="btn btn-primary" value="Print">
                  </div>
<%--                  <div class="form-group col-md-4">--%>
<%--                    <button onclick="caseDocumentPreview(${caseDto.caseId})" class="btn btn-primary">Print</button>--%>
<%--                  </div>--%>
                </div>

              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="customer" class="col-form-label">Customer</label>
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
<%--                    <label for="customer">${caseDto.customer.code} (customer)</label>--%>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="contact" class="col-form-label">Contact</label>
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
<%--                    <label for="contact">${caseDto.customer.fullName}</label>--%>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="description" class="col-form-label">Description</label>
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <input type="text" class="form-control" id="description" value="${caseDto.description}"/>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="status" class="col-form-label">Status</label>
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <input type="text" class="form-control" id="status" value="${caseDto.status}"/>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="preBillingAmount" class="col-form-label">Pre Billing Amount</label>
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <label for="preBillingAmount"></label>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="openingDate" class="col-form-label">Opening Date</label
                    >
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <label for="openingDate"><fmt:formatDate pattern="dd-MM-yyyy" value = "${caseDto.operatingDate}"/></label>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="proposalDate" class="col-form-label"
                      >Proposal Date</label
                    >
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <label for="proposalDate"><fmt:formatDate pattern="dd-MM-yyyy" value = "${caseDto.proposalDate}"/></label>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="acceptanceDate" class="col-form-label"
                      >Acceptance Date</label
                    >
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <label for="acceptanceDate"><fmt:formatDate pattern="dd-MM-yyyy" value = "${caseDto.acceptanceDate}"/></label>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="discardDate" class="col-form-label"
                      >Discard Date</label
                    >
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <label for="discardDate"><fmt:formatDate pattern="dd-MM-yyyy" value = "${caseDto.discardDate}"/></label>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="closingDate" class="col-form-label"
                      >Closing Date</label
                    >
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <label for="closingDate"><fmt:formatDate pattern="dd-MM-yyyy" value = "${caseDto.closingDate}"/></label>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="validationDate" class="col-form-label"
                      >Validation Date</label
                    >
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <label for="validationDate"><fmt:formatDate pattern="dd-MM-yyyy" value = "${caseDto.validationDate}"/></label>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="suspenseDate" class="col-form-label"
                      >Suspense Date</label
                    >
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <label for="suspenseDate"><fmt:formatDate pattern="dd-MM-yyyy" value = "${caseDto.suspenseDate}"/></label>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="col-md-2 form-group">
                    <button type="button" id="editCase" class="btn btn-primary" onclick="openPage('/case/editCase/${caseDto.caseId}')">Edit this case</button>
                  </div>
                  <div class="col-md-2 form-group">
                    <button type="button" id="createInvoice" class="btn btn-primary" onclick="openPage('/invoice/create?caseId=${caseDto.caseId}')">Create Invoice</button>
                  </div>
                  <div class="col-md-2 form-group">
                    <button type="button" id="invoiceList" class="btn btn-primary" onclick="openPage('/invoice/list?caseId=${caseDto.caseId}')">Invoice List</button>
                  </div>
<%--                  <div class="col-md-2 form-group">--%>
<%--                    <button type="button" id="attachDocument" class="btn btn-primary" onclick="openPage('/document/attachDocument?caseId=${caseDto.caseId}')">Attach Document</button>--%>
<%--                  </div>--%>
                </div>
              </div>

            </div>
          </div>
          <br /><br />
        </form>
      </div>
    </div>
  </body>
</html>
<script><%@include file="/WEB-INF/script/documentPreview.js" %></script>
