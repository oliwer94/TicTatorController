<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<c:if test="${not empty sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}">
		<div class="row">
			<div class="col-md-9">
				<div class="alert alert-danger">
					<p>${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}</p>
				</div>
			</div>
		</div>
	</c:if>
	<div class="col-lg-offset-2 col-lg-8">

		<p>This is where you login</p>
	</div>
</div>
