<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br>
<br>
<br>
<br>

<div class="row">
	<div class="col-lg-offset-2 col-lg-8 text-center">Click play to
		play</div>
</div>
<br>
<div class="row">
	<form:form action="${pageContext.request.contextPath}/user/play/" method="GET">
		<button type="submit" class="btn btn-lg btn-primary center-block">PLAY</button>
	</form:form>
</div>
