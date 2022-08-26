package com.mycom.happy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// jpa 를 위한 db table과 key

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(
		name="users",
		uniqueConstraints = {
				@UniqueConstraint(name="UK_STUDENT_EMAIL", columnNames="userEmail")
		}
)
public class Users { 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // auto increment 이므로 (자동 증가하는 컬럼)
	@Column
	private int userSeq; // 기본 key 값
	
	private String userPassword;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="userEmail", length=500)
	private String userEmail;
	
	@Column(name="userRegisterDate")
	private Date userRegisterDate;
}


