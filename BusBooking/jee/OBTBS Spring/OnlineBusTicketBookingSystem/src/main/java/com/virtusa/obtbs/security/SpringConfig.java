package com.virtusa.obtbs.security;
	import org.springframework.context.annotation.Bean;
	import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder; 
	import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; 
	import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; 
	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
	import org.springframework.security.crypto.password.PasswordEncoder;
	@EnableWebSecurity
	public class SpringConfig extends WebSecurityConfigurerAdapter{
		@Override protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
			// TODO Auto-generated method stub
			auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("user")).roles("admin") .and().withUser("sai").password(passwordEncoder().encode("sai")).roles("user"); 
			
		}
		@Override protected void configure(HttpSecurity http) throws Exception { 
			// TODO Auto-generated method stub 
			http.authorizeRequests().antMatchers("/rest/getcustomers").hasRole("admin").anyRequest().authenticated() .and().httpBasic(); http.csrf().disable();
			// only get http methhods...
			}
		@Bean PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
			}
		
	}
	
	
	
	
	

