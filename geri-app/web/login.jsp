<%-- 
Document   : login
Created on : 11-Oct-2016, 13:42:06
Author     : wl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
		<script src="lib/angular/angular.js"></script>
		<script src="lib/angular-bootstrap/ui-bootstrap-tpls.js"></script>
		<script src="lib/js/main.js"></script>

		<!-- Compiled and minified CSS -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">

		<!-- Compiled and minified JavaScript -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
		<title>GERI-Notification</title>
	</head>
	<body>
		<div class="container">

			<div class="row">
				<div class="card col s4 offset-s4 z-depth-5">
					<form class="col" style="padding: 10px;"action="login.jsp" method="POST">

						<div class="row">
							<h1 class="center-align">Medication Box Page</h1>
						</div>

						<label for="PersonThreshold">Name: </label>
						<input type="text" id="PersonThreshold" name="PersonThreshold" /></br>

						<label for="PhoneNum">Phone Number: </label>
						<input type="text" id="PhoneNum" name="PhoneNum" /> </br>

						<label for="NumMisses">No. of misses: </label>
						<input type="text" id="NumMisses" name="NumMisses" /></br>

						<div class="center center-block center-align">
							<button type="submit" class="waves-effect waves-light btn">Submit</button>
							<input type="hidden" value="Submit" /> </br>
						</div>

					</form>
				</div>
			</div>
		</div>
	</body>
</html>
