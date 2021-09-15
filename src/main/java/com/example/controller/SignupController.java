package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.SignupForm;

@Controller
@RequestMapping("/user")
public class SignupController {
   
	
	/** ユーザー登録画面を表示 */
    @GetMapping("/signup")
    public String getSignup(@ModelAttribute SignupForm form) {

        // ユーザー登録画面に遷移
        return "signup";
    }
	
}
