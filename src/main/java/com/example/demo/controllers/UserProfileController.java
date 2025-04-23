package com.example.demo.controllers;

import com.example.demo.dto.UserProfileDto;
import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserRepository userRepository;

    @GetMapping
    public String getProfile(Authentication auth, Model model) {
        String username = auth.getName();
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new IllegalArgumentException("Пользователь не найден"));

        var dto = new UserProfileDto(
                user.getUsername(),
                user.getPoints(),
                user.getProfilePictureUrl(),
                user.getRole().name()
        );

        model.addAttribute("user", dto);
        return "profile";
    }


}
