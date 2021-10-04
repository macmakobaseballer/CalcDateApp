package com.example.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.DateFormula;
import com.example.mapper.CalcMapper;

@Service
public class CalcService {
	
	@Autowired
	private CalcMapper calcMapper ;
	
	//一覧取得
	public List <DateFormula> getFormulas(){
		return calcMapper.selectFormulas();
	}
	
	//計算の実行メソッド
	public List <DateFormula> calculate(List <DateFormula> calcList ,LocalDate baseDate){
		
		//System.out.println(baseDate);
		//結果を入れるArrayListを定義
		List <DateFormula> calcResults = new  ArrayList<>() ;
				
		
		for( DateFormula dateFormula : calcList ) {
			
			//計算実行
			LocalDate resultDate = 
				baseDate.plusYears(dateFormula.getCalcNumYear())
						.plusMonths(dateFormula.getCalcNumMonth())
						.plusDays(dateFormula.getCalcNumDay());
			
			//calcDatesetterでresultDateの値をセット
			dateFormula.setResultDate(resultDate);		
		
			//ArrayListのcalcresultAllに計算後のcalcDateを格納
			calcResults.add(dateFormula);
		
			//System.out.println(calcResultAll);
		}
		
		return calcResults;
				
	}
	
	//計算式の登録
	public void registerFormula (DateFormula dateFormula) {
		calcMapper.insertFormula(dateFormula);
	}
	
	//計算式の1件取得
	public DateFormula getFormula(int resultId){
		return calcMapper.selectFormula(resultId);
	}
	
	
	//計算式の1件更新
	public void updateFormula(DateFormula dateFormula) {
		calcMapper.updateFormula(dateFormula);
	}
	
	//計算式の1件削除
	public void deleteFormula(int resultId) {
		calcMapper.deleteFormula(resultId);
	}
	
}
