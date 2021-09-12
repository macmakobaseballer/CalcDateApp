package com.example.form;


import java.time.LocalDate;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@SuppressWarnings("deprecation")
@Data
public class BaseDateForm {
	
	@NotBlank
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private LocalDate baseDate ;

}
