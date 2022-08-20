package org.example.authorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.formLogin()
                //登录请求的url，否则不会走认证相关的逻辑（UserDetailsServiceImpl）
                .loginProcessingUrl("/login")
                .loginPage("/login.html")
                //登录成功之后的请求方式必须是post
                .successForwardUrl("/toMain");

        //任何请求都需要进行认证
        http.authorizeRequests()
                //登录页面不需要认证
                .antMatchers("/login.html").permitAll()
                .anyRequest().authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
