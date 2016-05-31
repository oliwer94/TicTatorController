<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/user/index">TicTator</a>
		</div>
		<div class="navbar-collapse collapse" id="navbar-main">
			<ul class="nav navbar-nav pull-right">
				<li><a href="#">Hello <c:out value="${currentUser.username}"/></a></li>
				<li>
				<form:form action="${pageContext.request.contextPath}/j_spring_security_logout">
				    <button type="submit" class="btn btn-default pull-right navbar-btn">Log out</button>
				</form:form>
				</li>
			</ul>
		</div>

	</div>
</nav>