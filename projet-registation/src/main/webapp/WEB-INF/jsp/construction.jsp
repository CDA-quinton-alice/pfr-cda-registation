<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<%@ include file="css.jsp"%>
	<title>Appli en construction !</title>
</head>

<body>
	<div id="wrapper">
		<%@ include file="topnavbar.jsp"%>
		<%@ include file="sidemenu.jsp"%>
		<div class="container p-3 my-3 bg-dark text-white">
			<h1>Appli en construction, revenez dans quelques jours !</h1>
			<h2>La team</h2>
		</div>

		<div class="container-fluid">

			<div id="div-connection" style="display: none">
				<form class="form-signin">
					<h2>
						Connectez vous
					</h2>
					<label for="loginInput" class="sr-only">Login</label>
					<input type="text" id="loginInput" class="form-control" placeholder="Login" required="required">
					<label for="passwordInput" class="sr-only">Password</label> 
					<input type="password" id="passwordInput" class="form-control" placeholder="Password" required="required">
					<button id="loginBtn" type="submit">Connection</button>
				</form>
			</div>
		</div>
		



	</div>
	<%@ include file="js.jsp"%>
</body>

</html>