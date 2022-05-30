<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head></head>
    <body>
        <c:if test="${!param.isFirstPage}">
            <a href="${param.pageUrl}?page=${param.currentPage -1}">Previous</a>
        </c:if>
        <c:forEach var="i" begin="0" end="${param.lastPageNo -1}" >
            <a href="${param.pageUrl}?page=${i }">${i+1 }</a>
        </c:forEach>
        <c:if test="${!param.isLastPage}">
            <a href="${param.pageUrl}?page=${param.currentPage +1}">Next</a>
        </c:if>
    </body>
</html>