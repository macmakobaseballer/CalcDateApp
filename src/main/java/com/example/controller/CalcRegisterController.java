package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.CalcDate;
import com.example.form.CalcRegistForm;
import com.example.service.CalcService;

@Controller
@RequestMapping("/calc")
public class CalcRegisterController {
	
	@Autowired
	CalcService calcService;
	
	@Autowired
	ModelMapper modelMapper;

	@GetMapping("/register")
	public String getCalcRegist(@ModelAttribute CalcRegistForm form) {
		return "calcregist" ;
	}
	
	@PostMapping("/register")
	public String postCalcRegist(@ModelAttribute CalcRegistForm form , Model model) {
		
		//formをCalcDateクラスに変換
		CalcDate calcDate = modelMapper.map(form, CalcDate.class);
				
		//計算式の1件登録を実行
		calcService.insertCalcOne(calcDate);
		
		return "redirect:/calc";
	}
}
