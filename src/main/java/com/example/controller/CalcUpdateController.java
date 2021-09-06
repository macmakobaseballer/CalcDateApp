package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.CalcUpdateForm;
import com.example.service.CalcService;

@Controller
@RequestMapping("/calc")
public class CalcUpdateController {
	
	@Autowired
	CalcService calcService;
	
	@GetMapping("/update{resultId:.+}")
	public String getCalcUpdate(@ModelAttribute CalcUpdateForm form) {
		
		return "calcupdate";
		
	}
	
	
	
	
	
	
}
