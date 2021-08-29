package com.example.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CulcDate {
	private String culcId;
	private int culcNumYear;
	private int culcNumMonth;
	private int culcNumDate;
	private int resultId;
	private LocalDate resultDate;
}
