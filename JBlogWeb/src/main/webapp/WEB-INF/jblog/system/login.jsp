<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<br>
	<div class="container mt-3">
		<form>
			<div class="mb-3">
				<label for="uname">Username:</label> <input type="text"
					class="form-control" id="username" placeholder="Enter username"
					name="username">
			</div>
			<div class="mb-3">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Enter password"
					name="password">
			</div>
		</form>
		<button id="btn-login" class=" btn btn-secondary">로그인</button>
	</div>
	<script src="/js/login.js"></script>
	<%@include file="../layout/footer.jsp"%>
</body>
</html>
