package com.jwt.api.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("login")
    public Optional<User> login(@Valid @RequestBody UserLoginDTO userLoginDTO)
    {
        return this.userService.login(userLoginDTO.getEmail());
    }
    @PostMapping("register")
    public User register(@RequestBody User user)
    {
        return this.userService.register(user);
    }
}
