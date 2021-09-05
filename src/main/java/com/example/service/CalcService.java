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
	
	public List <CalcDate> getcalcAll(){
		return calcMapper.selectAll();
	}
	
	public List <CalcDate> getcalcResultAll(List <CalcDate> calcList ,LocalDate baseDate){
		
		//System.out.println(baseDate);
		/*
		LocalDate resultDate = baseDate.plusYears(1);
		resultDate = resultDate.plusMonths(1);
		resultDate = resultDate.plusDays(0);
		*/
		
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
	
}
