package com.example.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class CulcDate {
	private String culcId;
	private int culcNumYear;
	private int culcNumMonth;
	private int culcNumDay;
	private int resultId;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private LocalDate resultDate;
}
