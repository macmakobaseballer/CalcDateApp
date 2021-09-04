package com.example.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.CulcDate;
import com.example.form.BaseDateForm;
import com.example.service.CulcService;


@Controller
@RequestMapping("/culc")
public class CulcListController {
	
	@Autowired
	private CulcService culcService;
	
	@GetMapping
	public String getCulcList(@ModelAttribute BaseDateForm form ,Model model) {
		
		//baseDateにデフォルトで値をセット
		form.setBaseDate(LocalDate.now());
		
		//計算一覧を取得
		List<CulcDate> culcList = culcService.getCulcAll();
		
		//Modelに登録
		model.addAttribute("culcList", culcList);
		
		//list.htmlを返す
		return "list";
	}

	@PostMapping
	public String postCulcResult(  @DateTimeFormat(pattern="yyyy/MM/dd") @ModelAttribute BaseDateForm form ,Model model) {
		
		
		System.out.println(form);
		
		
		//計算一覧を取得
		List<CulcDate> culcList = culcService.getCulcAll();
		
		//getCulc
		culcList = culcService.getCulcResultAll(culcList,form.getBaseDate());
		
		
		System.out.println(culcList);
		
		//Modelに登録
		model.addAttribute("culcList", culcList);

		//list.htmlを返す
		return "list";
	}
	
}
