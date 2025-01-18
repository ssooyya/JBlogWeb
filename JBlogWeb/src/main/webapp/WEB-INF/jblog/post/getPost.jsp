<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Get Post</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<br>
	<br>
	<div class="container border">
		<br>
		<div>
			<h3>${post.title}</h3>
		</div>
		<br>
		<div>
			<div>${post.content}</div>
		</div>

		<br>
		<div>
			포스트 번호: <span id="id"><i>${post.id}</i></span>
		</div>
		<br> 작성자: <span><i>${post.user.username}</i></span>

		<hr>
		<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
		<c:if test="${post.user.username == principal.username}">
			<a href="/post/updatePost/${post.id}" class="btn btn-warning">수정하기</a>
			<button id="btn-delete" class="btn btn-danger">삭제하기</button>
		</c:if>
		<br> <br>
	</div>

	<br>
	<br>

	<c:if test="${!empty post.replyList}">
		<div class="container mt-3">
			<table class="table">
				<thead>
					<tr>
						<th width="80%">내용</th>
						<th width="10%">작성자</th>
						<!-- 댓글 작성자와 세션에 등록된 사용자의 이름이 같은 경우에만 삭제 가능 -->
						<c:if test="${reply.user.username != null && reply.user.username == principal.username}">
							<th width="10%">삭제</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="reply" items="${post.replyList}">
						<tr>
							<td>${reply.content }</td>
							<td>${reply.user.username}</td>
							<td><button
									onclick="replyObject.deleteReply(${post.id}, ${reply.id})">삭제</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>

	<div class="container mt-3">
		<input type="hidden" id="postId" value="${post.id}">
		<table class="table">
			<thead>
				<tr>
					<th><h4>댓글 목록</h4></th>
				</tr>
			</thead>
			<tbody>
				<tr align="right">
					<td><textarea id="reply-content" rows="1" class="form-control"></textarea>
						<button id="btn-save-reply" class="btn btn-secondary">댓글 동록</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<script src="/js/post.js"></script>
	<script src="/js/reply.js"></script>
	<%@include file="../layout/footer.jsp"%>
</body>
</html>
