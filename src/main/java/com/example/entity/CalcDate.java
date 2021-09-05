package com.example.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class CalcDate {
	private String calcId;
	private int calcNumYear;
	private int calcNumMonth;
	private int calcNumDay;
	private int resultId;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private LocalDate resultDate;
}
