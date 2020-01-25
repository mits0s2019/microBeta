package com.example.moviesclient.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutSuccess implements LogoutSuccessHandler {

//    @Value("${auth-server}/exit")
//    private String logoutUrl;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        httpServletResponse.setHeader("referer",httpServletRequest.getRequestURL().toString());
        httpServletResponse.sendRedirect("http://localhost:8090/auth/exit");
    }
}