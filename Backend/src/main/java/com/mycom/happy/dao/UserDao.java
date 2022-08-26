package com.mycom.happy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mycom.happy.entity.Users;

@Mapper
public interface UserDao extends JpaRepository<Users, Integer> {

	
}
