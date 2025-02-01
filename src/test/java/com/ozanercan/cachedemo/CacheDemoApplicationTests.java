package com.ozanercan.cachedemo;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CacheDemoApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    CacheManager cacheManager;


    @Test
    void contextLoads() {
    }

    @Test
    @Order(1)
    void getUserWithId1() {
        Optional<User> user = userService.getUserById(1L);
        assertTrue(user.isPresent());

        Cache cache = cacheManager.getCache("users");
        assertNotNull(cache.get(1L));
    }

    @Test
    @Order(2)
    void getUserWithId1AndUpdateIt() {
        Optional<User> user = userService.getUserById(1L);
        user.ifPresent(value -> System.out.println("before update :" + value));

        User newUser = new User("ozan","ozanercan@gmail.com");
        userService.updateUser(1L, newUser);

        Optional<User> user2 = userService.getUserById(1L);
        user2.ifPresent(value -> System.out.println("after update :" + value));

        Cache cache = cacheManager.getCache("users");
        assertNotNull(cache.get(1L));

        user2.ifPresent(value -> assertEquals("ozanercan@gmail.com", value.getEmail()));
    }

    @Test
    @Order(3)
    void getUserWithId1AndDeleteIt() {
        Optional<User> user = userService.getUserById(1L);
        user.ifPresent(value -> System.out.println("before update :" + value));

        userService.deleteUser(1L);

        Optional<User> user2 = userService.getUserById(1L);
        user2.ifPresent(value -> System.out.println("after update :" + value));

        assertFalse(user2.isPresent());
    }

}
