package com.nt.Controller;

import com.nt.Dto.UserDto;
import com.nt.Entity.User;
import com.nt.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    public RestTemplate restTemplate;

    @PostMapping
    @RequestMapping("/message")
    public ResponseEntity<String> sendMessage(@RequestBody User user) {
        System.out.println("in sendMessage Method");
        userRepo.save(user);
        String consumerUrl = "http://localhost:8081/user/data";
        restTemplate.postForEntity(consumerUrl, user, String.class);

        return ResponseEntity.ok("message received successfully");
    }
}
