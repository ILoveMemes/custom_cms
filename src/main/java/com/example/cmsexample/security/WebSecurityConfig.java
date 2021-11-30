package com.example.cmsexample.security;

import com.example.cmsexample.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UsersDao usersDao;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").anonymous()
                .and().authorizeRequests().antMatchers(
                        "/admin", "/addresses/*", "/common/*", "/customers/*", "/history/*", "/licenses/*",
                                    "/messengers/*", "/partners/*", "/phones/*", "/requisites/*", "/services/*", "/pic/*", "/user/*").authenticated()
                .and().formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    };

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImp(usersDao);
    }

}
