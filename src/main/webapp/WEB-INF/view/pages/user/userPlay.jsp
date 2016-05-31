<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<input type="hidden" id="gameId" size="50">
<input type="hidden" id="username" size="50"
	value="${currentUser.username}">
<br>
<div id="gameInfo" class="text-center">
	<i id="loadingIcon"
		class="text-center fa fa-spinner fa-spin fa-3x fa-fw"></i>
	<h4 id="loadingText">Loading game...</h4>
</div>
<div class="row" style="margin-top: 50px">
	<div class="col-xs-offset-2 col-xs-8 col-sm-offset-0 col-sm-12 col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">
		<div class="messages"></div>
		<div class="turn"></div>
		<table class="table tictac">
			<tr>
				<td id="cell_0" class="square"></td>
				<td id="cell_1" class="square"></td>
				<td id="cell_2" class="square"></td>
			</tr>
			<tr>
				<td id="cell_3" class="square"></td>
				<td id="cell_4" class="square"></td>
				<td id="cell_5" class="square"></td>
			</tr>
			<tr>
				<td id="cell_6" class="square"></td>
				<td id="cell_7" class="square"></td>
				<td id="cell_8" class="square"></td>
			</tr>
		</table>
	</div>
</div>
<form:form id="replay"
	action="${pageContext.request.contextPath}/user/play/" method="GET">
</form:form>
<script src="<c:url value="/resources/js/game.js"/>"></script>
