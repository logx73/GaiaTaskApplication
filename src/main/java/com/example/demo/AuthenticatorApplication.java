package com.example.demo;

import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class AuthenticatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticatorApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository user, RoleRepository role, PasswordEncoder passwordEncoder){
		return args -> {
			Role role1 = new Role();
			role1.setName("ROLE_SUPERADMIN");
			role1.setRoleId(10L);
			role1.setCreatedAt(LocalDate.now());
			role1.setUpdatedAt(LocalDate.now());

			User user1 = new User();
			user1.setUserId(1L);
			user1.setRole(role1);
			user1.setUsername("Lucky");
			user1.setPassword(passwordEncoder.encode("logx"));
			user1.setMobileNo("9860948870");
			user1.setEmail("lokesh.gadiya73@gmail.com");
			user1.setCreatedAt(LocalDate.now());
			user1.setUpdatedAt(LocalDate.now());
			user1.setFirstName("Lokesh");
			user1.setLastName("Gadiya");
			user.save(user1);
		};
	};

}
