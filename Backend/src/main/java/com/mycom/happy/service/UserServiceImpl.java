package com.mycom.happy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.happy.dao.UserDao;
import com.mycom.happy.dto.UserDto;
import com.mycom.happy.dto.UserResultDto;
import com.mycom.happy.entity.Users;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public Optional<Users> detail(int userSeq) {
		// TODO Auto-generated method stub
		return userDao.findById(userSeq);
	}

	@Override
	public Users insert(Users user) {
		return userDao.save(user);
	}

	@Override
	public Users update(Users user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

	@Override
	public void delete(int userSeq) {
		userDao.deleteById(userSeq);
	}
}
