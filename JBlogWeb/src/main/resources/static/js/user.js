// userObject 객체 선언
let userObject = {
	// init() 함수 선언
	init: function() {
		let _this = this;

		// #btn-save 버튼에 click 이번트가 발생하면 insertUser() 함수 호출
		$("#btn-save").on("click", () => {
			_this.insertUser();
		});
	},

	insertUser: function() {
		alert("회원가입 요청됨");
		// 사용자가 입력한 값(username, password, email) 추출
		let user = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}

		// Ajax를 이용한 비동기 호출
		// done() 함수: 요청 처리에 성공했을 때 실행될 코드
		// fail() 함수: 요청 처리에 실패했을 때 실행될 코드
		$.ajax({
			type: "POST",	// 요청방식
			url: "/auth/insertUser",	// 요청 경로
			data: JSON.stringify(user),	// user 객체를 JSON 형식으로 변환
			// HTTP의 body에 설정되는 데이터 마임 타입
			contentType: "application/json; charset=UTF-8"
			// 응답으로 들어온 JSON 데이터를 response로 받는다.
		}).done(function(response) {
			// 응답 메세지를 콘솔에 출력하고 메인 페이지로 이동
			console.log(response);
			location = "/";
			// 에러 발생시 error로 에러 정보를 받는다
		}).fail(function(error) {
			// 에러 메세지를 알림창에 출력
			alert("에러 발생 : " + error)
		});

		// user 객체의 값을 콘솔에 출력
		console.log(user);
	},
}
// userObject 객체의 init()함수 호출
userObject.init();