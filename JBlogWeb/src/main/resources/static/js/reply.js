// 댓글
let replyObject = {
	init: function() {
		$("#btn-save-reply").on("click", () => {
			this.insertReply();
		});
	},

	// 댓글 등록
	insertReply: function() {
		alert("댓글 등록 요청됨");
		let id = $("#postId").val();
		let reply = {
			content: $("#reply-content").val()
		}
		$.ajax({
			type: "POST",
			url: "/reply/" + id,
			data: JSON.stringify(reply),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			let message = response["data"];
			alert(message);
			location = "/post/" + id;
		}).fail(function(error) {
			// 에러 메세지를 알림창에 출력
			let message = error["data"];
			alert("에러 발생 : " + message)
		});
		console.log("id값" + id);
	},
	// 댓글 삭제
	deleteReply: function(postId, replyId) {
		alert("댓글 삭제 요청됨");

		$.ajax({
			type: "DELETE",
			url: "/reply/" + replyId
		}).done(function(response) {
			let message = response["data"];
			alert(message);
			location: "/post/" + postId;
		}).fail(function(error) {
			// 에러 메세지를 알림창에 출력
			let message = error["data"];
			alert("에러 발생 : " + message)
		});
		console.log("reply값 " + replyId);
	},
}
replyObject.init();