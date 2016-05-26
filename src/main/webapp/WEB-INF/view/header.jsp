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
			<a class="navbar-brand" href="${pageContext.request.contextPath}">TicTator</a>
		</div>
		<c:choose>
			<c:when test="${not empty sessionScope.user}">
				<div class="navbar-collapse collapse" id="navbar-main">
						<a style="margin-top:8px;" type="button" onclick="location.href='${pageContext.request.contextPath}/logout'" class="btn btn-danger pull-right">Log out</a>
					<ul class="nav navbar-nav pull-right">
						<li><a>Welcome back <c:out
									value="${sessionScope.user.username}" /></a></li>
					</ul>
				</div>
			</c:when>
			<c:otherwise>
				<div class="navbar-collapse collapse" id="navbar-main">
					<ul class="nav navbar-nav pull-right">
						<li><a href="#">Not registered?</a></li>
					</ul>
					<form:form class="navbar-form navbar-right" role="search"
						modelAttribute="simpleUser"
						action="${pageContext.request.contextPath}/login" method="POST">
						<c:if test="${not empty loginFail}">
							<a style="color: red;"> Wrong username and/or password</a>
						</c:if>
						<div class="form-group">
							<form:input class="form-control" path="username"></form:input>
						</div>
						<div class="form-group">
							<form:input type="password" class="form-control" path="password"></form:input>
						</div>
						<button type="submit" class="btn btn-default">Sign In</button>
					</form:form>
				</div>
			</c:otherwise>
		</c:choose>

	</div>
</nav>