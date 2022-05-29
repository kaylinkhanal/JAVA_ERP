<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
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
              <button type="button" class="btn btn-secondary">00001</button>
              <button type="button" class="btn btn-secondary">John Doe</button>
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
                  <div class="col-md-8 d-flex align-items-center">
                    <label for="caseId">100001</label>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="title" class="col-form-label">Title</label>
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <label for="title">Booking Box</label>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="customer" class="col-form-label">Customer</label>
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <label for="customer">C205445010 (customer)</label>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="contact" class="col-form-label">Contact</label>
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <label for="contact">John Doe</label>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="description" class="col-form-label"
                      >Description</label
                    >
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <input type="text" class="form-control" id="description" />
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="status" class="col-form-label">Status</label>
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <input type="text" class="form-control" id="status" />
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="preBillingAmount" class="col-form-label"
                      >Pre Billing Amount</label
                    >
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <label for="preBillingAmount">100001</label>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <div class="form-group col-md-4">
                    <label for="openingDate" class="col-form-label"
                      >Opening Date</label
                    >
                  </div>
                  <div class="col-md-8 d-flex align-items-center">
                    <label for="openingDate">100001</label>
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
                    <label for="proposalDate">100001</label>
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
                    <label for="acceptanceDate">100001</label>
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
                    <label for="discardDate">100001</label>
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
                    <label for="closingDate">100001</label>
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
                    <label for="validationDate">100001</label>
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
                    <label for="suspenseDate">100001</label>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <button type="button" id="save" class="btn btn-primary float-right">
            Edit this case</button
          ><br /><br />
        </form>
      </div>
    </div>
  </body>
</html>
