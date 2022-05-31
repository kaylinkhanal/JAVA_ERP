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
            <h1>Generate Document Template</h1>
            <hr />
        </div>
        <form method="post" action="addDocument">
            <input type="hidden" class="form-control" name="documentId" value="${document.documentId}" />
            <div class="col-xs-12 row">

                <div class="col-md-10 row">
                    <div class="form-row col-md-12">
                        <div class="form-group col-md-6">
                            <label for="executorName">Executor Name: </label>
                            <input type="text" class="form-control" name="executorName" id="executorName"  />
                        </div>
                        <div class="form-group col-md-6">
                            <label for="nationality">Nationality: </label>
                            <select id="nationality" name="nationality" class="form-control" required>
                                <c:forEach var="country" items="${countries }" >
                                    <option value="${country.countryId }">${country.countryName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-row col-md-12">
                        <div class="form-group col-md-6">
                            <label for="contactNumber">Contact Number:</label>
                            <input type="text" class="form-control" id="contactNumber" name="contactNumber" required />
                        </div>
                        <div class="form-group col-md-6">
                            <label for="dateOfBirth">DOB: </label>
                            <input type="text" class="form-control" id="dateOfBirth" name="dateOfBirth" required />
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
                            <label for="passportNumber">Passport Number:</label>
                            <input type="text" class="form-control" id="passportNumber" name="passportNumber" required />
                        </div>
                    </div>
                    <div class="form-row col-md-12">
                        <div class="form-group col-md-6">
                            <label for="effectiveDate">Effective Date:</label>
                            <input type="text" class="form-control" id="effectiveDateFrom" name="effectiveDateFrom" required />:
                            <input type="text" class="form-control" id="effectiveDateTo" name="effectiveDateTo" required />
                        </div>
                        <div class="form-group col-md-6">
                            <label for="address">Address:</label>
                            <input type="text" class="form-control" id="address" name="address" required />
                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                    <br><br> <br><br>
                    <button type="submit" class="btn btn-primary float-right" id="save"><span class="far fa-save"></span>  Save</button>
                    <br/><br/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6" id="documentPreview" style="visibility: hidden">

                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>

<script>
    $("#documentType").change(function () {
        let documentType = $("#documentType").val();
        $.ajax({
            url: "${pageContext.request.contextPath}/document/findDocumentTemplate/"+documentType,
            type: "GET",
            success: function (response) {
                const documentDiv = document.querySelector('#documentPreview');
                documentDiv.innerHTML = response
                $("#documentPreview").css('visibility', 'visible')
                $("#documentPreview").css('border', '1px solid black')
            },
            error:  function(XMLHttpRequest) {
                console.error("Something went wrong");
            }
        });
    });

</script>