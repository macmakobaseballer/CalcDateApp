package com.example.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.CalcDate;
import com.example.mapper.CalcMapper;

@Service
public class CalcService {
	
	@Autowired
	private CalcMapper calcMapper ;
	
	//一覧取得
	public List <CalcDate> getcalcAll(){
		return calcMapper.selectAll();
	}
	
	//計算ロジックの実行メソッド
	public List <CalcDate> getcalcResultAll(List <CalcDate> calcList ,LocalDate baseDate){
		
		//System.out.println(baseDate);
		
		List <CalcDate> calcResultAll = new  ArrayList<>() ;
				
		
		for( CalcDate calcDate : calcList ) {
			
			//計算実行
			LocalDate resultDate = baseDate.plusYears(calcDate.getCalcNumYear());
			resultDate = resultDate.plusMonths(calcDate.getCalcNumMonth());
			resultDate = resultDate.plusDays(calcDate.getCalcNumDay());
			
			//calcDatesetterでresultDateの値をセット
			calcDate.setResultDate(resultDate);		
		
			//ArrayListのcalcresultAllに計算後のcalcDateを格納
			calcResultAll.add(calcDate);
		
			//System.out.println(calcResultAll);
		}
		
		return calcResultAll;
				
	}
	
	//計算式の登録
	public void insertCalcOne(CalcDate calcDate) {
		calcMapper.insertCalcOne(calcDate);
	}
	
	//計算式の1件取得
	
	
	
	//計算式の更新
	public void updateCalcOne(CalcDate calcDate) {
		calcMapper.updateCalcOne(calcDate);
	}
	
	
}
