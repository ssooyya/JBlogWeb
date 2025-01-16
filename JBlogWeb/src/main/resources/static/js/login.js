// loginObject 객체 선언
let loginObject = {
	// init() 함수 선언
	init: function() {
		let _this = this;

		// #btn-login 버튼에 click 이번트가 발생하면 login() 함수 호출
		$("#btn-login").on("click", () => {
			_this.login();
		});
	},

	login: function() {
		alert("로그인 요청됨");
		// 사용자가 입력한 값(username, password) 추출
		let data = {
			username : $("#username").val(),
			password : $("#password").val()
		}
		
		
		// Ajax를 이용한 비동기 호출
		// done() 함수: 요청 처리에 성공했을 때 실행될 코드
		// fail() 함수: 요청 처리에 실패했을 때 실행될 코드
		$.ajax({
			type:"POST",	// 요청방식
			url: "/auth/login",	// 요청 경로
			data: JSON.stringify(data),	// user 객체를 JSON 형식으로 변환
			// HTTP의 body에 설정되는 데이터 마임 타입
			contentType: "application/json; charset=UTF-8"
			// 응답으로 들어온 JSON 데이터를 response로 받는다.
		}).done(function(response) {
			// 응답 메세지를 콘솔에 출력하고 메인 페이지로 이동
			let message = response["data"];
			console.log(response);
			alert(message);
			location="/";
			// 에러 발생시 error로 에러 정보를 받는다
		}).fail(function(error) {
			// 에러 메세지를 알림창에 출력
			let message = error["data"];
			alert("에러 발생 : " + message)
		});		
		
		
		// user 객체의 값을 콘솔에 출력
		console.log(user);
	},
}
// loginObject 객체의 init()함수 호출
loginObject.init();