package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.CulcDate;
import com.example.service.CulcService;


@Controller
@RequestMapping("/culc")
public class CulcListController {
	
	@Autowired
	private CulcService culcService;
	
	@GetMapping("/list")
	public String getCulcList(Model model) {
		
		//計算一覧を取得
		List<CulcDate> culcList = culcService.getCulcAll();
		
		//Modelに登録
		model.addAttribute("culcList", culcList);
		
		//list.htmlを返す
		return "list";
	}


}
