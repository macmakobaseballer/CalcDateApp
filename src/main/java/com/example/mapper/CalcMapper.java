package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.CalcDate;


@Mapper
public interface CalcMapper {
	
	//全件取得
	public List <CalcDate> selectAll();

}