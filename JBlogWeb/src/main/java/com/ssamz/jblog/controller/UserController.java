package com.ssamz.jblog.controller;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssamz.jblog.domain.User;
import com.ssamz.jblog.dto.ResponseDTO;
import com.ssamz.jblog.dto.UserDTO;
import com.ssamz.jblog.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/auth/insertUser")
	public String insertUser() {
		return "user/insertUser";
	}

	@PostMapping("/auth/insertUser")
	public @ResponseBody ResponseDTO<?> insertUser(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) {
//		userService.insertUser(user);
//		return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "님 회원가입 성공!");

		// USERDTO 객체에 대한 유효성 검사
		// ValidationCheckAdvice 컨트롤러를 작성함으로써 작성할 필요가 없어짐
//		if (bindingResult.hasErrors()) {
//			// 에러가 하나라도 있다면 에러 메시지를 Map에 등록
//			Map<String, String> errorMap = new HashMap<>();
//			for (FieldError error : bindingResult.getFieldErrors()) {
//				errorMap.put(error.getField(), error.getDefaultMessage());
//			}
//			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), errorMap);
//		}
		// UserDTO -> User객체로 변환
		User user = modelMapper.map(userDTO, User.class);
		User findUser = userService.getUser(user.getUsername());

		if (findUser.getUsername() == null) {
			userService.insertUser(user);
			return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "님 가입 성공!!");
		} else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), user.getUsername() + "님은 이미 회원입니다!");
		}

	}
}
