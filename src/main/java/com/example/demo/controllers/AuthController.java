package com.example.demo.controllers;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login")
    public String loginForm() {
        return "login"; // Возвращаем имя HTML-шаблона для страницы логина
    }

    @PostMapping("/login")
    public String login(@ModelAttribute AuthRequest request, Model model) {
        try {
            AuthResponse response = authService.authenticate(request);
            model.addAttribute("token", response.getToken());
            return "redirect:/profile"; // Перенаправление на страницу профиля
        } catch (BadCredentialsException e) {
            model.addAttribute("error", "Неверный логин или пароль"); // Добавляем ошибку в модель
            return "login"; // Возвращаем страницу логина при ошибке
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка авторизации"); // Общая ошибка
            return "login"; // Возвращаем страницу логина при общей ошибке
        }
    }


    @GetMapping("/register")
    public String registerForm() {
        return "register"; // Возвращаем страницу регистрации
    }

    @PostMapping("/register")
    public String register(@ModelAttribute AuthRequest request, Model model) {
        authService.register(request);
        return "redirect:/auth/login"; // Перенаправление на страницу логина после успешной регистрации
    }
}
