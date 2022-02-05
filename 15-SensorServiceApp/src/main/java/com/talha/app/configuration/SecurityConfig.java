package com.talha.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        var user = User.withDefaultPasswordEncoder()
                .username("talha")
                .password("1234")
                .roles("ADMIN")
                .build();

        auth.inMemoryAuthentication().withUser(user);
    }


}
