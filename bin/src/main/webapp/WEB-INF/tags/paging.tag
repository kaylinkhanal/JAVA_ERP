<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="page" required="true"%>
<c:if test="${!page.isFirstPage}">
  <a href="${page.getPageUrl()}?page=${page.getCurrentPage() -1}">Previous</a>  
</c:if>
<c:forEach var="i" begin="0" end="${page.getLastPageNo()-1 }" >
  <a href="${page.getPageUrl()}?page=${i }">${i+1 }</a>    	<!-- Displaying Page No -->
</c:forEach>
<c:if test="${!page.isLastPage()}">
  <a href="${page.getPageUrl()}?page=${page.getCurrentPage() +1}">Next</a>  
</c:if>