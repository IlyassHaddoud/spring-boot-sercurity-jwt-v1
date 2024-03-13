package com.jwt.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers()
    {
        return this.userService.getUsers();
    }

    @GetMapping("/msg")
    public ResponseEntity<String> Home(Authentication authentication)
    {
        String username = (String) authentication.getPrincipal();
        return ResponseEntity.ok().body("Hello "+username+", Welcome to the VIP [room💎💵], you have "+authentication.getAuthorities()+" powers💪🔥");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> adminPage()
    {
        return ResponseEntity.ok().body("you are in admin page 🔐");
    }

    @GetMapping("/public")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN') or hasAuthority('SUPPLIER')")
    public ResponseEntity<String> publicPage()
    {
        return ResponseEntity.ok().body("you are in the public page 🚦🚗");
    }

    @GetMapping("/{user_id}/roles/{role_id}")
    public User addRoleToUser(@PathVariable Integer user_id,@PathVariable Integer role_id)
    {
        return this.userService.addRoleToUser(user_id,role_id);
    }

}
