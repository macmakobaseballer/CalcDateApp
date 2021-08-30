package com.example.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BaseDateForm {
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private LocalDate baseDate ;

}
