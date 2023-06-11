package com.example.recipeswebsite.services;

import com.example.recipeswebsite.dto.UserDto;
import com.example.recipeswebsite.model.User;
import com.example.recipeswebsite.dto.UserDto;
import com.example.recipeswebsite.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}