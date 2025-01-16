package com.ssamz.jblog.controller;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssamz.jblog.domain.RoleType;
import com.ssamz.jblog.domain.User;
import com.ssamz.jblog.exception.JBlogException;
import com.ssamz.jblog.persistence.UserRepository;

import jakarta.transaction.Transactional;

@Controller
public class UserController_RestAPI {
	@Autowired
	private UserRepository userRepository;

	// 회원 등록
	@PostMapping("/user")
	public @ResponseBody String insertUser(@RequestBody User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return user.getUsername() + "회원가입 성공";
	}

	// 상세 조회
	@GetMapping("/user/get/{id}")
	public @ResponseBody User getUser(@PathVariable int id) {
// 		예외 처리 전		
//		// 특정 id(회원번호)에 해당하는 User 객체 반환
//		User findUser = userRepository.findById(id).get();
//		return findUser;

		// 검색된 회원이 없을 경우 예외 반환
//		User findUser = userRepository.findById(id).orElseThrow(new Supplier<JBlogException>() {
//			@Override
//			public JBlogException get() {
//				return new JBlogException(id + "번 회원이 없습니다.");
//			}
//		});
//		return findUser;

		// 매개변수가 없는 경우 람다식으로 표현 가능
		// 검색된 회원이 없을 경우 예외를 리턴한다
		User findUser = userRepository.findById(id).orElseThrow(() -> {
			return new JBlogException(id + "번 회원이 없습니다.");
		});
		return findUser;
	}

	// 회원 수정
	@Transactional
	@PutMapping("/user")
	public @ResponseBody String updateUser(@RequestBody User user) {
		User findUser = userRepository.findById(user.getId()).orElseThrow(() -> {
			return new JBlogException(user.getId() + "번 회원이 없습니다.");
		});
		findUser.setUsername(user.getUsername());
		findUser.setPassword(user.getPassword());
		findUser.setEmail(user.getEmail());

//		userRepository.save(findUser);
		return "회원 수정 성공!";
	}

	// 회원 삭제
	@DeleteMapping("/user/{id}")
	public @ResponseBody String deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return "회원 삭제 성공";
	}

	// 목록 검색
	@GetMapping("/user/list")
	public @ResponseBody List<User> getUserList() {
		return userRepository.findAll();
	}

	// 페이징 처리
	@GetMapping("/user/page")
	public @ResponseBody Page<User> getUserListPaging(
	// page에 해당하는 2개의 데이터 조회
	// id와 username 내림차순 정렬
//		Pageable pageable = PageRequest.of(page, 2, Sort.Direction.DESC, "id", "username");

			@PageableDefault(page = 0, size = 2, direction = Sort.Direction.DESC, sort = { "id",
					"username" }) Pageable pageable) {
		// 첫번째 페이지(0)에 해당하는 2개의 데이터 조회
		// id 내림차순 정렬
		return userRepository.findAll(pageable);

	}

}
