package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.CalcRegistForm;

@Controller
@RequestMapping("/calc")
public class CalcRegisterController {

	@GetMapping("/register")
	public String getCalcRegist(@ModelAttribute CalcRegistForm form) {
		return "calcregist" ;
	}
}
