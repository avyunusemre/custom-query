package com.yunusky.customquery.controller;

import com.yunusky.customquery.dto.UserDto;
import com.yunusky.customquery.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/jpa/active")
    public List<UserDto> getActiveUsersJPA() {
        return userService.getActiveUsersJPA();
    }

    @GetMapping("/jpql/active")
    public List<UserDto> getActiveUsersJPQL() {
        return userService.getActiveUsersJPQL();
    }

    @GetMapping("/native/active")
    public List<UserDto> getActiveUsersNative() {
        return userService.getActiveUsersNative();
    }

    @GetMapping("/jpa/findByUsernameAndActive")
    public List<UserDto> getByUsernameAndActiveJPA(@RequestParam("username") String username) {
        return userService.getByUsernameAndActive(username);
    }

    @GetMapping("/jpql/findByUsernameAndActive")
    public List<UserDto> getByUsernameAndActiveJPQL(@RequestParam("username") String username) {
        return userService.getByUsernameAndActiveJPQL(username);
    }

    @GetMapping("/native/findByUsernameAndActive")
    public List<UserDto> getByUsernameAndActiveNative(@RequestParam("username") String username) {
        return userService.getByUsernameAndActiveNative(username);
    }
}
