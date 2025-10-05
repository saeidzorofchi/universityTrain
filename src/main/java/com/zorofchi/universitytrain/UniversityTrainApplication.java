package com.zorofchi.universitytrain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UniversityTrainApplication {

    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder().encode("admin"));

        SpringApplication.run(UniversityTrainApplication.class, args);
    }

}
