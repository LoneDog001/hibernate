package com.example.hibernate.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Andrey")
                .password(passwordEncoder().encode("qwerty"))
                .roles("READ")
                .and()
                .withUser("Sergey")
                .password(passwordEncoder().encode("asdfgh"))
                .roles("WRITE")
                .and()
                .withUser("Irina")
                .password(passwordEncoder().encode("zxcvbn"))
                .roles("DELETE");
    }

   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeHttpRequests().antMatchers("/by-city").hasAuthority("write")
                .and()
                .authorizeHttpRequests().antMatchers("/by-age").hasAuthority("read")
                .and()
                .authorizeHttpRequests().antMatchers("/by-name-and-surname").permitAll();
    }*/
}
