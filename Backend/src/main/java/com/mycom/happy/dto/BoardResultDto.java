package com.mycom.happy.dto;

import java.util.List;

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
public class BoardResultDto {
	private int result;
	private BoardDto dto;
	private List<BoardDto> list;
	private int count;
	
}
