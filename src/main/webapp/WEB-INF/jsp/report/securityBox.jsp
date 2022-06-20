<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@include file="/WEB-INF/jsp/templates/base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Security Box</title>
</head>
<body>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Security Box</h1>
            <hr/>
        </div>
        <form>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="fromDate">From Date: </label>
                    <input type="text" class="form-control" id="fromDate" name="fromDate" value=""/>
                </div>
                <div class="form-group col-md-6">
                    <label for="toDate">To Date: </label>
                    <input type="text" class="form-control" id="toDate" name="toDate" value=""/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="boxCode">Box Code: </label>
                    <input type="text" class="form-control" id="boxCode" name="boxCode" value=""/>
                </div>
                <div class="form-group col-md-6">
                    <label for="status">Status: </label>
                    <select id="status" name="status" class="form-control" value="" required>
                        <option value="Opened">Opened</option>
                        <option value="Closed">Closed</option>
                    </select>
                </div>
            </div>
            <input type="submit" class="btn btn-primary" value="Search">
        </form>
        <br/><br/>
        <div align="center" class="container">
            <table border="1" width="60%" class="table table-striped">
                <thead align="center" class="bg-primary">
                <tr>
                    <td>No.</td>
                    <td>Payment Status</td>
                    <td>Case ID</td>
                    <td>Case</td>
                    <td>Contact</td>
                    <td>Invoice No.</td>
                    <td>Amount</td>
                    <td>Currency</td>
                </tr>
                </thead>
            </table>
            <jsp:include page="/WEB-INF/jsp/templates/page.jsp">
                <jsp:param name="page" value="${page}"/>
            </jsp:include>
        </div>
    </div>
</div>
</body>
</html>
