package com.sharda.UserService.controller;

import com.sharda.UserService.exception.UserHandledException;
import com.sharda.UserService.repo.UserRepository;
import com.sharda.UserService.Dto.UserDto;
import com.sharda.UserService.model.User;
import com.sharda.UserService.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;
    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody UserDto user) throws UserHandledException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable String userId) throws UserHandledException {
        log.info("get user with id: {}", userId);
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(userId));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() throws UserHandledException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<User>> getAllUsersByName(@PathVariable String name) throws UserHandledException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsersByName(name));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) throws UserHandledException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user));
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) throws UserHandledException {
        return userService.deleteUser(userId);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(MultipartFile file) {
        return new ResponseEntity<>(userService.uploadFile(file), HttpStatus.CREATED);
    }

    @GetMapping("/send/{message}")
    public void sendMessageToQueue(@PathVariable String message) {
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(message).build());
    }

}
