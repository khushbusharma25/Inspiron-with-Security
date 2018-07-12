package com.sts.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource datasource;
	
	@Autowired
	public void confiAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(datasource)
			.usersByUsernameQuery("select user_name,password, enabled from users where user_name=?")
			.authoritiesByUsernameQuery("select user_name, role from users where user_name=?");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Security working...........................");
		 http
			.authorizeRequests()
				.antMatchers("/css", "/welcome").permitAll()
				.antMatchers("/user/**").access("hasRole('USER')")
				.antMatchers("/authenticate").access("hasRole('USER') or hasRole('ADMIN')")
				
				.antMatchers("/ad/**").access("hasRole('ADMIN')")
				.and()
				 .formLogin().loginPage("/login").failureUrl("/login?error")
				.usernameParameter("userName").passwordParameter("password")
				.and()
				  .logout().logoutSuccessUrl("/login?logout")
				.and()
				  .exceptionHandling().accessDeniedPage("/403")
				.and()
				  .csrf();
	}
	

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.inMemoryAuthentication()
//				.withUser("user").password("password").roles("USER")
//				.and()
//                .withUser("admin").password("password").roles("ADMIN");
//	}
}
