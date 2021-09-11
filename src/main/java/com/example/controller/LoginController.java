package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class LoginController {
   
	// ログイン画面を表示 
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    // ホーム画面にリダイレクト 
    @PostMapping("/login")
    public String postLogin() {
        return "redirect:/calc/list";
    }
}


