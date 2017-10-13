package com.vcooline.crm.admin

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtLoginFilter extends AbstractAuthenticationProcessingFilter{

    JwtLoginFilter(AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher("/api/login"))
        setAuthenticationManager(authenticationManager)
    }

    @Override
    Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        return null
    }
}
