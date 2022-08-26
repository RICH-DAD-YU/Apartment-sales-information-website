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
public class HouseInfo {
	
	private int no;
	private String dong;
	private String AptName;
	private String buildYear;
	private String lat;
	private String lng;
}
