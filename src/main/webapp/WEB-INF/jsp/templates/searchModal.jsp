<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="${param.modalId}" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">${param.title}</h5>
        <button type="button" class="close" id="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <input type="text" id="keyword" name="keyword" class="searchInput" placeholder="${param.placeholder}">
      <div class="modal-body">
        <form>
          <table id="${param.tableName}" class="table">
            <thead><td></td><td>${param.id}</td><td>${param.name}</td><td>${param.other}</td></thead>
            <tbody></tbody>
          </table>
        </form>
      </div>
    </div>
  </div>
</div>
<script><%@include file="/WEB-INF/script/invoice.js" %></script>
