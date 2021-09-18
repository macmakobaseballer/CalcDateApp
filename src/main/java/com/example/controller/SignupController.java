package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
    /**ユーザー更新処理**/
    @PostMapping("/signup")
    public String postSignup(Model model,
            @ModelAttribute @Validated SignupForm form,
            BindingResult bindingResult) {

        // 入力チェック結果
        if (bindingResult.hasErrors()) {
            // NG:ユーザー登録画面に戻ります
            return getSignup(form);
        }

//        log.info(form.toString());
//
//        // formをMUserクラスに変換
//        MUser user = modelMapper.map(form, MUser.class);
//
//        // ユーザー登録
//        userService.signup(user);

        // ログイン画面にリダイレクト
        return "redirect:/login";
        
    	}
}
	