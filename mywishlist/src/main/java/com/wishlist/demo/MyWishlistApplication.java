package com.wishlist.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.wishlist.demo.repository") // Ensure repository scanning
public class MyWishlistApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyWishlistApplication.class, args);
    }
}
