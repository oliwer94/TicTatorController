<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>TicTator - It's Tictastic!</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/tictator.css" />"
	type="text/css" rel="stylesheet">
</head>

<body>

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
				<a class="navbar-brand" href="#">TicTator</a>
			</div>
			<div class="navbar-collapse collapse" id="navbar-main">
				<ul class="nav navbar-nav pull-right">
					<li><a href="#">Not registered?</a></li>
				</ul>
				<form:form class="navbar-form navbar-right" role="search" modelAttribute="simpleUser" 
						   action="${pageContext.request.contextPath}/login" method="POST">
					<div class="form-group">
						<form:input class="form-control" path="username"
							></form:input>
					</div>
					<div class="form-group">
						<form:input  type="password" class="form-control" path="password"
							></form:input>
					</div>
					<button type="submit" class="btn btn-default">Sign In</button>
				</form:form>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>GAME WINDOW</h1>
			<h1>${sessionScope.Admin} </h1>
		</div>

	</div>
	<!-- /.container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<c:url value="/resources/js/jquery-1.12.4.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>
