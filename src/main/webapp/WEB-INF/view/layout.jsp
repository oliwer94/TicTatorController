<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="Tictator" content="">
<meta name="JOFA" content="">

<title><tiles:insertAttribute name="title" ignore="true" /></title>
<tiles:insertAttribute name="stylecss" />
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-3">
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6">
				<tiles:insertAttribute name="body" />
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3">
			</div>
		</div>
	</div>
	<tiles:insertAttribute name="footer" />
	<tiles:insertAttribute name="scripts" />
</body>
</html>