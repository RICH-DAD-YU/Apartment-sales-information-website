package com.mycom.happy.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.happy.dto.UserDto;

@Mapper
public interface LoginDao {
	public UserDto login(String userEmail);
}
