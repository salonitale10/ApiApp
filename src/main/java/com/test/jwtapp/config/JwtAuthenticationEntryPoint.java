package com.test.jwtapp.config;

import java.io.Serializable;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint,Serializable{

	private static final long serialVersionUID = -7858869558953243875L;
	
	
    public void commence(HttpServletRequest request, HttpServletResponse response,

                         AuthenticationException authException) throws IOException {

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");

    }
}
