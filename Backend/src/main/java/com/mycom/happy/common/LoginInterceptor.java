package com.mycom.happy.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mycom.happy.dto.UserDto;

@Component
public class LoginInterceptor implements HandlerInterceptor{ // HandlerInterceptorAdapter 는 deprecated
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("Login Interceptor >>>>>>>>>  " + request.getRequestURI() );
		
		//async
		String async = request.getHeader("async");
		
        HttpSession session = request.getSession();
        UserDto userDto = (UserDto) session.getAttribute("userDto");
     // cors 에서 put, delete 대응
        if( request.getMethod().equals("OPTIONS")) return true;
        
        if( userDto == null ) {
        	
			Gson gson = new Gson(); 

			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("result", "login");
			
			String jsonStr = gson.toJson(jsonObject);
			response.getWriter().write(jsonStr);
        	
        	return false;
        }

        return true;
    }
}
