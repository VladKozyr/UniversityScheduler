package com.kma.scheduler.universityscheduler.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("Admin")
                .password("admin")
                .roles("ADMIN")
        .and()
            .withUser("Student")
            .password("student")
            .roles("STUDENT")
        .and()
            .withUser("Manager")
            .password("manager")
            .roles("MANAGER");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/","/lector/all").permitAll()
                .antMatchers("/lector/**","/student/**", "/timeslot/**").hasAnyRole("ADMIN", "MANAGER")
                .and().httpBasic();
    }
}
