<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="form-row" id="itemDiv" style="display: ${param.display}; background: darkgray">
    <div class="form-group col-md-12">
        <br/>
        <input class="col-md-5" type="hidden" name="${param.detailId}" id="${param.detailId}" value="${param.detailId}">
        <label id="item" name="item" class="col-md-1">${param.itemId}</label>
        <label id="itemName" name="itemName" class="col-md-3">${param.itemName}</label>
        <label class="col-md-2">Amount</label>
        <input class="col-md-5" type="text" name="itemAmount" id="itemAmount" value="${param.itemAmount}">
<%--       <c:if test="${param.masterId != null}">--%>
<%--           <button type="button" class="btn btn-danger" onclick="openPage('/invoice/deleteDepositDetail/${param.masterId}/${param.detailId}')">--%>
<%--               <span aria-hidden="true">&times;</span>--%>
<%--           </button>--%>
<%--       </c:if>--%>
        <c:if test="${param.masterId == null}">
            <button type="button" class="itemClose" id="itemClose">
                <span aria-hidden="true">&times;</span>
            </button>
        </c:if>
        <hr/>
    </div>
</div>