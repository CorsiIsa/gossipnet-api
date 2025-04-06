package br.com.fiap.apigossipnet.user.dto;

import java.time.LocalDateTime;

import br.com.fiap.apigossipnet.user.User;

public record UserResponse (
        Long id,
        String name,
        String bio,
        String email,
        LocalDateTime createdAt
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getBio(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }
}
