package com.cg.ofda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ofda.dto.LoginDto;
import com.cg.ofda.service.ILoginServiceImpl;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	ILoginServiceImpl loginService;
	

	@PostMapping("/signin")
	public ResponseEntity<String> signIn(@Valid @RequestBody LoginDto login) {
		return new ResponseEntity<String>("Welcome  "+(loginService.signIn(login).getUserName()), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/viewuser/{userId}")
	public LoginDto viewUser(@PathVariable("userId") String userId) {
		return loginService.viewUser(userId);
	}
	@PostMapping("/signout")
	public boolean signOut() {
		return loginService.signOut() ;
		
	}
	
	
}
