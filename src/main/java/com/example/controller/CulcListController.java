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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.CulcDate;
import com.example.form.BaseDateForm;
import com.example.service.CulcService;


@Controller
@RequestMapping("/culc")
public class CulcListController {
	
	@Autowired
	private CulcService culcService;
	
	@GetMapping("")
	public String getCulcList(@ModelAttribute BaseDateForm baseDateForm ,Model model) {
		
		//baseDateにデフォルトで値をセット
		baseDateForm.setBaseDate(LocalDate.now());
		
		//計算一覧を取得
		List<CulcDate> culcList = culcService.getCulcAll();
		
		//Modelに登録
		model.addAttribute("culcList", culcList);
		
		//list.htmlを返す
		return "list";
	}

	@PostMapping("/{baseDate}")
	@ResponseBody
	public String postCulcResult(  @DateTimeFormat(pattern="yyyy/MM/dd") @RequestBody BaseDateForm baseDateForm ,Model model) {
		
		
		//日付の加算メソッドを呼び出し
		LocalDate resultDate = culcService.culcDate(baseDateForm.getBaseDate());
		
		//Modelに登録
		model.addAttribute("resultDate", resultDate);

		//list.htmlを返す
		return "list";
	}
	
}
