package com.mycom.happy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.happy.dto.UserDto;
import com.mycom.happy.service.LoginService;

@RestController
@CrossOrigin(
		// localhost:5500 과 127.0.0.1 구분
		origins = "http://localhost:5500", //allowCredentials = "true" 인 경우, origins="*" 는 X
		allowCredentials = "true",
		allowedHeaders = "*",
		methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.HEAD, RequestMethod.OPTIONS}
)
public class LoginController {

   @Autowired
   LoginService service;
   
   @PostMapping(value="/login")
   public ResponseEntity<Map<String, String>> login(@RequestBody UserDto dto, HttpSession session){
      
      UserDto userDto = service.login(dto);
      Map<String, String> map = new HashMap<>();
      if( userDto != null ) {
         session.setAttribute("userDto", userDto);
          map.put("result", "success"); // 성공 메세지
          map.put("userName", userDto.getUserName());
          map.put("userSeq", Integer.toString(userDto.getUserSeq()));
          map.put("userPassword", userDto.getUserPassword());
          map.put("userEmail", userDto.getUserEmail());
         return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
      }
      System.out.println(1);
      map.put("result", "fail");
      return new ResponseEntity<Map<String, String>>(map, HttpStatus.NOT_FOUND);
   }
   
   @GetMapping(value="/logout")
   public String logout(HttpSession session) {
       session.invalidate(); // server의 session 정리
       return "login.html"; // client의 sessionStorage 정리
   }
}
