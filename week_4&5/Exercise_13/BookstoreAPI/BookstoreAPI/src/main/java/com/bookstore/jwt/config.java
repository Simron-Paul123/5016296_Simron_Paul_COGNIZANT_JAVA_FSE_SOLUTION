package com.bookstore.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
public class config{
    @Bean
    PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
		
	}
	@Bean
	UserDetailsService userdetailservice() {
		UserDetails adminUser=  User.builder().username("admin").password(passwordencoder().encode("admin")).roles("admin").build();
		UserDetails normalUser=  User.builder().username("customer").password(passwordencoder().encode("user")).roles("customer").build();
		return new InMemoryUserDetailsManager( adminUser,normalUser);
	}

    @Bean
    AuthenticationManager authentication(AuthenticationConfiguration configuration) throws Exception{
		return  configuration.getAuthenticationManager();
	}
}