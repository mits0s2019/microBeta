package com.example.moviesclient.config;


import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableOAuth2Sso
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login","/**","/register","/css/**", "/js/**","/img/**","/discover/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .clearAuthentication(true)
                .deleteCookies()
                .invalidateHttpSession(true)
                .logoutSuccessHandler(new LogoutSuccess())
                .permitAll()
                .and().csrf().disable();

    }
}