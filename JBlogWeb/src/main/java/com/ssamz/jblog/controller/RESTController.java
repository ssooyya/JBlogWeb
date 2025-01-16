package com.ssamz.jblog.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

	// GET : SELECT
	@GetMapping("/jblog")
	public String httpGet() {
		return "GET 요청 처리";
	}
	
	// POST : INSERT
	@PostMapping("/jblog")
	public String httpPost() {
		return "POST 요청 처리";
	}
	
	// PUT : UPDATE
	@PutMapping("/jblog")
	public String httpPut() {
		return "PUT 요청 처리";
	}
	
	// DELETE : DELETE
	@DeleteMapping("/jblog")
	public String httpDelete() {
		return "DELETE 요청 처리";
	}
}
