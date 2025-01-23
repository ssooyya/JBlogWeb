// postObject 객체 선언
let postObject = {
	// init() 함수 선언
	init: function() {
		let _this = this;

		// #btn-insert 버튼에 click 이번트가 발생하면 insertPost() 함수 호출
		$("#btn-insert").on("click", () => {
			_this.insertPost();
		});
		$("#btn-update").on("click", () => {
			_this.updatePost();
		});
		$("#btn-delete").on("click", () => {
			_this.deletePost();
		})
	},

	insertPost: function() {
		alert("포스트 등록 요청됨");
		// 사용자가 입력한 값(title, content) 추출
		let post = {
			title: $("#title").val(),
			content: $("#content").val()
		}

		// Ajax를 이용한 비동기 호출
		// done() 함수: 요청 처리에 성공했을 때 실행될 코드
		// fail() 함수: 요청 처리에 실패했을 때 실행될 코드
		$.ajax({
			type: "POST",	// 요청방식
			url: "/post",	// 요청 경로
			data: JSON.stringify(post),	// post 객체를 JSON 형식으로 변환
			// HTTP의 body에 설정되는 데이터 마임 타입
			contentType: "application/json; charset=UTF-8"
			// 응답으로 들어온 JSON 데이터를 response로 받는다.
		}).done(function(response) {
			// 응답 메세지를 콘솔에 출력하고 메인 페이지로 이동
			let status = response["status"];
			if(status == 200) {
				let message = response["data"];
				alert(message);
				console.log(response);
				location = "/";
			} else {
				let warn = "";
				let errors = response["data"];
				if(errors.title != null) warn = warn + errors.title + "\n";
				if(errors.content != null) warn = warn + errors.content;
				alert(warn);
			}
			// 에러 발생시 error로 에러 정보를 받는다
		}).fail(function(error) {
			// 에러 메세지를 알림창에 출력
			let message = error["data"];
			alert("문제 발생 : " + message)
		});
		// post 객체의 값을 콘솔에 출력
		console.log(post);
	},

	updatePost: function() {
		alert("포스트 수정 요청됨");
		// 사용자가 입력한 값(id, title, content) 추출
		let post = {
			id: $("id").val(),
			title: $("#title").val(),
			content: $("#content").val()
		}

		// Ajax를 이용한 비동기 호출
		// done() 함수: 요청 처리에 성공했을 때 실행될 코드
		// fail() 함수: 요청 처리에 실패했을 때 실행될 코드
		$.ajax({
			type: "PUT",	// 요청방식
			url: "/post",	// 요청 경로
			data: JSON.stringify(post),	// post 객체를 JSON 형식으로 변환
			// HTTP의 body에 설정되는 데이터 마임 타입
			contentType: "application/json; charset=UTF-8"
			// 응답으로 들어온 JSON 데이터를 response로 받는다.
		}).done(function(response) {
			// 응답 메세지를 콘솔에 출력하고 메인 페이지로 이동
			let message = response["data"];
			alert(message);
			console.log(response);
			location = "/";
			// 에러 발생시 error로 에러 정보를 받는다
		}).fail(function(error) {
			// 에러 메세지를 알림창에 출력
			let message = error["data"];
			alert("문제 발생 : " + message)
		});
		// post 객체의 값을 콘솔에 출력
		console.log(post);
	},
	deletePost: function() {
		alert("포스트 삭제 요청됨");
		// 사용자가 입력한 값(id, title, content) 추출
		let id = $("#id").text();

		// Ajax를 이용한 비동기 호출
		// done() 함수: 요청 처리에 성공했을 때 실행될 코드
		// fail() 함수: 요청 처리에 실패했을 때 실행될 코드
		$.ajax({
			type: "DELETE",	// 요청방식
			url: "/post/" + id,	// 요청 경로
			data: JSON.stringify(post),	// post 객체를 JSON 형식으로 변환
			// HTTP의 body에 설정되는 데이터 마임 타입
			contentType: "application/json; charset=UTF-8"
			// 응답으로 들어온 JSON 데이터를 response로 받는다.
		}).done(function(response) {
			// 응답 메세지를 콘솔에 출력하고 메인 페이지로 이동
			let message = response["data"];
			alert(message);
			console.log(response);
			location = "/";
			// 에러 발생시 error로 에러 정보를 받는다
		}).fail(function(error) {
			// 에러 메세지를 알림창에 출력
			let message = error["data"];
			alert("문제 발생 : " + message)
		});
		// id값을 콘솔에 출력
		console.log(id);
	},
}
// postObject 객체의 init()함수 호출
postObject.init();