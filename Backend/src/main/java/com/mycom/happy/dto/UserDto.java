package com.mycom.happy.dto;

import java.util.Date;

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
public class UserDto {
	private int userSeq;
	private String userName;
	private String userPassword;
	private String userEmail;
	private Date userRegisterDate;
}
