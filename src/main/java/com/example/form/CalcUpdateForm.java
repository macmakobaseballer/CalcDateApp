package com.example.form;

import lombok.Data;

@Data
public class CalcUpdateForm {
	private String calcId;
	private int calcNumYear;
	private int calcNumMonth;
	private int calcNumDay;
	private int resultId;
}
