package com.practice.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// add our users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();  //deprecated, but used only for demo so Ok!

		auth.inMemoryAuthentication()
				.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
				.withUser(users.username("mary").password("test123").roles("EMPLOYEE","MANAGER"))
				.withUser(users.username("susan").password("test123").roles("EMPLOYEE","ADMIN"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// configure security of web paths in application login, logout etc.

		http.authorizeRequests()	//Restrict access based on the HttpServletRequest
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.and()
			.formLogin()	//enabling custom login form
				.loginPage("/showMyLoginPage")	//the login form page
				.loginProcessingUrl("/authenticateTheUser")	//login params will be submitted to this page for processing.
															//spring-security will handle this submission path automatically.
															//Developer does not have to write any code for authenticating the user.
				.permitAll() 	//This will allow everybody to see login form without any authentication.
				.and()
				.logout().permitAll() 	//Adding logout support for this app.
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
	}

}
