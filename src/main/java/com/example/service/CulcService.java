package com.example.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.CulcDate;
import com.example.mapper.CulcMapper;

@Service
public class CulcService {
	
	@Autowired
	private CulcMapper culcMapper ;
	
	public List <CulcDate> getCulcAll(){
		return culcMapper.selectAll();
	}
	
	public LocalDate culcDate (LocalDate baseDate) {
		
		LocalDate resultDate = baseDate.plusYears(1);
		resultDate = baseDate.plusMonths(1);
		resultDate = baseDate.plusDays(0);
		
		return resultDate;
				
		
	}
	
}
