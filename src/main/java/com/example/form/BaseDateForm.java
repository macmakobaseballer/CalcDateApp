package com.example.form;


import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;



@Data
public class BaseDateForm {
	
	@NotNull
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private LocalDate baseDate ;

}
