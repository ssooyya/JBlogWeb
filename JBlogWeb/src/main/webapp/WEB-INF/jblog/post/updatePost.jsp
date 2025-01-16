<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Insert Post</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt-3">
		<form>
		<input type="hidden" id="id" value="${post.id }">
			<div class="mb-3">
				<label for="title">Title:</label> 
				<input type="text"
					class="form-control" id="title" value="${post.title }">
			</div>
			<div class="mb-3">
				<label for="content">Content:</label>
				<textarea class="form-control" rows="5" id="content">${post.content }</textarea>
			</div>
		</form>
		<button class=" btn btn-secondary" onclick="history.back()">돌아가기</button>
		<button id="btn-update" class=" btn btn-warning">포스트 수정</button>
	</div>
	<script>
		$(document).ready(function() {
			$('#content').summernote({
				height: 300
			});
		});
	</script>
	<script src="/js/post.js"></script>
	<%@include file="../layout/footer.jsp"%>
</body>
</html>
