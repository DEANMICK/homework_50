package com.example.demo.Controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/register")
    public UserDTO addUser(@RequestParam("username") String username, @RequestParam("email") String email,
                        @RequestParam("password") String password) {
        return UserDTO.getUser(userService.saveUser(username, email, password));
    }

    @GetMapping("/login")
    public UserDTO loginUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        return UserDTO.getUser(userService.login(username, password));
    }
}
