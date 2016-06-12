<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header" style="margin-left:5px; width:100%;">
			<form:form  class="navbar-right"  action="${pageContext.request.contextPath}/j_spring_security_logout">
			    <button type="submit" class="btn btn-default pull-right navbar-btn">Log out</button>
			</form:form>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/user/index">TicTator</a>
			<p class="navbar-text" href="#">Hello <c:out value="${currentUser.username}"/></p>
		</div>
	</div>
</nav>