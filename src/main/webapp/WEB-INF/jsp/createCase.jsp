<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/base.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Create Case</title>
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
        <div class="col-xs-12 row">
          <div class="col-md-6 float-left">
            <span>Create new case </span>
          </div>
          <div class="col-md-6">
            <h5 class="float-right">
              <span>Case ID:</span>
              <button type="button" class="btn btn-secondary">10001</button>
            </h5>
          </div>
        </div>
        <br />
        <form class="col-xs-12 border p-3">
          <div class="form-row row">
            <div class="col-md-12">
              <div class="row">
                <div class="form-group col-md-10">
                  <div class="col-md-12 row">
                    <input
                      type="button"
                      value="Select"
                      class="btn btn-primary col-sm-2"
                      id="select"
                    />
                    <label for="contact" class="col-sm-2 pl-5 col-form-label"
                      >Contact</label
                    >
                    <input
                      type="text"
                      class="form-control col-sm-8"
                      id="contact"
                    />
                  </div>
                  <div class="col-md-12 row">
                    <label for="search">Title </label>
                    <input type="text" class="form-control" id="search" />
                  </div>
                  <div class="col-md-12 row"><hr /></div>
                </div>
                <div
                  class="col-md-2 d-flex align-items-center justify-content-end"
                >
                  <button type="button" class="btn btn-primary float-right">
                    Booking
                  </button>
                </div>
              </div>
            </div>

            <div class="col-md-12">
              <div class="row">
                <div class="form-group col-md-3">
                  <label for="description">Description</label>
                  <textArea
                    type="text"
                    rows="9"
                    class="form-control"
                    id="description"
                  ></textArea>
                </div>
                <div class="col-md-9 d-flex justify-content-end row">
                  <div class="col-md-12 row">
                    <div class="col-md-4">
                      <label class="col-form-label" for="status">Status</label>
                      <select id="status" class="form-control">
                        <option selected>Choose...</option>
                        <option>...</option>
                      </select>
                    </div>
                    <div class="col-md-4">
                      <label for="operatingDate" class="col-form-label"
                        >Operating Date</label
                      >
                      <input
                        type="text"
                        class="form-control"
                        id="operatingDate"
                      />
                    </div>
                    <div class="col-md-4"></div>
                  </div>
                  <div class="col-md-12 row">
                    <div class="col-md-4">
                      <label for="proposalDate" class="col-form-label"
                        >Proposal Date</label
                      >
                      <input
                        type="text"
                        class="form-control"
                        id="proposalDate"
                      />
                    </div>
                    <div class="col-md-4">
                      <label for="acceptanceDate" class="col-form-label"
                        >Acceptance Date</label
                      >
                      <input
                        type="text"
                        class="form-control"
                        id="acceptanceDate"
                      />
                    </div>
                    <div class="col-md-4">
                      <label for="validationDate" class="col-form-label"
                        >Validation Date</label
                      >
                      <input
                        type="text"
                        class="form-control"
                        id="validationDate"
                      />
                    </div>
                  </div>
                  <div class="col-md-12 row">
                    <div class="col-md-4">
                      <label for="discardDate" class="col-form-label"
                        >Discard Date</label
                      >
                      <input
                        type="text"
                        class="form-control"
                        id="discardDate"
                      />
                    </div>
                    <div class="col-md-4">
                      <label for="closingDate" class="col-form-label"
                        >Closing Date</label
                      >
                      <input
                        type="text"
                        class="form-control"
                        id="closingDate"
                      />
                    </div>
                    <div class="col-md-4"></div>
                  </div>
                  <div class="col-md-12 row">
                    <div class="col-md-4">
                      <label for="suspenseDate" class="col-form-label"
                        >Suspense Date</label
                      >
                      <input type="text" class="form-control" id="contact" />
                    </div>
                    <div class="col-md-8">
                      <label class="col-form-label" for="filter"
                        >Contact Person</label
                      >
                      <select id="contactPerson" class="form-control">
                        <option selected>Choose...</option>
                        <option>...</option>
                      </select>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <button type="button" id="save" class="btn btn-primary">Save</button
          ><br /><br />
        </form>
      </div>
    </div>
  </body>
</html>
