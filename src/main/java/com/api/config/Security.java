package com.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.api.filter.JwtFilter;
import com.api.service.CustomUserDetailService;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		//.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.csrf().disable()
		//.cors().disable()
		.cors()
		.and()
		.authorizeRequests()
		.antMatchers("/api/v*/login/**").permitAll()
		.antMatchers("/api/v*/register/**").permitAll()
		.antMatchers("/api/v*/test/**").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/testing/**").permitAll()
		//.antMatchers(HttpMethod.POST,"/api/v*/register/**").permitAll()
		//.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
		//.antMatchers("/api/v*/mqtt/**").hasRole("ADMIN")
		//.antMatchers("/api/v*/client/**").hasRole("USER")
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
		//auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
		//auth.inMemoryAuthentication().withUser("bholu").password(this.passwordEncoder().encode("1234")).roles("ADMIN");
		//auth.inMemoryAuthentication().withUser("bhai").password(this.passwordEncoder().encode("123")).roles("NORMAL");
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(bCryptPasswordEncoder);
		provider.setUserDetailsService(customUserDetailService);
		return provider;
	} 
}
