<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body >

	<h1>Spring Security Login Form (Database Authentication)</h1>

	<div id="login-box">

		<h2>Login with Username and Password</h2>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm' id="loginform" Method ="post" action="/authenticate" ModelAttribute="UserDTO">

		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='userName' id="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' id="password" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
				  value="submit" id="submit" /></td>
			</tr>
		  </table>

		  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		</form>
	</div>

</body>
<!-- <script type="text/javascript">
$(document).ready(function(){
	$("#submit").click(function(){
			alert("ok");
		var username = $("#username").val();
		var password = $("#password").val();
		
		// Checking for blank fields.
		if( username =='' || password ==''){
			$('input[type="text"],input[type="password"]').css("border","2px solid red");
			$('input[type="text"],input[type="password"]').css("box-shadow","0 0 3px red");
			alert("Please fill all fields...!!!!!!");
		}else {
			alert("in else");
			$.ajax({
		           type: "POST",
		           url: "/user/authenticate",
		           dataType: "application/json",
		           data:  "userName":+username+"& password":+password, // serializes the form's elements.
		           success: function(data)
		           {
		        	   alert("in success");
		               if(data="success"){
		            	   window.location.replace("/home");
		               }
		               else{
		            	   alert("Username or password is Incorrect..!!!");
		               }
		           }
		       });
		}
	});
});

</script> -->
</html>
