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
            <h1>Create Email Template</h1>
            <hr />
        </div>
        <form method="post" action="addTemplate">
            <input type="hidden" value="${template.templateId}" name="templateId" />
            <div class="col-xs-12">
                <div class="form-row col-md-8">
                    <div class="form-group col-md-6">
                        <input type="text" class="form-control" id="templateName" name="templateName" placeholder="Email Template Name" value="${template.templateName}"/>
                    </div>
                    <div class="form-group col-md-6">
                        <input type="text" class="form-control" id="subject" name="subject" placeholder="Email Template Subject" value="${template.subject}"/>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-12">
                  <textArea type="text" row="3" class="form-control email" id="content" name="content">
                    ${template.content}
                  </textArea>
                    </div>
                </div>
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary float-right" id="save">Save Email Template</button>
                </div>
                <div class="col-md-12">
                    <button type="button" class="btn btn-primary float-left" id="sendEmail" onclick="sendEmailData()">Send Email</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
<script>
    $(document).ready(function() {
        getEditor("email");
    })

    function sendEmailData() {
        $.ajax({
            url: "${pageContext.request.contextPath}/email/sendEmail",
            type: "POST",
            data: {
                templateName: $("#templateName").val(),
                subject: $("#subject").val(),
                content: $("#content").val(),
            },
            success: function () {
                alert("sent")
            },
            error:  function(XMLHttpRequest) {
                console.error("Something went wrong");
            }
        });
    }
</script>



