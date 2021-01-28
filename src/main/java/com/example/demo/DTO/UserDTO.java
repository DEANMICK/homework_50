package com.example.demo.DTO;

import com.example.demo.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class UserDTO {
    private final String username;
    private final String email;
    private final String password;

    public static UserDTO getUser(User user) {
        return UserDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
