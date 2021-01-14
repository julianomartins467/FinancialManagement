package com.iftm.course.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.iftm.course.entities.User;
import com.iftm.course.services.AuthService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	@Autowired
	private AuthService service;

	@PostMapping(value = "/login")
	public ResponseEntity<User> login(@RequestBody User dto) throws Exception  {
		User user  = service.authenticate(dto);			
		return ResponseEntity.ok().body(user);
	}

}

