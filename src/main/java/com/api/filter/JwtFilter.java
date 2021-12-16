package com.api.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.api.service.CustomUserDetailService;
import com.api.utility.JwtUtility;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtility jwtUtility;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
        String requestTokenHeader = request.getHeader("Authorization");//Authentication
        String userName = null;
        String jwtToken = null;
        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
      	  jwtToken = requestTokenHeader.substring(7);
      	  try {
      		userName = this.jwtUtility.getUsernameFromToken(jwtToken);
      	  }catch(Exception e) {
      		  e.printStackTrace();
      	  }
      	  UserDetails userDetails = this.customUserDetailService.loadUserByUsername(userName);
      	  if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      		  UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
      		  usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
      		  SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
      		  
      	  }else {
      		  System.out.println("Token is not validated");
      	  }
        }
		filterChain.doFilter(request, response);
    }
}
