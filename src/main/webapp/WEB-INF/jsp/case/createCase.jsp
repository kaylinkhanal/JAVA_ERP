<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
              <button type="button" class="btn btn-secondary">${customer != null ? customer.code : caseDto.customer.code}</button>
              <button type="button" class="btn btn-secondary">${customer != null ? customer.firstName : caseDto.customer.firstName}</button>
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
              <button type="button" class="btn btn-secondary">${caseDto.caseId}</button>
            </h5>
          </div>
        </div>
        <br />
        <form class="col-xs-12 border p-3" method="post" action="addCase">
          <input type="hidden" name="customer" value="${customer != null ? customer.customerId : caseDto.customer.customerId}"/>
          <input type="hidden" name="caseId" value="${caseDto.caseId}" />
          <div class="form-row row">
            <div class="col-md-12">
              <div class="row">
                <div class="form-group col-md-10">
                  <div class="col-md-12 row">
                    <input type="button" value="Select" class="btn btn-primary col-sm-2" id="select" value="${caseDto.contact}" />
                    <label for="contact" class="col-sm-2 pl-5 col-form-label">Contact</label>
                    <input  type="text" class="form-control col-sm-8" id="contact" name="contact" value="${caseDto.contact}" required/>
                  </div>
                  <div class="col-md-12 row">
                    <label for="title">Title </label>
                    <input type="text" class="form-control" id="title" name="title" required value="${caseDto.title}"/>
                  </div>
                  <div class="col-md-12 row"><hr /></div>
                </div>
                <div class="col-md-2 d-flex align-items-center justify-content-end">
                  <button type="button" class="btn btn-primary float-right">Booking</button>
                </div>
              </div>
            </div>

            <div class="col-md-12">
              <div class="row">
                <div class="form-group col-md-3">
                  <label for="description">Description</label>
                  <textArea type="text"   rows="9" class="form-control" id="description" required name="description">${caseDto.description }</textArea>
                </div>
                <div class="col-md-9 d-flex justify-content-end row">
                  <div class="col-md-12 row">
                    <div class="col-md-4">
                      <label class="col-form-label" for="status">Status</label>
                      <select id="status" name="status" class="form-control" value="${caseDto.status }" required>
                        <c:choose>
                          <c:when test="${caseDto == null}">
                            <option selected value="">Choose...</option>
                          </c:when>
                          <c:otherwise>
                            <option selected value="${caseDto.status}">${caseDto.status}</option>
                          </c:otherwise>
                        </c:choose>
                        <option value="Opened">Opened</option>
                        <option value="Closed">Closed</option>
                        <option value="Suspended">Suspended</option>
                      </select>
                    </div>
                    <div class="col-md-4">
                      <label for="operatingDate" class="col-form-label">Operating Date</label>
                      <fmt:formatDate pattern="mm/dd/yyyy" value = "${caseDto.operatingDate}" var="operatingDate"/>
                      <input type="date" class="form-control" id="operatingDate" required name="operatingDate" pattern="mm/dd/yyyy" value = "${caseDto.operatingDate}"/>
                    </div>
                    <div class="col-md-4"></div>
                  </div>
                  <div class="col-md-12 row">
                    <div class="col-md-4">
                      <label for="proposalDate" class="col-form-label">Proposal Date</label>
                      <fmt:formatDate pattern="MM/dd/yyyy" value = "${caseDto.suspenseDate}" var="value"/>
                      <input type="date" class="form-control" id="proposalDate" name="proposalDate" value="07-07-2022" required />
                    </div>
                    <div class="col-md-4">
                      <label for="acceptanceDate" class="col-form-label">Acceptance Date</label>
                      <input type="date" class="form-control" id="acceptanceDate" name="acceptanceDate" value="${caseDto.acceptanceDate }" required/>
                    </div>
                    <div class="col-md-4">
                      <label for="validationDate" class="col-form-label">Validation Date</label>
                      <input type="date" class="form-control" id="validationDate" name="validationDate" value="${caseDto.validationDate }" required/>
                    </div>
                  </div>
                  <div class="col-md-12 row">
                    <div class="col-md-4">
                      <label for="discardDate" class="col-form-label">Discard Date</label>
                      <input type="date" class="form-control" id="discardDate" name="discardDate" value="${caseDto.discardDate }" required/>
                    </div>
                    <div class="col-md-4">
                      <label for="closingDate" class="col-form-label">Closing Date</label>
                      <input type="date" class="form-control" id="closingDate" name="closingDate" value="${caseDto.closingDate }" required/>
                    </div>
                    <div class="col-md-4"></div>
                  </div>
                  <div class="col-md-12 row">
                    <div class="col-md-4">
                      <label for="suspenseDate" class="col-form-label">Suspense Date</label>
                      <input type="date" class="form-control" id="suspenseDate"  name="suspenseDate" value="${caseDto.suspenseDate }" required />
                    </div>
                    <div class="col-md-8">
                      <label class="col-form-label" for="contactPerson">Contact Person</label>
                      <select id="contactPerson" name="contactPerson" class="form-control" required>
                        <c:choose>
                          <c:when test="${caseDto == null}">
                            <option selected value="">Choose...</option>
                          </c:when>
                          <c:otherwise>
                            <option selected value="${caseDto.contactPerson.contactPersonId}">${caseDto.contactPerson.contactName}</option>
                          </c:otherwise>
                        </c:choose>
                        <c:forEach var="person" items="${contactPersons }" >
                          <option value="${person.contactPersonId }">${person.contactName}</option>
                        </c:forEach>
                      </select>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <button type="submit" id="save" class="btn btn-primary">Save</button
          ><br /><br />
        </form>
      </div>
    </div>
  </body>
</html>
