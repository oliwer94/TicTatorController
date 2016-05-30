<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<div class="navbar-collapse collapse" id="navbar-main">
			<ul class="nav navbar-nav pull-right">
				<li><a href="#">Not registered?</a></li>
			</ul>
			<form:form class="navbar-form navbar-right" id="form-login"
				name="form-login" modelAttribute="currentUser"
				action="${pageContext.request.contextPath}/j_spring_security_check"
				method="POST">
				<div class="form-group">
					<form:input class="form-control" path="username" value="USERNAME"></form:input>
				</div>
				<div class="form-group">
					<form:input type="password" class="form-control" value="PASSWORD"
						path="password"></form:input>
				</div>
				<button type="submit" class="btn btn-default pull-right">Sign
					In</button>
			</form:form>
		</div>
	</div>
</nav>