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
              <div class="form-group col-md-6"></div>
              <div class="form-group col-md-6">
                <label for="revision"> Revision: 1</label>
              </div>
              <div class="form-group col-md-6">
                <label for="documentNo">Document No: </label>
                <input type="text" disabled class="form-control" name="documentNo" value="${document.documentNo}" />
              </div>
              <div class="form-group col-md-6">
                <label for="branch">Branch: </label>
                <select id="branch" name="branch" class="form-control" required>
                    <c:choose>
                        <c:when test="${document == null}">
                            <option value="">Choose...</option>
                        </c:when>
                        <c:otherwise>
                            <option selected value="${document.branch}">${document.branch}</option>
                        </c:otherwise>
                    </c:choose>
                  <option value="Bangrak">Bangrak</option>
                  <option value="Asok">Asok</option>
                </select>
              </div>
             </div>
             <div class="form-row col-md-12">
              <div class="form-group col-md-6">
                <label for="documentName">Document Name:</label>
                <input type="text" class="form-control" id="documentName" name="documentName" value="${document.documentName}" required />
              </div>
              <div class="form-group col-md-6">
                <label for="format">Doc Printing Format: </label>
                <select id="printingFormat" name="printingFormat" class="form-control" required >
                    <c:choose>
                        <c:when test="${document == null}">
                            <option value="">Choose...</option>
                        </c:when>
                        <c:otherwise>
                            <option selected value="${document.printingFormat}">${document.printingFormat}</option>
                        </c:otherwise>
                    </c:choose>
                    <option value="A4">A4</option>
                    <option value="A5">A5</option>
                </select>
              </div>
             </div>
             <div class="form-row col-md-12">
              <div class="form-group col-md-6">
                <label for="documentType">Document Type:</label>
                  <select id="documentType" name="documentType" class="form-control" required>
                      <c:choose>
                          <c:when test="${document == null}">
                              <option value="">Choose...</option>
                          </c:when>
                          <c:otherwise>
                              <option selected value="${document.documentType.documentTypeId}">${document.documentType.documentTypeName}</option>
                          </c:otherwise>
                      </c:choose>
                      <c:forEach var="documentType" items="${documentTypes }" >
                          <option value="${documentType.documentTypeId }">${documentType.documentTypeName}</option>
                      </c:forEach>
                  </select>
              </div>
              <div class="form-group col-md-6">
                <label for="language">Language:</label>
                <select id="language" name="language" class="form-control" required>
                    <c:choose>
                        <c:when test="${document == null}">
                            <option value="">Choose...</option>
                        </c:when>
                        <c:otherwise>
                            <option selected value="${document.language}">${document.language}</option>
                        </c:otherwise>
                    </c:choose><
                    <option value="English">English</option>
                    <option value="English">Thai</option>
                </select>
              </div>
             </div>
            </div>
            <div class="col-md-2">
              <br><br> <br><br>
                <button type="submit" class="btn btn-primary float-right" id="save"><span class="far fa-save"></span>  Save</button>
                <br/><br/>
                <button type="button" class="btn btn-primary float-right" id="cancel"> Cancel</button>
            </div>
          </div>

          <div class="form-row">
            <div class="form-group col-md-12">
              <textArea type="text" row="3" class="form-control document" id="content" name="content">
                  ${document.content}
              </textArea>
            </div>
          </div>
<%--            <div id="sample">--%>
<%--                <script type="text/javascript">--%>

<%--                    bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });--%>
<%--                </script>--%>

<%--                <textarea name="area3" style="width: 300px; height: 100px;">       HTML content default in textarea--%>
<%--</textarea>--%>
<%--            </div>--%>
        </form>
      </div>
    </div>
  </body>
</html>
<script>
  $(document).ready(function() {
    getEditor("document");
  })
</script>
<script>
  <%--$('#save').click(function() {--%>

  <%--   });--%>
</script>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>


