package com.sharda.UserService.service;

import com.sharda.UserService.Dto.UserDto;
import com.sharda.UserService.exception.UserHandledException;
import com.sharda.UserService.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    User saveUser(UserDto userDto) throws UserHandledException;
    UserDto getUser(String userId) throws UserHandledException;
    List<User> getAllUser() throws UserHandledException;
    User updateUser(User user) throws UserHandledException;
    String deleteUser(String userId) throws UserHandledException;
    List<User> getUsersByName(String name) throws UserHandledException;

    String uploadFile(MultipartFile file);
}
