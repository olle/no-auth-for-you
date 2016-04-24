package com.studiomediatech.bugs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;


@SpringBootApplication
public class NoAuthForYouApplication {

    public static void main(String[] args) {

        SpringApplication.run(NoAuthForYouApplication.class, args);
    }

    @Configuration
    public static class WebConfig extends WebMvcAutoConfigurationAdapter {

        @Override
        public void addInterceptors(InterceptorRegistry registry) {

            registry.addInterceptor(new LoggingHandlerInterceptor()).addPathPatterns("/**");
        }
    }

    @Configuration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public static class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.authorizeRequests().antMatchers("/**").authenticated();
            http.formLogin().permitAll();
            http.csrf().disable();
        }


        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {

            auth.inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN", "USER");
        }
    }
}
