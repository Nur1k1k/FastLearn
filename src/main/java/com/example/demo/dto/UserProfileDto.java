package com.example.demo.dto;

public record UserProfileDto(
        String username,
        int points,
        String profilePictureUrl,
        String role
) {}
