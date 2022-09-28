<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${page.getObjects() != null}">
    <jsp:include page="/WEB-INF/jsp/templates/pagination.jsp">
        <jsp:param name="isFirstPage" value="${page.firstPage}" />
        <jsp:param name="isLastPage" value="${page.lastPage}" />
        <jsp:param name="currentPage" value="${page.currentPage}" />
        <jsp:param name="lastPageNo" value="${page.lastPageNo}" />
        <jsp:param name="pageUrl" value="${page.pageUrl}"/>
    </jsp:include>
</c:if>