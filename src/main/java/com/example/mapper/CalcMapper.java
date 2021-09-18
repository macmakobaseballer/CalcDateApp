package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.DateFormula;


@Mapper
public interface CalcMapper {
	
	//全件取得
	public List <DateFormula> selectFormulas();

	//計算式1件登録
	public void insertFormula(DateFormula dateFormula);
	
	//計算式1件取得
	public DateFormula selectFormula(int resultId);
	
	//計算式1件更新
	public void updateFormula(DateFormula dateFormula);
	
	//計算式1件削除
	public void deleteFormula(int resultId);
}
