package com.ozanercan.cachedemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class CacheDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheDemoApplication.class, args);
    }
    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            userRepository.save(new User("Alice", "alice@example.com"));
            userRepository.save(new User("Bob", "bob@example.com"));
            userRepository.save(new User("Charlie", "charlie@example.com"));

            System.out.println("Initial users added:");
            userRepository.findAll().forEach(user ->
                    System.out.println(user.getId() + " - " + user.getName() + " - " + user.getEmail())
            );
        };
    }
}
