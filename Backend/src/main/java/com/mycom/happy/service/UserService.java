package com.mycom.happy.service;

import java.util.Optional;

import com.mycom.happy.entity.Users;

public interface UserService {
	Optional<Users> detail(int userSeq);
	Users insert(Users user); //등록
	Users update(Users user); //조회
	void delete(int userSeq); //삭제
}
