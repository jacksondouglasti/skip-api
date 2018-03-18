//package com.skip.api.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.skip.api.domain.User;
//import com.skip.api.repositories.UserRepository;
//
//@Configuration
//@Profile(value = "dev")
//public class DevConfig {
//
//	@Autowired
//	private UserRepository repository;
//	
//	@Bean
//	public boolean initialize() {
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
//		
//		User user = new User(null, "Jackson", "jacksondouglasti@gmail.com", bCryptPasswordEncoder.encode("123"));
//		repository.save(user);
//		return true;
//	}
//}
