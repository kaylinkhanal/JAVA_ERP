<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ tag import="org.springframework.util.StringUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="pagedListHolder" required="true"
	type="org.springframework.beans.support.PagedListHolder"%>
<%@ attribute name="pagedLink" required="true" type="java.lang.String"%>

<c:if test="${pagedListHolder.pageCount > 1}">
	<ul class="pagination">
		<c:if test="${!pagedListHolder.firstPage}">
			<li class="previous"><a
				href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(pagedListHolder.getPage() - 1))%>"><</a></li>
		</c:if>
		<c:if test="${pagedListHolder.firstLinkedPage > 1}">
			<li><span class="pagingDots">...</span>
			<li>
		</c:if>
		<c:if test="${!pagedListHolder.lastPage}">
			<li class="next"><a
				href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(pagedListHolder.getPage() + 1))%>">></a></li>
		</c:if>
	</ul>
</c:if>