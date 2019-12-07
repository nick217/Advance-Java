package com.practice.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

	//add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//tell spring-security to use JDBC authentication with our data source
		auth.jdbcAuthentication().dataSource(securityDataSource);
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
