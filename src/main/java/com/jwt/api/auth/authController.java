package com.jwt.api.auth;

import com.jwt.api.user.User;
import com.jwt.api.user.UserLoginDTO;
import com.jwt.api.user.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class authController {
    private final UserService userService;

    public authController(UserService userService) {
        this.userService = userService;
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
