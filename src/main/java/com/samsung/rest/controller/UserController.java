package com.samsung.rest.controller;

import com.samsung.domain.User;
import com.samsung.rest.dto.UserDto;
import com.samsung.service.UserService;
import com.samsung.view.UserView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public List<UserDto> getAllUser(){

        return userService
                .getAll()
                .stream()
                .map(UserDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/user")
    public UserDto insertUser(@RequestBody UserView userView){

        User user = userService.insert(
                userView.getLogin(),
                userView.getPassword(),
                userView.getTotalHours()
        );
        
        return UserDto.toDto(user);

    }

    @PutMapping("/user/{id}")
    public UserDto updateUser(
            @PathVariable int id,
            @RequestBody UserView userView
    ){

        User user = userService.update(
                id,
                userView.getLogin(),
                userView.getPassword(),
                userView.getTotalHours()
        );

        return UserDto.toDto(user);

    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){

        userService.deleteById(id);
    }

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable int id){

        User user = userService.getById(id);

        return UserDto.toDto(user);
    }

    @PostMapping("/user/{id}/login")
    public UserDto updateLoginById(
            @PathVariable int id,
            @RequestParam String login
    ) {

        return UserDto.toDto(
                userService.updateUserLoginById(id, login)
        );
    }

    @GetMapping("/user/login")
    public UserDto getUserByLogin(@RequestParam String login) {

        return UserDto.toDto(userService.getByLogin(login));
    }

}

