<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />"
	type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/tictator.css" />"
	type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	type="text/css" rel="stylesheet">
<c:set value="${pageContext.servletContext.contextPath}" scope="page"
	var="context" />
<input id="contextId" type="hidden" value="${context}" />
<script src="<c:url value="/resources/js/jquery-1.12.4.min.js"/>"></script>
