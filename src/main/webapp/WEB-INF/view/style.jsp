<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	type="text/css" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />"
	type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/tictator.css" />"
	type="text/css" rel="stylesheet">
	<c:if test="${empty sessionScope.user}">
		<c:import url="modals/register-modal.jsp"/>
	</c:if>