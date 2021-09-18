package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.DateFormula;
import com.example.form.CalcUpdateForm;
import com.example.service.CalcService;

@Controller
@RequestMapping("/calc")
public class CalcUpdateController {
	
	@Autowired
	CalcService calcService;
	
	@Autowired
	ModelMapper modelMapper;

	
	@GetMapping("/update/{resultId:.+}")
	public String getCalcUpdate(@ModelAttribute CalcUpdateForm form, Model model,@PathVariable("resultId") int resultId) {
		
		//1件検索メソッドの実行
		DateFormula dateFormula = calcService.getFormula(resultId);
		
		//CalcDateをformに変換
		form = modelMapper.map(dateFormula, CalcUpdateForm.class);
		
		//modelに登録
		model.addAttribute("calcUpdateForm", form);
		
		//System.out.println(form);
		
		return "calcupdate";
		
	}
	
	@PostMapping("/update/{resultId:.+}")
	public String postCalcUpdate(@ModelAttribute @Validated CalcUpdateForm form,
								 BindingResult bindingResult ,Model model) {
		
		//入力チェック処理
		if(bindingResult.hasErrors()) {
			
			return "calcupdate" ;
			
		}
		
		//formをCalcDateクラスに変換
		DateFormula dateFormula = modelMapper.map(form, DateFormula.class);
		
		//1件更新処理
		calcService.updateFormula(dateFormula);
		
		System.out.println(dateFormula);
	
	//トップページへリダイレクト	
	return "redirect:/calc";
		
	}
	
	
	
	
	
}
