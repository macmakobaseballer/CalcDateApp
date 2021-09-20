package com.example.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.example.form.BaseDateForm;
import com.example.service.CalcService;


@Controller
@RequestMapping("/calc")
public class CalcListController {
	
	@Autowired
	private CalcService calcService;
	
	@GetMapping
	public String getCalcList(@ModelAttribute BaseDateForm form ,Model model) {
		
		//baseDateにデフォルトで値をセット
		form.setBaseDate(LocalDate.now());
		
		//計算式の一覧を取得し、配列を定義
		List<DateFormula> calcList = calcService.getFormulas();
		
		//Modelに登録
		model.addAttribute("calcList", calcList);
		
		//list.htmlを返す
		return "list";
	}

	@PostMapping
	public String postCalcResult( @DateTimeFormat(pattern="yyyy/MM/dd") @ModelAttribute @Validated BaseDateForm form ,
										BindingResult bindingResult,Model model	) {
		System.out.println(bindingResult.hasErrors());
		//入力チェック処理
		if(bindingResult.hasErrors()) {
			
			//NGの場合：list.htmlに戻る
			return getCalcList(form, model);
		}
		

		//計算一覧を取得
		List<DateFormula> calcList = calcService.getFormulas();
		
		//calculateメソッドを実行し、計算基準日を元に計算実行
		calcList = calcService.calculate(calcList,form.getBaseDate());
		
		//Modelに登録
		model.addAttribute("calcList", calcList);

		//ダイレクト
		return "list";
	}
	
	@PostMapping("/delete/{resultId:.+}")
	public String postDelete(@PathVariable("resultId") int resultId) {
		
		//1件削除を実装
		calcService.deleteFormula(resultId);

		//リダイレクト処理
		return"redirect:/calc";
	}
	
}
