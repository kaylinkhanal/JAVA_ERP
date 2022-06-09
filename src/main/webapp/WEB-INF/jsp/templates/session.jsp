<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
<div class="col-md-12 row">
    <c:if test="${param != null}" >
        <h5 class="float-right">
            <span>Customer:</span>
            <button type="button" class="btn btn-secondary">${param.customerId}</button>
        </h5>
        <c:if test="${param.companyId != null}" >
            <h5 class="float-right">
                <span>Company:</span>
                <button type="button" class="btn btn-secondary">${param.companyId}</button>
            </h5>
        </c:if>
    </c:if>
</div>
</body>
</html>