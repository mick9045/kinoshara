package ua.step.kino.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ua.step.kino.security.UserDetailsServiceImpl;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(
  prePostEnabled = true, 
  securedEnabled = true, 
  jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		 .antMatchers(
                 "/registration**",
                 "/forgot-password**",
                 "/reset-password**").permitAll()
			.antMatchers("/webjars/**").permitAll()
			.antMatchers("/scripts/**").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/login/**").permitAll()
			.antMatchers("/h2-console/**").permitAll()
			.anyRequest().permitAll()
		.and()
			.formLogin()
			.loginPage("/login")
			.failureUrl("/login?error")
			.permitAll()
		.and()
			.logout()
			.invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login?logout")
            .permitAll();
			
		
		//``````````````Only for testing to enable h2-console````````````````````
        http.csrf().disable();
        http.headers().frameOptions().disable();
        //```````````````````````````````````````````````````````````````
			//.antMatchers("/")

		
		//http.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
	}
	

	
	
}
