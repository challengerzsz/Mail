package com.bsb.works.config;

import com.bsb.works.common.SecurityConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: zeng
 * @Date: 2018/9/29 18:35
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                        SecurityConstants.LOGIN_PAGE,
                        SecurityConstants.DEFAULT_UNAUTHENTICATED_URL).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATED_URL)
                .and()
                .csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/js/**", "/css/**");
    }
}
