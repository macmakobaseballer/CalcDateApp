package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.CulcDate;


@Mapper
public interface CulcMapper {
	
	//全件取得
	public List <CulcDate> selectAll();

}
