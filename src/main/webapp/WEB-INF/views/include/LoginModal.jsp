<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="login-modal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">會員登入</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      	<form method="POST" action="<c:url value='/Auth/Login'/>">
		  <div class="form-group">
		    <label for="email">帳號</label>
		    <input type="text" id="email" name="email" class="form-control" placeholder="email">
		  </div>
		  <div class="form-group">
		    <label for="password">Password</label>
		    <input type="password" id="password" name="password" class="form-control" placeholder="Password">
		  </div>
		  <button type="submit" class="btn btn-block btn-primary">登入</button>
		</form>
      </div>
    </div>
  </div>
</div>