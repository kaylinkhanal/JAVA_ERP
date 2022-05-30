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
          
          <div class="col-xs-12 row">
          
            <div class="col-md-10 row">
             <div class="form-row col-md-12">
              <div class="form-group col-md-6"></div>
              <div class="form-group col-md-6">
                <label for="revision"> Revision: 1</label>
              </div>
              <div class="form-group col-md-6">
                <label for="documentNo">Document No: </label>
                <input type="text" disabled class="form-control" name="documentNo" />
              </div>
              <div class="form-group col-md-6">
                <label for="branch">Branch: </label>
                <select id="branch" name="branch" class="form-control">
                  <option selected>Choose...</option>
                  <option>...</option>
                </select>
              </div>
             </div>
             <div class="form-row col-md-12">
              <div class="form-group col-md-6">
                <label for="documentName">Document Name:</label>
                <input type="text" class="form-control" id="documentName" />
              </div>
              <div class="form-group col-md-6">
                <label for="format">Doc Printing Format: </label>
                <select id="format" name="format" class="form-control">
                  <option selected>Choose...</option>
                  <option>...</option>
                </select>
              </div>
             </div>
             <div class="form-row col-md-12">
              <div class="form-group col-md-6">
                <label for="documentType">Document Type:</label>
                <select id="documentType" name="documentType" class="form-control">
                  <option selected>Choose...</option>
                  <option>...</option>
                </select>
              </div>
              <div class="form-group col-md-6">
                <label for="language">Language:</label>
                <select id="language" name="language" class="form-control">
                  <option selected>Choose...</option>
                  <option>...</option>
                </select>
              </div>
             </div>
            </div>
            <div class="col-md-2">
              <br><br> <br><br>
                <button type="button" class="btn btn-primary float-right" id="save"><span class="far fa-save"></span>  Save</button>
                <br/><br/>
                <button type="button" class="btn btn-primary float-right" id="cancel"> Cancel</button>
            </div>
          </div>

          <div class="form-row">
            <div class="form-group col-md-12">
              <textArea type="text" row="3" class="form-control document" id="document" name="document" ></textArea>
            </div>
          </div>
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
  $('#save').click(function() {
     var pathname = window.location.href;
     var divContents = $('#document').val();
     var popupWin = window.open('', '_blank', 'width=992,height=600,location=1,status=1,scrollbars=1,left=100px');
        // popupWin.document.open();
        popupWin.document.write('<!DOCTYPE html><html><head><meta charset="UTF-8"><title></title><link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"  media="print"></head><body onload="window.print()">');
        popupWin.document.write(divContents);
        popupWin.document.write('</body></html>');
        popupWin.document.close();
     });
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


