<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./layout/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
</head>
<body>
	<br>
	<div class="container mt-3">
		<c:if test="${!empty postList }">
			<div class="card">
				<c:forEach var="post" items="${postList.content}">
					<div class="card-body">
						<h4 class="card-title">${post.title}</h4>
						<a href="/post/${post.id }" class="btn btn-secondary">상세보기</a>
					</div>
				</c:forEach>
			</div>

			<br>
			<ul class="pagination justify-content-between">
				<li class="page-item <c:if test="${postList.first}">disabled</c:if>">
					<a class="page-link" href="?page=${postList.number - 1}">이전 페이지</a>
				<li class="page-item <c:if test="${postList.last}">disabled</c:if>"><a
					class="page-link" href="?page=${postList.number + 1}">다음 페이지</a>
			</ul>
		</c:if>
	</div>
	<%@ include file="./layout/footer.jsp"%>
</body>
</html>