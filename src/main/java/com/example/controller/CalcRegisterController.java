package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.DateFormula;
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
	public String postCalcRegist(@ModelAttribute @Validated CalcRegistForm form , 
								BindingResult bindingResult , Model model) {
		//入力チェック処理
		if(bindingResult.hasErrors()) {
			//NG:エラー表示処理
			return getCalcRegist(form);
		}
		
		//formをCalcDateクラスに変換		
		DateFormula dateFormula = modelMapper.map(form, DateFormula.class);
				
		//計算式の1件登録を実行
		calcService.registerFormula(dateFormula);
		
		return "redirect:";
	}
}
