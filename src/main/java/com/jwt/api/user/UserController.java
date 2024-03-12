package com.jwt.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> Home()
    {
        return this.userService.getUsers();
    }
    @PostMapping("register")
    public User register(@RequestBody User user)
    {
        return this.userService.register(user);
    }
}
