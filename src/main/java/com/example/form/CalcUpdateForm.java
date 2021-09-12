package com.example.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CalcUpdateForm {
	
	@NotBlank
	private String calcId;
	
	@Max(999)
	@Min(-999)
	private int calcNumYear;
	
	@Max(999)
	@Min(-999)
	private int calcNumMonth;
	
	@Max(999)
	@Min(-999)
	private int calcNumDay;
	
	
	private int resultId;
}
