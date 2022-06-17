<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Create Case</title>
    <style>
      .searchInput {
        margin: 10px;
      }
    </style>
  </head>
  <body>
    <div class="container-wrapper">
      <div class="container mt-5">
        <div class="row">
          <div class="col-md-12">
            <h5 class="float-right">
              <span>Customer ID: </span>
              <button type="button" id="code" class="btn btn-secondary">${customer != null ? customer.code : caseDto.customer.code}</button>
              <button type="button" id="firstName" class="btn btn-secondary">${customer != null ? customer.firstName : caseDto.customer.firstName}</button>
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
          <input type="hidden" name="customer" value="${caseDto != null ? caseDto.customer.customerId : customer.customerId}"/>
          <input type="hidden" name="caseId" value="${caseDto.caseId}" />
          <div class="form-row row">
            <div class="col-md-12">
              <div class="row">
                <div class="form-group col-md-10">
                  <div class="col-md-12 row">
                    <input type="button" value="Select" class="btn btn-primary col-sm-2" id="select" />
                    <label for="customer" class="col-sm-2 pl-5 col-form-label" id="currentCustomer">Customer</label>
                    <input  type="text" class="form-control col-sm-8" id="customer" name="customer" value="${caseDto.customer.firstName}" required/>
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
                      <input type="date" class="form-control" id="operatingDate" required name="operatingDate" pattern="mm/dd/yyyy" value = "${caseDto.operatingDate}"/>
                    </div>
                    <div class="col-md-4"></div>
                  </div>
                  <div class="col-md-12 row">
                    <div class="col-md-4">
                      <label for="proposalDate" class="col-form-label">Proposal Date</label>
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
<div id="searchModal" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Search Customers</h5>
        <button type="button" class="close" id="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <input type="text" id="keyword" name="keyword" class="searchInput" placeholder="Customer name or code">
      <div class="modal-body">
        <form>
        <table id="customerTable" class="table">
          <thead><td></td><td>Customer Name</td><td>Customer Code</td><td>Type</td></thead>
          <tbody></tbody>
        </table>
        </form>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
  $(document).ready(function () {
    setDate('${caseDto.operatingDate}', 'operatingDate');
    setDate('${caseDto.proposalDate}', 'proposalDate');
    setDate('${caseDto.acceptanceDate}', 'acceptanceDate');
    setDate('${caseDto.validationDate}', 'validationDate');
    setDate('${caseDto.discardDate}', 'discardDate');
    setDate('${caseDto.closingDate}', 'closingDate');
    setDate('${caseDto.suspenseDate}', 'suspenseDate');
  });
  $('#close').click(function() {
    let tbody = $('#customerTable').children('tbody');
    tbody.empty();
    $('#keyword').val('');

  });
  $('#select').click(function() {
    $("#searchModal").modal({
      backdrop: 'static',
      keyboard: false
    });
    $.ajax({
      url: "${pageContext.request.contextPath}/customers",
      type: "GET",
      success: function (response) {
        response.forEach(function (element) {
          $('#firstName').val(element.firstName + ' ' + element.lastName);
          $('#code').val(element.code);

          let tbody = $('#customerTable').children('tbody');
          let table = tbody.length ? tbody : $('#customerTable');
          tbody.append('<tr value='+element.firstName +' '+  element.lastName+'><td><input type="checkbox" id="selectedCustomer" value='+element.customerId+'></td>' +
                  '<td>'+element.firstName+'</td><td>'+element.code+'</td><td>'+element.type+'</td></tr>');
        });
      },
      error:  function(XMLHttpRequest) {
        console.error("Something went wrong");
      }
    });
  });

  $('#keyword').on("input", function () {
    let keyword = $('#keyword').val();
    let tbody = $('#customerTable').children('tbody');
    let table = tbody.length ? tbody : $('#customerTable');
    if (keyword) {
      $.ajax({
        url: "${pageContext.request.contextPath}/searchCustomer?keyword="+keyword,
        type: "GET",
        success: function (response) {
          tbody.empty();
          response.forEach(function (element) {

            tbody.append('<tr value='+element.firstName +' '+  element.lastName+'><td><input type="checkbox" id="selectedCustomer" class="selectedCustomer" ></td>' +
                    '<td>'+element.firstName+'</td><td>'+element.code+'</td><td>'+element.type+'</td></tr>');
          });
        },
        error:  function(XMLHttpRequest) {
          console.error("Something went wrong");
        }
      });
    }
  });

  $("#selectedCustomer").on("click", function() {
    // $('#firstName').val(element.firstName + ' ' + element.lastName);
    // $('#code').val(element.code);
    debugger;
    $("#currentCustomer").val('Ram')
    console.log($("#selectedCustomer").val())
  });

  $(".table").on('click','tr',function(e){
    e.preventDefault();
    let id = $(this).attr('value');
    $("#currentCustomer").val(id)
    $("#customer").val(id);
    $("#searchModal .close").click()
  });
</script>

