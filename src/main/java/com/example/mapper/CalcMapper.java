package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.CalcDate;


@Mapper
public interface CalcMapper {
	
	//全件取得
	public List <CalcDate> selectAll();

	//計算式1件登録
	public void insertCalcOne(CalcDate calcDate);
	
	//計算式1件取得
	public CalcDate selectOne(int resultId);
	
	//計算式1件更新
	public void updateCalcOne(CalcDate calcDate);
	
	//計算式1件削除
	public void deleteCalcOne(int resultId);
}
