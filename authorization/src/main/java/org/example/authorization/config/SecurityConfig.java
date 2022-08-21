package org.example.authorization.config;

import org.example.authorization.handler.MyAuthenticationFailureHandler;
import org.example.authorization.handler.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
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
                //自定义登录时的参数名
//                .usernameParameter("username123")
//                .passwordParameter("password123")
                //登录请求的url，否则不会走认证相关的逻辑（UserDetailsServiceImpl）
                .loginProcessingUrl("/login")
                .loginPage("/login.html")
                //登录成功之后的请求方式必须是post
//                .successHandler(new MyAuthenticationSuccessHandler("https://www.baidu.com/"))
//                .failureHandler(new MyAuthenticationFailureHandler("/error.html"));
                .successForwardUrl("/toMain")
                .failureForwardUrl("/toError");

        //任何请求都需要进行认证
        http.authorizeRequests()
                //不需要认证的页面
                .antMatchers("/login.html").permitAll()
                .antMatchers("/error.html").permitAll()
                //权限的简单控制
//                .antMatchers("/userDetail.html").hasAnyAuthority("admin1")
                //角色控制
//                .antMatchers("/userDetail.html").hasRole("abc")
                //基于ip的控制
//                .antMatchers("/userDetail.html").hasIpAddress("127.0.0.1")
//                .anyRequest().authenticated();
        .anyRequest().access("@myServiceImpl.hasPermission(request,authentication)");
    }

//    @Bean
//    public AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
