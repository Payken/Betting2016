package com.ai.config;

import com.ai.handlers.AuthSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.ai.config.*;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean(name = "springSecurityDialect")
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }
    @Autowired
    private UserDetService userDet;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("user").roles("USER").and().withUser("admin").password("admin").roles("ADMIN");
        auth.userDetailsService(userDet);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AuthSuccessHandler lolo = new AuthSuccessHandler();
        http
                .formLogin().loginPage("/login").failureUrl("/login?error")
                .usernameParameter("login").passwordParameter("password").permitAll().successHandler(lolo)
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll().permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/manager**").hasAnyAuthority("Admin", "MANAGER")
                .antMatchers("/user**").hasAnyAuthority("Admin", "Administrator Bezpieczenstwa Informacji W Organizacji")
                .antMatchers("/admin**").hasAuthority("Admin")
                .antMatchers("/search**").hasAnyAuthority("Admin");
        http.csrf().disable();
    }
}