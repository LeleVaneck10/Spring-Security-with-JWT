package com.jwtCourse.userservice;

import com.jwtCourse.userservice.domain.Role;
import com.jwtCourse.userservice.domain.User;
import com.jwtCourse.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService){
		return  args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"Lele Tokam", "lele","1234", new ArrayList<>()));
			userService.saveUser(new User(null,"Vaneck Auriol", "vaneck","1234", new ArrayList<>()));
			userService.saveUser(new User(null,"Lele Simo", "simo","1234", new ArrayList<>()));
			userService.saveUser(new User(null,"Tyrold Moreau", "tyrold","1234", new ArrayList<>()));

			userService.addRoleToUser("lele","ROLE_USER");
			userService.addRoleToUser("lele","ROLE_MANAGER");
			userService.addRoleToUser("vaneck","ROLE_MANAGER");
			userService.addRoleToUser("simo","ROLE_ADMIN");
			userService.addRoleToUser("tyrold","ROLE_SUPER_ADMIN");
		};
	}
}
