package com.example.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String home() {
        return "main";
    }

    @GetMapping("alphabet.html")
    public String alphabet() {
        return "alphabet";
    }

    @GetMapping("vocabulary.html")
    public String vocabulary() {
        return "vocabulary";
    }

    @GetMapping("test.html")
    public String test() {
        return "test";
    }

    @GetMapping("topic.html")
    public String topic() {
        return "topic";
    }
}
