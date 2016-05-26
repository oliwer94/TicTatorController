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
					<button type="button"  style="font-size:7pt;color:white;background-color:transparent;border:0px solid #336600;padding:20px" data-toggle="modal" data-target="#register-modal">Not registered?</button>
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

	<!-- Register Modal -->
<div id="register-modal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Registration form</h4>
            </div>
            <div class="modal-body">
                <form  role="search"
						modelAttribute="simpleUser"
						action="${pageContext.request.contextPath}/register" method="POST">
                    <div class="form-group">
                        <label for="username">Username:</label>
                        <input type="username" class="form-control" id="username" name="username" placeholder="Enter username" path="username">
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" path="password">
                    </div>
                    
                    <td><input id="button" type="submit" class="btn btn-default" name="submit" value="Sign-Up"></td>

                </form>


            </div>
            <div class="modal-footer">
                <label>So close. Just fill it up!</label>
            </div>
        </div>
    </div>
</div>
