package com.group2.capstone.EBPaymentSystem;

import java.util.HashSet;
import java.util.Set;

import com.group2.capstone.EBPaymentSystem.authentication.models.Role;
import com.group2.capstone.EBPaymentSystem.authentication.models.User;
import com.group2.capstone.EBPaymentSystem.authentication.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.group2.capstone.EBPaymentSystem.authentication.repository.RoleRepository;

@SpringBootApplication
public class EBPaymentSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EBPaymentSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository,
            PasswordEncoder passwordEncode) {
        return args -> {
            if (roleRepository.findByAuthority("ADMIN").isPresent())
                return;
            Role adminRole = roleRepository.save(new Role("ADMIN"));
            roleRepository.save(new Role("USER"));
            roleRepository.save(new Role("DISTRICT_OFFICIAL"));

            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);

            User admin = new User(1, "admin", passwordEncode.encode("password"), roles);

            userRepository.save(admin);
        };
    }

}
