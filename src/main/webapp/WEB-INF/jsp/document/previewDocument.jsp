<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> <%@include file="/WEB-INF/jsp/templates/base.jsp" %> <%@
        taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1" />
    <title>Document Template</title>
    <%--      <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">--%>
</head>
<body>
<div class="container-wrapper">
    <div class="container">
        <br/>
        <div class="page-header">
            <h1>Preview Document Template</h1>
            <hr />
        </div>
        <form method="post" action="addDocument">
            <input type="hidden" class="form-control" name="documentId" value="${document.documentId}" />
            <div class="col-xs-12 row">

                <div class="col-md-10 row">
                    <div class="form-row">
                        <div class="form-group col-md-6" id="documentPreview" style="visibility: hidden">

                        </div>
                    </div>
                    <div class="form-row col-md-12">
                        <div class="form-group col-md-6">
                            <label for="executorName">Executor Name: </label>
                            <input type="text" class="form-control" name="executorName" id="executorName"
                                   value="${caseDto.customer.fullName != null ? caseDto.customer.fullName : caseDto.customer.companyName  }" />
                        </div>
                        <div class="form-group col-md-6">
                            <label for="nationality">Nationality: </label>
                            <select id="nationality" name="nationality" class="form-control" required value="${caseDto.customer.address.country}">
                                <c:choose>
                                    <c:when test="${caseDto == null}">
                                        <option selected value="">Choose...</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option selected value="${caseDto.customer.address.country.countryId}">${caseDto.customer.address.country.countryName}</option>
                                    </c:otherwise>
                                </c:choose>

                                <c:forEach var="country" items="${countries }" >
                                    <option value="${country.countryName }">${country.countryName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-row col-md-12">
                        <div class="form-group col-md-6">
                            <label for="contactNumber">Contact Number:</label>
                            <input type="text" class="form-control" id="contactNumber" name="contactNumber" required value="${caseDto.customer.address.phone1}"/>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="dateOfBirth">DOB: </label>
                            <input type="text" class="form-control" id="dateOfBirth" name="dateOfBirth" required value="${caseDto.customer.dateOfBirth}"/>
                        </div>
                    </div>
                    <div class="form-row col-md-12">
                        <div class="form-group col-md-6">
                            <label for="documentType">Document Type:</label>
                            <select id="documentType" name="documentType" class="form-control" required>
                                <option value="">Choose...</option>
                                <c:forEach var="documentType" items="${documentTypes }" >
                                    <option value="${documentType.documentTypeId }">${documentType.documentTypeName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="documentTemplate">Document Template:</label>
                            <select id="documentTemplate" name="documentTemplate" class="form-control" required>
                                <option value="">Choose...</option>
                            </select>
                        </div>

                    </div>
                    <div class="form-row col-md-12">
                        <div class="form-group col-md-6">
                            <label for="passportNumber">Passport Number:</label>
                            <input type="text" class="form-control" id="passportNumber" name="passportNumber" required value="${caseDto.customer.idPassportNo}"/>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="address">Address:</label>
                            <input type="text" class="form-control" id="address" name="address" required
                                   value="${caseDto.customer.address.addressNo}" />
                        </div>
                    </div>
                    <div class="form-row col-md-12">
                            <div class="form-group col-md-6">
                                <label for="effectiveDate">Effective Date:</label>
                                <input type="text" class="form-control" id="effectiveDateFrom" name="effectiveDateFrom" required />
                        </div>
                        <div class="form-group col-md-6">
                            <label for="effectiveDate">:</label>
                            <input type="text" class="form-control" id="effectiveDateTo" name="effectiveDateTo" required />
                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                    <br><br> <br><br>
                    <button type="button" onclick="previewDocument()" class="btn btn-primary float-right" id="save"><span class="far fa-save"></span>  Save</button>
                    <br/><br/>
                </div>
            </div>


        </form>
    </div>
</div>
</body>
</html>

<script><%@include file="/WEB-INF/script/documentPreview.js" %></script>