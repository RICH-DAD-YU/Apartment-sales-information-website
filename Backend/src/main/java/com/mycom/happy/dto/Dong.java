package com.mycom.happy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dong {
	
	private String code;
	private String name;
	private String city_code;
	private String city_name;
	private String gugun_code;
	private String gugun_name;
	
}
