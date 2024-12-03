package com.myProject.RestaurantProject.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CustomeFilterSecurity {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.cors().disable()
			.csrf().disable()
			.authorizeHttpRequests()
			.requestMatchers("/login/**")
			.permitAll();
		return http.build();
	}
}
