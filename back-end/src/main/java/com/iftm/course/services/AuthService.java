package com.iftm.course.services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.iftm.course.entities.User;
import com.iftm.course.repositories.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public User authenticate(User dto) throws Exception {
		try {
			
			User user = userRepository.findByEmail(dto.getEmail());
			if(user != null) {
				if(user.getPassword().equals(dto.getPassword())) {
					user.setLogado(true);
				}
			}
			return user;	
		} catch (Exception e) {
			throw new Exception(e);
		}
	}	
}
